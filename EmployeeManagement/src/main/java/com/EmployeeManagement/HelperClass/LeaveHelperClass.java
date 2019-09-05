package com.EmployeeManagement.HelperClass;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.EmployeeManagement.bean.LeaveBean;

@Service
public class LeaveHelperClass {
	@Autowired
	Environment environment;
	/*
	 * To apply leave as an employee or manager which calls restempleave in empleaverestcontroller to perform this function
	 */
	public String empleave(LeaveBean leavebean, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		leavebean.setEmpname(name);
		RestTemplate rt = new RestTemplate();
		String port = environment.getProperty("local.server.port");
		String result = rt.postForObject("http://localhost:"+port+"/restleave/restempleave", leavebean, String.class);
		return result;

	}
	/*
	 * To retrieve a list of employee under a particular manager to grant permission for leave which calls restgrantleave in empleaverestcontroller to perform this function
	 */
	
	public List<LeaveBean> grantleave(LeaveBean leavebean, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		leavebean.setEmpname(name);
			HttpEntity<LeaveBean> requestEntity = new HttpEntity<>(leavebean);
			RestTemplate restTemplate = new RestTemplate();
			String port = environment.getProperty("local.server.port");
			ResponseEntity<List<LeaveBean>> response = restTemplate.exchange(
					"http://localhost:"+port+"/restleave/restgrantleave", HttpMethod.POST, requestEntity,
					new ParameterizedTypeReference<List<LeaveBean>>() {
					});
			List<LeaveBean> list = response.getBody();
			return list;

		
	}
	/*
	 * To accept or reject the leave by the manager which calls restgrant in empleaverestcontroller to perform this function
	 */
	public List<LeaveBean> grantpermission(@RequestParam("status") String status, @RequestParam("id") int id,
			LeaveBean leavebean, HttpServletRequest request) {
		leavebean.setLeaveid(id);
		leavebean.setStatus(status);
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		leavebean.setEmpname(name);
		RestTemplate rt = new RestTemplate();
		HttpEntity<LeaveBean> requestEntity = new HttpEntity<>(leavebean);
		String port = environment.getProperty("local.server.port");
		ResponseEntity<List<LeaveBean>> result = rt.exchange("http://localhost:"+port+"/restleave/restgrant",
				HttpMethod.POST, requestEntity, new ParameterizedTypeReference<List<LeaveBean>>() {
				});
		List<LeaveBean> list = result.getBody();
		return list;

	}
	/*
	 * To check status for the applied leave which calls restcheckstatus in empleaverestcontroller to perform this function
	 */
	public List<LeaveBean> checkstatus(LeaveBean leavebean, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		leavebean.setEmpname(name);
		HttpEntity<LeaveBean> requestEntity = new HttpEntity<>(leavebean);
		RestTemplate restTemplate = new RestTemplate();
		String port = environment.getProperty("local.server.port");
		ResponseEntity<List<LeaveBean>> response = restTemplate.exchange(
				"http://localhost:"+port+"/restleave/restcheckstatus", HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<List<LeaveBean>>() {
				});
		List<LeaveBean> list = response.getBody();
		return list;
	}
}
