package com.EmployeeManagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.EmployeeManagement.repo.Crud;
import com.comakeit.ems.LeaveBean;

@Component
public class AddEmpLeaveDao {

	@Autowired
	private Crud crud;

	/*
	 * To apply leave as an employee or manager which calls crud to perform this
	 * function
	 */
	public LeaveBean addempleave(LeaveBean leavebean) {

		LeaveBean list = crud.saveEmpleave(leavebean);

		return list;
	}

}
