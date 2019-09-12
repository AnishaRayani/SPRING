package com.EmployeeManagement.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeManagement.dao.AddEmpLeaveDao;
import com.EmployeeManagement.dao.CheckStatusDao;
import com.EmployeeManagement.dao.GrantLeaveDao;
import com.EmployeeManagement.dao.GrantPermissionDao;
import com.comakeit.ems.LeaveBean;

@RestController
@RequestMapping(value = "restleave")
public class EmpLeaveRestController {

	@Autowired
	AddEmpLeaveDao add;
	@Autowired
	GrantLeaveDao grantleave;
	@Autowired
	GrantPermissionDao grant;
	@Autowired
	CheckStatusDao check;

	/*
	 * To apply leave as an employee or manager which calls addempleavedao to
	 * perform this function
	 */
	@RequestMapping(value = "/restempleave")
	public LeaveBean addempleave(@RequestBody LeaveBean leavebean) {

		LeaveBean result = add.addempleave(leavebean);

		return result;
	}

	/*
	 * To retrieve a list of employee under a particular manager to grant permission
	 * for leave which calls GrantLeaveDao to perform this function
	 */
	@RequestMapping(value = "/restgrantleave")
	public List<LeaveBean> grantleave(@RequestBody LeaveBean leavebean) {

		List<LeaveBean> result = grantleave.grantleave(leavebean);

		return result;
	}

	/*
	 * To accept or reject the leave by the manager which calls GrantPermissionDao
	 * to perform this function
	 */
	@RequestMapping(value = "/restgrant")
	public List<LeaveBean> grantpermission(@RequestBody LeaveBean leavebean) {

		grant.grantpermission(leavebean);
		List<LeaveBean> result = grantleave.grantleave(leavebean);

		return result;

	}

	/*
	 * To check status for the applied leave which calls CheckStatusDao to perform
	 * this function
	 */
	@RequestMapping(value = "/restcheckstatus")
	public List<LeaveBean> checkstatus(@RequestBody LeaveBean leavebean) {

		List<LeaveBean> result = check.checkstatus(leavebean);

		return result;

	}
}
