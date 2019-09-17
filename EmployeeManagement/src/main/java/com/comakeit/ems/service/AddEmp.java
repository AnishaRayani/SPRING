package com.comakeit.ems.service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comakeit.ems.bean.AdminBean;
import com.comakeit.ems.bean.EmpBean;
import com.comakeit.ems.repo.Emp;
import com.comakeit.ems.repo.LoginValidation;

@Component
public class AddEmp {

	@Autowired
	private LoginValidation repo;
	@Autowired
	private Emp emprepo;

	public EmpBean addemp(EmpBean empbean) {

		Optional<EmpBean> id = emprepo.findById(empbean.getEmpid());

		if (id.isEmpty()) {

			Pattern pattern;
			Matcher matcher;
			pattern = Pattern.compile(
					"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@+[A-Za-z0-9-]+(\\.[A-Za-z]{2,3})?(\\.[A-Za-z]{2,3})$");
			matcher = pattern.matcher(empbean.getEmail());

			if (matcher.matches()) {
				AdminBean adminbean = new AdminBean();

				adminbean.setusername(empbean.getEmpname());
				adminbean.setPassword(empbean.getEmpname() + "123");
				adminbean.setRole("user");

				repo.save(adminbean);
				EmpBean list = emprepo.save(empbean);

				return list;
			}
		}
		return empbean;

	}
}
