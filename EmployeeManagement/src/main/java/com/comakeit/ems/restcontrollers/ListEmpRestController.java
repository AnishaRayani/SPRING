package com.comakeit.ems.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comakeit.ems.bean.EmpBean;
import com.comakeit.ems.service.ListEmp;

@RestController
@RequestMapping(value = "restlist")
public class ListEmpRestController {

	@Autowired
	ListEmp vd;

	@GetMapping(value = "/restlistempbyid")
	public List<EmpBean> listempbyid() {

		List<EmpBean> result = vd.listempbyid();

		return result;
	}

	@GetMapping(value = "/restlistempbydepart")
	public List<EmpBean> listempbydepart() {

		List<EmpBean> result = vd.listempbydepart();

		return result;
	}

	@PostMapping(value = "/restlistempbyreport")
	public List<EmpBean> listempreport(@RequestBody EmpBean empbean) {

		List<EmpBean> result = vd.listempreport(empbean);

		return result;
	}

	@GetMapping(value = "/restlistempwithpf")
	public List<EmpBean> listempwithpf() {

		List<EmpBean> result = vd.listempwithpf();

		return result;
	}

	@GetMapping(value = "/restlistemprange")
	public List<EmpBean> listemprange() {

		List<EmpBean> result = vd.listemprange();

		return result;
	}
}
