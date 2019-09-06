package com.EmployeeManagement.Controllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.EmployeeManagement.HelperClass.HelperClass;
import com.EmployeeManagement.bean.EmpBean;

@Controller
public class ListEmpController {

	@Autowired
	Environment environment;
	@Autowired
	HelperClass helperclass;

	/*
	 * To retrieve a list of employee details order by employee id which calls
	 * listempbyid in HelperClass to perform this function
	 */
	@RequestMapping(value = "/listempbyid")
	public ModelAndView listempbyid() {

		ResponseEntity<List<EmpBean>> x = helperclass.listempbyid();

		ModelAndView mv = new ModelAndView("Display");
		mv.addObject("object", x.getBody());

		return mv;

	}

	/*
	 * To retrieve a list of employee details order by department name which calls
	 * listempbydepart in HelperClass to perform this function
	 */
	@RequestMapping(value = "/listempbydepart")
	public ModelAndView listempbydepart() {

		ResponseEntity<List<EmpBean>> x = helperclass.listempbydepart();

		ModelAndView mv = new ModelAndView("Display");
		mv.addObject("object", x.getBody());

		return mv;

	}

	/*
	 * To retrieve a list of employee details under a particular manager which calls
	 * listempbyreport in HelperClass to perform this function
	 */
	@RequestMapping(value = "/listempbyreport")
	public ModelAndView listempbyreport(EmpBean empbean, HttpServletRequest request) {

		List<EmpBean> list = helperclass.listempbyreport(empbean, request);

		ModelAndView mv = new ModelAndView("Display");
		mv.addObject("object", list);

		return mv;

	}

	/*
	 * To retrieve a list of employee details with pf which calls listempwithpf in
	 * HelperClass to perform this function
	 */
	@RequestMapping(value = "/listwithpf")
	public ModelAndView listempwithpf() {

		ResponseEntity<List<EmpBean>> x = helperclass.listempwithpf();

		ModelAndView mv = new ModelAndView("EmpDetailswithpf");
		mv.addObject("object", x.getBody());

		return mv;

	}

	/*
	 * To retrieve a list of employee details whose salary range between 10000 and
	 * 20000 which calls listempwithrange in HelperClass to perform this function
	 */
	@RequestMapping(value = "/listwithrange")
	public ModelAndView listempwithrange() {

		ResponseEntity<List<EmpBean>> x = helperclass.listempwithrange();

		ModelAndView mv = new ModelAndView("Display");
		mv.addObject("object", x.getBody());

		return mv;

	}
}
