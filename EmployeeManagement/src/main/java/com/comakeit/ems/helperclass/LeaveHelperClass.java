package com.comakeit.ems.helperclass;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.comakeit.ems.bean.LeaveBean;
import com.comakeit.ems.constants.Constants;

@Service
public class LeaveHelperClass {

	
	
	public String empleave(LeaveBean leavebean, HttpServletRequest request) {

		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");

		leavebean.setEmpname(name);

		RestTemplate rt = new RestTemplate();

		String result = rt.postForObject(Constants.url + "/restleave/restempleave", leavebean,
				String.class);

		return result;

	}

	public List<LeaveBean> grantleave(LeaveBean leavebean, HttpServletRequest request) {

		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");

		leavebean.setEmpname(name);

		HttpEntity<LeaveBean> requestEntity = new HttpEntity<>(leavebean);
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<LeaveBean>> response = restTemplate.exchange(
				Constants.url + "/restleave/restgrantleave", HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<List<LeaveBean>>() {
				});
		List<LeaveBean> list = response.getBody();

		return list;

	}

	
	public List<LeaveBean> grantpermission(@RequestParam("status") String status, @RequestParam("id") int id,
			LeaveBean leavebean, HttpServletRequest request) {

		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");

		leavebean.setEmpname(name);
		leavebean.setLeaveid(id);
		leavebean.setStatus(status);

		RestTemplate rt = new RestTemplate();
		HttpEntity<LeaveBean> requestEntity = new HttpEntity<>(leavebean);

		ResponseEntity<List<LeaveBean>> result = rt.exchange(Constants.url + "/restleave/restgrant",
				HttpMethod.POST, requestEntity, new ParameterizedTypeReference<List<LeaveBean>>() {
				});
		List<LeaveBean> list = result.getBody();

		return list;

	}

	
	public List<LeaveBean> checkstatus(LeaveBean leavebean, HttpServletRequest request) {

		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");

		leavebean.setEmpname(name);

		HttpEntity<LeaveBean> requestEntity = new HttpEntity<>(leavebean);
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<LeaveBean>> response = restTemplate.exchange(
				Constants.url + "/restleave/restcheckstatus", HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<List<LeaveBean>>() {
				});
		List<LeaveBean> list = response.getBody();

		return list;
	}
}
