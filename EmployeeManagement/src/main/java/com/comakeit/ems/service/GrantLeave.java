package com.comakeit.ems.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comakeit.ems.bean.EmpBean;
import com.comakeit.ems.bean.LeaveBean;
import com.comakeit.ems.repo.Emp;
import com.comakeit.ems.repo.Leave;

@Component
public class GrantLeave {

	@Autowired
	private Emp emprepo;
	@Autowired
	private Leave leaverepo;

	public List<LeaveBean> grantleave(LeaveBean leavebean) {

		List<EmpBean> user = emprepo.getuser(leavebean.getEmpname());

		List<String> empnames = new ArrayList<>();

		for (EmpBean x : user) {
			empnames.add(x.getEmpname());
		}

		List<LeaveBean> list = leaverepo.getlisttogrant(empnames);

		return list;
	}

}
