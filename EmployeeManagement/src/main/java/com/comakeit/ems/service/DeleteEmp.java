package com.comakeit.ems.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comakeit.ems.bean.AdminBean;
import com.comakeit.ems.bean.EmpBean;
import com.comakeit.ems.repo.Emp;
import com.comakeit.ems.repo.LoginValidation;

@Component
public class DeleteEmp {

	@Autowired
	private LoginValidation repo;
	@Autowired
	private Emp emprepo;

	public String deleteemp(String id2) {

		Optional<EmpBean> id = emprepo.findById(id2);
		AdminBean adminbean = new AdminBean();
		if (id.isEmpty()) {
			return "ERROR";
			

		} else {

			List<EmpBean> list = emprepo.getemp(id2);
			for (EmpBean b : list) {

				String name = b.getEmpname();
				adminbean.setusername(name);

			}
			repo.delete(adminbean);
			emprepo.deleteById(id2);
			if (list != null) {
				
				return "SUCCESS";

			}
		}
		return null;
		
	}
}
