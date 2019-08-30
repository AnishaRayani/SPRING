package com.EmployeeManagement.dao;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.EmployeeManagement.bean.EmpBean;
import com.EmployeeManagement.repo.Crud;
import com.EmployeeManagement.repo.EmpRepository;

@Component
public class AddEmpDao {
	@Autowired
	private Crud crud;
	@Autowired
	private EmpRepository emprepo;
/*
 * To add an employee which calls crud to perform this function
 */
	public EmpBean addemp(EmpBean empbean) {

		Optional<EmpBean> id = emprepo.findById(empbean.getEmpid());
		if (id.isEmpty()) {
			Pattern pattern;
			Matcher matcher;
			pattern = Pattern.compile(
					"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@+[A-Za-z0-9-]+(\\.[A-Za-z]{2,3})?(\\.[A-Za-z]{2,3})$");
			matcher = pattern.matcher(empbean.getEmail());
			if (matcher.matches()) {
				EmpBean list = crud.saveEmployee(empbean);
				return list;
			}
		}
		return null;

	}
}
