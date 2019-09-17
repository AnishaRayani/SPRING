package com.comakeit.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comakeit.ems.bean.LeaveBean;
import com.comakeit.ems.repo.Leave;

@Component
public class CheckStatus {

	@Autowired
	private Leave leaverepo;

	public List<LeaveBean> checkstatus(LeaveBean leavebean) {

		List<LeaveBean> list = leaverepo.checkstatus(leavebean.getEmpname());

		return list;
	}
}
