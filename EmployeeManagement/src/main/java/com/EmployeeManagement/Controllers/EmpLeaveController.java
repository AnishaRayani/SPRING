package com.EmployeeManagement.Controllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.EmployeeManagement.HelperClass.LeaveHelperClass;
import com.EmployeeManagement.bean.LeaveBean;

@Controller
public class EmpLeaveController {
	@Autowired
	Environment environment;
	@Autowired
	LeaveHelperClass leavehelperclass;

	/*
	 * To apply leave as an employee or manager which calls empleave in
	 * LeaveHelperClass to perform this function
	 */
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

	/*
	 * To retrieve a list of employee under a particular manager to grant permission
	 * for leave which calls grantleave in LeaveHelperClass to perform this function
	 */
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

	/*
	 * To accept or reject the leave by the manager which calls grantpermission in
	 * LeaveHelperClass to perform this function
	 */
	@RequestMapping(value = "/grantpermission")
	public ModelAndView grantpermission(@RequestParam("status") String status, @RequestParam("id") int id,
			LeaveBean leavebean, HttpServletRequest request) {

		List<LeaveBean> result = leavehelperclass.grantpermission(status, id, leavebean, request);

		if (result.isEmpty()) {

			ModelAndView mv = new ModelAndView("GrantLeave");
			mv.addObject("errMessage", "ERROR !!!!");

			return mv;

		} else {

			ModelAndView mv = new ModelAndView("GrantLeave");
			mv.addObject("object", result);

			return mv;
		}
	}

	/*
	 * To check status for the applied leave which calls checkstatus in
	 * LeaveHelperClass to perform this function
	 */
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
