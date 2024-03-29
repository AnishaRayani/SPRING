package com.comakeit.ems.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.comakeit.ems.bean.AdminBean;
import com.comakeit.ems.bean.EmpBean;
import com.comakeit.ems.helperclass.HelperClass;

@Controller
public class EmpController {
	
	@Autowired
	HelperClass helperclass;

	@RequestMapping(value = "/add")
	public ModelAndView addemp(EmpBean empbean, AdminBean adminbean) {

		EmpBean result = helperclass.addemp(empbean, adminbean);

		if (result != null) {

			ModelAndView mv = new ModelAndView("AddEmpSuccess");

			return mv;
		} else {

			ModelAndView mv = new ModelAndView("AddEmp");
			mv.addObject("errMessage", "INVALID EMAILID OR DUPLICATE ENTRY OF EMPID");

			return mv;

		}

	}

	@RequestMapping(value = "/delete")
	public ModelAndView deleteemp(EmpBean empbean) {

		String result=helperclass.deleteemp(empbean);
		
		if (result.equals("SUCCESS")) {

			ModelAndView mv = new ModelAndView("DeleteEmpSuccess");

			return mv;
		} else {

			ModelAndView mv = new ModelAndView("DeleteEmp");
			mv.addObject("errMessage", "INVALID EMPID");

			return mv;
		}
	}
}
