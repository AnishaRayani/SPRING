package com.EmployeeManagement.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.EmployeeManagement.bean.AdminBean;
import com.EmployeeManagement.bean.EmpBean;

@Controller
public class EmpController {
	@Autowired
	Environment environment;
	/*
	 * To add an employee which calls restadd in emprestcontroller to perform this function 
	 */
	@RequestMapping(value = "/add")
	public ModelAndView addemp(EmpBean empbean, AdminBean adminbean) {
		RestTemplate rt = new RestTemplate();
		String port = environment.getProperty("local.server.port");
		EmpBean result = rt.postForObject("http://localhost:"+port+"/restadd", empbean, EmpBean.class);
		if (result != null) {
			ModelAndView mv = new ModelAndView("AddEmpSuccess");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("AddEmp");
			mv.addObject("errMessage", "INVALID EMAILID OR DUPLICATE ENTRY OF EMPID");
			return mv;

		}

	}
	/*
	 * To delete an employee which calls restdelete in emprestcontroller to perform this function 
	 */
	@RequestMapping(value = "/delete")
	public ModelAndView deleteemp(EmpBean empbean) {
		RestTemplate rt = new RestTemplate();
		String port = environment.getProperty("local.server.port");
		String result = rt.postForObject("http://localhost:"+port+"/restdelete", empbean, String.class);
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
