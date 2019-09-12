package com.EmployeeManagement.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.EmployeeManagement.repo.Crud;
import com.comakeit.ems.bean.LeaveBean;

@Component
public class CheckStatusDao {

	@Autowired
	private Crud crud;

	/*
	 * To check status for the applied leave which calls crud to perform this
	 * function
	 */
	public List<LeaveBean> checkstatus(LeaveBean leavebean) {

		List<LeaveBean> list = crud.checkstatus(leavebean);

		return list;
	}
}
