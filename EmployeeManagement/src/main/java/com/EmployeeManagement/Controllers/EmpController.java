package com.EmployeeManagement.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.EmployeeManagement.HelperClass.HelperClass;
import com.comakeit.ems.AdminBean;
import com.comakeit.ems.EmpBean;

@Controller
public class EmpController {
	@Autowired
	Environment environment;
	@Autowired
	HelperClass helperclass;

	/*
	 * To add an employee which calls addemp in HelperClass to perform this function
	 */
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

	/*
	 * To delete an employee which calls restdelete in emprestcontroller to perform
	 * this function
	 */
	@RequestMapping(value = "/delete")
	public ModelAndView deleteemp(EmpBean empbean) {

		String result = helperclass.deleteemp(empbean);

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
