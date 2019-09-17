package com.comakeit.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comakeit.ems.bean.EmpBean;
import com.comakeit.ems.repo.Emp;

@Component
public class ListEmp {

	@Autowired
	private Emp emprepo;

	public List<EmpBean> listempbyid() {

		List<EmpBean> list = emprepo.getlistofempbyid();

		return list;
	}

	public List<EmpBean> listempbydepart() {

		List<EmpBean> list = emprepo.getlistofempbydepart();

		return list;
	}

	public List<EmpBean> listempwithpf() {

		List<EmpBean> list = emprepo.findAll();

		return list;
	}

	public List<EmpBean> listempreport(EmpBean empbean) {

		List<EmpBean> list = emprepo.getlistofempbywithreport(empbean.getReportingmanager());

		return list;
	}

	public List<EmpBean> listemprange() {

		List<EmpBean> list = emprepo.getlistofemprange();

		return list;
	}

}
