package com.comakeit.ems.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comakeit.ems.bean.AdminBean;
import com.comakeit.ems.dao.ValidationDao;

@RestController
@RequestMapping(value = "restlogin")
public class LoginRestController {

	@Autowired
	ValidationDao vd;

	/*
	 * To validate the username and password and tell whether it is a manager ,
	 * employee or admin which calls ValidationDao to perform this function
	 */
	@RequestMapping(value = "/restvalidate")
	public String validate(@RequestBody AdminBean adminbean) {

		String result = vd.get(adminbean);

		return result;
	}
}
