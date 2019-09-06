package com.EmployeeManagement.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.EmployeeManagement.bean.EmpBean;
import com.EmployeeManagement.repo.Crud;

@Component
public class ListEmpDao {

	@Autowired
	private Crud crud;

	/*
	 * To retrieve a list of employee details order by employee id which calls crud
	 * to perform this function
	 */
	public List<EmpBean> listempbyid() {

		List<EmpBean> list = crud.listEmployee();

		return list;
	}

	/*
	 * To retrieve a list of employee details order by department name which calls
	 * crud to perform this function
	 */
	public List<EmpBean> listempbydepart() {

		List<EmpBean> list = crud.listEmployeebydepart();

		return list;
	}

	/*
	 * To retrieve a list of employee details with pf which calls crud to perform
	 * this function
	 */
	public List<EmpBean> listempwithpf() {

		List<EmpBean> list = crud.listEmployeewithpf();

		return list;
	}

	/*
	 * To retrieve a list of employee details under a particular manager which calls
	 * crud to perform this function
	 */
	public List<EmpBean> listempreport(EmpBean empbean) {

		List<EmpBean> list = crud.listEmployeewithreport(empbean);

		return list;
	}

	/*
	 * To retrieve a list of employee details whose salary range between 10000 and
	 * 20000 which calls crud to perform this function
	 */
	public List<EmpBean> listemprange() {

		List<EmpBean> list = crud.listEmployeerange();

		return list;
	}

}
