package com.comakeit.ems.restcontrollers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.comakeit.ems.bean.EmpBean;
import com.comakeit.ems.service.AddEmp;
import com.comakeit.ems.service.DeleteEmp;

@RestController
public class EmpRestController {

	@Autowired
	AddEmp add;
	@Autowired
	DeleteEmp delete;
    static String result;
	@PostMapping(value = "/restadd")
	public EmpBean addemp(@RequestBody EmpBean empbean) {

		EmpBean result1 = add.addemp(empbean);

		return result1;
	}

	@DeleteMapping(value = "/restdelete/{id}")
	public void deleteemp(@PathVariable("id") String id) {

	 result=delete.deleteemp(id);
	  System.out.println(result + "in rest controller");
	 
		
	}
	@GetMapping(value="/getstatus")
	public String getstatus()
	{
		return result;
	}
}
