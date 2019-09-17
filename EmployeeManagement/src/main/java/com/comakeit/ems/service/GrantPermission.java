package com.comakeit.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comakeit.ems.bean.LeaveBean;
import com.comakeit.ems.repo.Leave;

@Component
public class GrantPermission {

	@Autowired
	private Leave leaverepo;

	public String grantpermission(LeaveBean leavebean) {

		leaverepo.grantpermission(leavebean.getLeaveid(), leavebean.getStatus());

		return "SUCCESS";
	}
}
