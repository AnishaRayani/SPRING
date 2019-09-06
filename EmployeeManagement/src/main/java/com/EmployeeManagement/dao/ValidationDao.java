package com.EmployeeManagement.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.EmployeeManagement.bean.AdminBean;
import com.EmployeeManagement.bean.EmpBean;
import com.EmployeeManagement.repo.Crud;

@Component
public class ValidationDao {

	@Autowired
	private Crud crud;

	/*
	 * To validate the username and password and tell whether it is a manager ,
	 * employee or admin which calls crud to perform this function
	 */
	public String get(AdminBean adminbean) {

		String name = adminbean.getusername();

		String list = crud.getAdminUsername(adminbean);

		if (list == null) {

			return "index";
		} else {

			if (list.equals("admin")) {

				return "AdminOptions";
			} else {

				List<EmpBean> user = crud.getuser(name);

				if (user.isEmpty())

					return "EmployeeLeave";

				else

					return "ManagerLeave";
			}

		}

	}

}