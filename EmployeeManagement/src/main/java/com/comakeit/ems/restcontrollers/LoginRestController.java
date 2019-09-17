package com.comakeit.ems.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comakeit.ems.bean.AdminBean;
import com.comakeit.ems.service.Login;

@RestController
@RequestMapping(value = "restlogin")
public class LoginRestController {

	@Autowired
	Login login;

	@PostMapping(value = "/restvalidate")
	public String validate(@RequestBody AdminBean adminbean) {

		String result = login.get(adminbean);

		return result;
	}
}
