package com.EmployeeManagement.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.EmployeeManagement.repo.Crud;
import com.comakeit.ems.bean.EmpBean;
import com.comakeit.ems.bean.LeaveBean;

@Component
public class GrantLeaveDao {

	@Autowired
	private Crud crud;

	/*
	 * To retrieve a list of employee under a particular manager to grant permission
	 * for leave which calls crud to perform this function
	 */
	public List<LeaveBean> grantleave(LeaveBean leavebean) {

		List<EmpBean> user = crud.getuser(leavebean.getEmpname());

		List<String> empnames = new ArrayList<>();

		for (EmpBean x : user) {
			empnames.add(x.getEmpname());
		}

		List<LeaveBean> list = crud.listtograntleave(empnames);

		return list;
	}

}
