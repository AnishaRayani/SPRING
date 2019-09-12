package com.EmployeeManagement.dao;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.EmployeeManagement.repo.Crud;
import com.EmployeeManagement.repo.EmpRepository;
import com.comakeit.ems.EmpBean;

@Component
public class DeleteEmpdao {

	@Autowired
	private Crud crud;
	@Autowired
	private EmpRepository emprepo;

	/*
	 * To delete an employee which calls crud to perform this function
	 */
	public String deleteemp(EmpBean empbean) {

		Optional<EmpBean> id = emprepo.findById(empbean.getEmpid());

		if (id.isEmpty()) {

			return "error";

		} else {

			String list = crud.deleteEmployee(empbean);

			if (list != null) {

				return "SUCCESS";

			}
		}
		return "error";
	}
}
