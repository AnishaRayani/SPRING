package com.comakeit.ems.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comakeit.ems.bean.LeaveBean;
import com.comakeit.ems.repo.Crud;

@Component
public class GrantPermissionDao {

	@Autowired
	private Crud crud;

	/*
	 * To accept or reject the leave by the manager which calls crud to perform this
	 * function
	 */
	public String grantpermission(LeaveBean leavebean) {

		String list = crud.grantpermission(leavebean);

		return list;
	}
}
