package com.comakeit.ems.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comakeit.ems.bean.LeaveBean;
import com.comakeit.ems.service.AddEmpLeave;
import com.comakeit.ems.service.CheckStatus;
import com.comakeit.ems.service.GrantLeave;
import com.comakeit.ems.service.GrantPermission;

@RestController
@RequestMapping(value = "restleave")
public class EmpLeaveRestController {

	@Autowired
	AddEmpLeave add;
	@Autowired
	GrantLeave grantleave;
	@Autowired
	GrantPermission grant;
	@Autowired
	CheckStatus check;

	@PostMapping(value = "/restempleave")
	public LeaveBean addempleave(@RequestBody LeaveBean leavebean) {

		LeaveBean result = add.addempleave(leavebean);

		return result;
	}

	@PostMapping(value = "/restgrantleave")
	public List<LeaveBean> grantleave(@RequestBody LeaveBean leavebean) {

		List<LeaveBean> result = grantleave.grantleave(leavebean);

		return result;
	}

	@PostMapping(value = "/restgrant")
	public List<LeaveBean> grantpermission(@RequestBody LeaveBean leavebean) {
		grant.grantpermission(leavebean);
		List<LeaveBean> result = grantleave.grantleave(leavebean);
		return result;

	}

	@PostMapping(value = "/restcheckstatus")
	public List<LeaveBean> checkstatus(@RequestBody LeaveBean leavebean) {

		List<LeaveBean> result = check.checkstatus(leavebean);

		return result;

	}
}
