package com.comakeit.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comakeit.ems.bean.AdminBean;
import com.comakeit.ems.bean.EmpBean;
import com.comakeit.ems.repo.Emp;
import com.comakeit.ems.repo.LoginValidation;

@Component
public class Login {

	@Autowired
	private LoginValidation login;
	@Autowired
	private Emp emprepo;

	public String get(AdminBean adminbean) {

		String name = adminbean.getusername();

		String list = login.getAdminUsername(adminbean.getusername(), adminbean.getPassword());

		if (list == null) {

			return "index";
		} else {

			if (list.equals("admin")) {

				return "AdminOptions";
			} else {

				List<EmpBean> user = emprepo.getuser(name);

				if (user.isEmpty())

					return "EmployeeLeave";

				else

					return "ManagerLeave";
			}

		}

	}

	

}