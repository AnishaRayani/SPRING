package com.comakeit.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comakeit.ems.bean.LeaveBean;
import com.comakeit.ems.repo.Leave;

@Component
public class AddEmpLeave {

	@Autowired
	private Leave leaverepo;

	public LeaveBean addempleave(LeaveBean leavebean) {
		leavebean.setStatus("pending");
		LeaveBean list = leaverepo.save(leavebean);

		return list;
	}

}
