package com.comakeit.ems.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.comakeit.ems.bean.AdminBean;
import com.comakeit.ems.helperclass.HelperClass;

@Controller
public class LoginController {

	
	@Autowired
	HelperClass helperclass;
	
	@RequestMapping(value = "/validate")
	public ModelAndView validate(AdminBean adminbean, HttpServletRequest request) {

		HttpSession session = request.getSession();
		session.setAttribute("name", adminbean.getusername());

		String result = helperclass.validate(adminbean, request);

		if (result.equals("index")) {

			ModelAndView mv = new ModelAndView("index");
			mv.addObject("errMessage", "INVALID USERNAME OR PASSWORD");

			return mv;
		} else if (result.equals("AdminOptions")) {

			ModelAndView mv = new ModelAndView("AdminOptions");

			return mv;
		} else if (result.equals("EmployeeLeave")) {

			ModelAndView mv = new ModelAndView("EmployeeLeave");

			return mv;
		} else {

			ModelAndView mv = new ModelAndView("ManagerLeave");

			return mv;
		}

	}

	
	@RequestMapping(value = "/logout")
	public ModelAndView logout() {

		ModelAndView mv = new ModelAndView("index");
		mv.addObject("errMessage", "You have logged out successfully");

		return mv;

	}
}