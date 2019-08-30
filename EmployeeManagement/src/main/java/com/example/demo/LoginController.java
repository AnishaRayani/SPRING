package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.EmployeeManagement.bean.AdminBean;

@Controller
public class LoginController {
	@Autowired
	Environment environment;
	/*
	 * To validate the username and password and tell whether it is a manager , employee or admin which calls restvalidate in loginrestcontroller to perform this function
	 */
	@RequestMapping(value = "/validate")
	public ModelAndView validate(AdminBean adminbean, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("name", adminbean.getusername());
		RestTemplate rt = new RestTemplate();
		String port = environment.getProperty("local.server.port");
		String result = rt.postForObject("http://localhost:"+port+"/restlogin/restvalidate", adminbean, String.class);
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
	/*
	 * TO LOGOUT FROM THE SESSION
	 */
	@RequestMapping(value = "/logout")
	public ModelAndView logout() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("errMessage", "You have logged out successfully");
		return mv;

	}
}