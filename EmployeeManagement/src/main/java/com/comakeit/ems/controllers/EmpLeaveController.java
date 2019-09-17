package com.comakeit.ems.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.comakeit.ems.bean.LeaveBean;
import com.comakeit.ems.helperclass.LeaveHelperClass;

@Controller
public class EmpLeaveController {
	
	@Autowired
	LeaveHelperClass leavehelperclass;

	
	@RequestMapping(value = "/empleave")
	public ModelAndView empleave(LeaveBean leavebean, HttpServletRequest request) {

		String result = leavehelperclass.empleave(leavebean, request);

		if (result != null) {

			ModelAndView mv = new ModelAndView("LeaveAppliedSuccess");

			return mv;
		} else {

			ModelAndView mv = new ModelAndView("ApplyEmpLeave");
			mv.addObject("errMessage", "ERROR !! LEAVE NOT APPLIED");

			return mv;
		}
	}

	
	@RequestMapping(value = "/grantleave")
	public ModelAndView grantleave(LeaveBean leavebean, HttpServletRequest request) {

		List<LeaveBean> list = leavehelperclass.grantleave(leavebean, request);

		if (list.isEmpty()) {

			ModelAndView mv = new ModelAndView("ManagerLeave");
			mv.addObject("errMessage", "THE LIST IS EMPTY ");

			return mv;
		} else {

			ModelAndView mv = new ModelAndView("GrantLeave");
			mv.addObject("object", list);

			return mv;
		}

	}

	
	@RequestMapping(value = "/grantpermission")
	public ModelAndView grantpermission(@RequestParam("status") String status, @RequestParam("id") int id,
			LeaveBean leavebean, HttpServletRequest request) {

		List<LeaveBean> result = leavehelperclass.grantpermission(status, id, leavebean, request);

		if (result.isEmpty()) {

			ModelAndView mv = new ModelAndView("ManagerLeave");
			mv.addObject("errMessage", "ERROR !!!! The List is Empty");

			return mv;

		} else {

			ModelAndView mv = new ModelAndView("GrantLeave");
			mv.addObject("object", result);

			return mv;
		}
	}

	
	@RequestMapping(value = "/checkstatus")
	public ModelAndView checkstatus(LeaveBean leavebean, HttpServletRequest request) {

		List<LeaveBean> list = leavehelperclass.checkstatus(leavebean, request);

		if (list.isEmpty()) {

			ModelAndView mv = new ModelAndView("ManagerLeave");
			mv.addObject("errMessage", "THE LIST IS EMPTY ");

			return mv;
		} else {

			ModelAndView mv = new ModelAndView("CheckStatus");
			mv.addObject("object", list);

			return mv;
		}
	}
}
