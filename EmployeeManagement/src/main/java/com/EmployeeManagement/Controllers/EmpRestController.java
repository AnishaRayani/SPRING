package com.EmployeeManagement.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.EmployeeManagement.bean.EmpBean;
import com.EmployeeManagement.dao.AddEmpDao;
import com.EmployeeManagement.dao.DeleteEmpdao;

@RestController
public class EmpRestController {

	@Autowired
	AddEmpDao add;
	@Autowired
	DeleteEmpdao delete;

	/*
	 * To add an employee which calls AddEmpDao to perform this function
	 */
	@RequestMapping(value = "/restadd")
	public EmpBean addemp(@RequestBody EmpBean empbean) {

		EmpBean result = add.addemp(empbean);

		return result;
	}

	/*
	 * To delete an employee which calls DeleteEmpdao to perform this function
	 */
	@RequestMapping(value = "/restdelete")
	public String deleteemp(@RequestBody EmpBean empbean) {

		String result = delete.deleteemp(empbean);

		return result;
	}
}
