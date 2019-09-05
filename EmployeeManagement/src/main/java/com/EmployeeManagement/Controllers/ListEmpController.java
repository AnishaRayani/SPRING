package com.EmployeeManagement.Controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.EmployeeManagement.bean.EmpBean;

@Controller
public class ListEmpController {
	@Autowired
	Environment environment;

	/*
	 * To retrieve a list of employee details order by employee id which calls
	 * restlistempbyid in listemprestcontroller to perform this function
	 */
	@RequestMapping(value = "/listempbyid")
	public ModelAndView listempbyid() {

		RestTemplate rt = new RestTemplate();
		String port = environment.getProperty("local.server.port");
		String location = "http://localhost:" + port + "/restlist/restlistempbyid";
		ResponseEntity<List<EmpBean>> x = rt.exchange(location, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<EmpBean>>() {
				});

		ModelAndView mv = new ModelAndView("Display");
		mv.addObject("object", x.getBody());
		return mv;

	}

	/*
	 * To retrieve a list of employee details order by department name which calls
	 * restlistempbydepart in listemprestcontroller to perform this function
	 */
	@RequestMapping(value = "/listempbydepart")
	public ModelAndView listempbydepart() {

		RestTemplate rt = new RestTemplate();
		String port = environment.getProperty("local.server.port");
		String location = "http://localhost:" + port + "/restlist/restlistempbydepart";
		ResponseEntity<List<EmpBean>> x = rt.exchange(location, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<EmpBean>>() {
				});

		ModelAndView mv = new ModelAndView("Display");
		mv.addObject("object", x.getBody());
		return mv;

	}

	/*
	 * To retrieve a list of employee details under a particular manager which calls
	 * restlistempbyreport in listemprestcontroller to perform this function
	 */
	@RequestMapping(value = "/listempbyreport")
	public ModelAndView addemp(EmpBean empbean, HttpServletRequest request) {
		request.getSession().setAttribute("report", empbean.getReportingmanager());
		HttpEntity<EmpBean> requestEntity = new HttpEntity<>(empbean);
		RestTemplate restTemplate = new RestTemplate();
		String port = environment.getProperty("local.server.port");
		ResponseEntity<List<EmpBean>> response = restTemplate.exchange(
				"http://localhost:" + port + "/restlist/restlistempbyreport", HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<List<EmpBean>>() {
				});
		List<EmpBean> list = response.getBody();
		ModelAndView mv = new ModelAndView("Display");
		mv.addObject("object", list);
		return mv;

	}

	/*
	 * To retrieve a list of employee details with pf which calls restlistempwithpf
	 * in listemprestcontroller to perform this function
	 */
	@RequestMapping(value = "/listwithpf")
	public ModelAndView listempwithpf() {
		RestTemplate rt = new RestTemplate();
		String port = environment.getProperty("local.server.port");
		String location = "http://localhost:" + port + "/restlist/restlistempwithpf";
		ResponseEntity<List<EmpBean>> x = rt.exchange(location, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<EmpBean>>() {
				});

		ModelAndView mv = new ModelAndView("EmpDetailswithpf");
		mv.addObject("object", x.getBody());
		return mv;

	}

	/*
	 * To retrieve a list of employee details whose salary range between 10000 and
	 * 20000 which calls restlistemprange in listemprestcontroller to perform this
	 * function
	 */
	@RequestMapping(value = "/listwithrange")
	public ModelAndView listempwithrange() {

		RestTemplate rt = new RestTemplate();
		String port = environment.getProperty("local.server.port");
		String location = "http://localhost:" + port + "/restlist/restlistemprange";
		ResponseEntity<List<EmpBean>> x = rt.exchange(location, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<EmpBean>>() {
				});

		ModelAndView mv = new ModelAndView("Display");
		mv.addObject("object", x.getBody());
		return mv;

	}
}