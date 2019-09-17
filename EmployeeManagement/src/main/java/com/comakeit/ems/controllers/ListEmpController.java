package com.comakeit.ems.controllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.comakeit.ems.bean.EmpBean;
import com.comakeit.ems.helperclass.HelperClass;

@Controller
public class ListEmpController {

	@Autowired
	HelperClass helperclass;

	@RequestMapping(value = "/listempbyid")
	public ModelAndView listempbyid() {

		ResponseEntity<List<EmpBean>> x = helperclass.listempbyid();

		ModelAndView mv = new ModelAndView("Display");
		mv.addObject("object", x.getBody());

		return mv;

	}

	@RequestMapping(value = "/listempbydepart")
	public ModelAndView listempbydepart() {

		ResponseEntity<List<EmpBean>> x = helperclass.listempbydepart();

		ModelAndView mv = new ModelAndView("Display");
		mv.addObject("object", x.getBody());

		return mv;

	}

	@RequestMapping(value = "/listempbyreport")
	public ModelAndView listempbyreport(EmpBean empbean, HttpServletRequest request) {

		List<EmpBean> list = helperclass.listempbyreport(empbean, request);

		ModelAndView mv = new ModelAndView("Display");
		mv.addObject("object", list);

		return mv;

	}

	@RequestMapping(value = "/listwithpf")
	public ModelAndView listempwithpf() {

		ResponseEntity<List<EmpBean>> x = helperclass.listempwithpf();

		ModelAndView mv = new ModelAndView("EmpDetailswithpf");
		mv.addObject("object", x.getBody());

		return mv;

	}

	@RequestMapping(value = "/listwithrange")
	public ModelAndView listempwithrange() {

		ResponseEntity<List<EmpBean>> x = helperclass.listempwithrange();

		ModelAndView mv = new ModelAndView("Display");
		mv.addObject("object", x.getBody());

		return mv;

	}
}
