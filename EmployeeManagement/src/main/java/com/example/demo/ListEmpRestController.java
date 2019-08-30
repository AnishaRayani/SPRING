package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeManagement.bean.EmpBean;
import com.EmployeeManagement.dao.ListEmpDao;

@RestController
@RequestMapping(value = "restlist")
public class ListEmpRestController {
	@Autowired
	ListEmpDao vd;
	/*
	 * To retrieve a list of employee details order by employee id which calls ListEmpDao to perform this function
	 */
	@RequestMapping(value = "/restlistempbyid")
	public List<EmpBean> listempbyid() {
		List<EmpBean> result = vd.listempbyid();
		return result;
	}
	/*
	 * To retrieve a list of employee details order by department name which calls ListEmpDao to perform this function
	 */
	@RequestMapping(value = "/restlistempbydepart")
	public List<EmpBean> listempbydepart() {
		List<EmpBean> result = vd.listempbydepart();
		return result;
	}
	/*
	 * To retrieve a list of employee details under a particular manager which calls ListEmpDao to perform this function
	 */
	@RequestMapping(value = "/restlistempbyreport")
	public List<EmpBean> listempreport(@RequestBody EmpBean empbean) {
		List<EmpBean> result = vd.listempreport(empbean);
		return result;
	}
	/*
	 * To retrieve a list of employee details with pf which calls ListEmpDao to perform this function
	 */
	@RequestMapping(value = "/restlistempwithpf")
	public List<EmpBean> listempwithpf() {
		List<EmpBean> result = vd.listempwithpf();
		return result;
	}
	/*
	 * To retrieve a list of employee details whose salary range between 10000 and 20000 which calls ListEmpDao to perform this function
	 */
	@RequestMapping(value = "/restlistemprange")
	public List<EmpBean> listemprange() {
		List<EmpBean> result = vd.listemprange();
		return result;
	}
}
