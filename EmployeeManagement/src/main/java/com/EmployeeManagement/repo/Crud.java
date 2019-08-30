package com.EmployeeManagement.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagement.bean.AdminBean;
import com.EmployeeManagement.bean.EmpBean;
import com.EmployeeManagement.bean.LeaveBean;

@Service
public class Crud implements CrudInterface {

	@Autowired
	private Repository repo;
	@Autowired
	private EmpRepository emprepo;
	@Autowired
	private LeaveRepository leaverepo;
	/*
	 * To validate the username and password and tell whether it is a manager , employee or admin which calls Repository to perform this function
	 */
	@Override
	public String getAdminUsername(AdminBean adminbean) {
		String result = repo.getAdminUsername(adminbean.getusername(), adminbean.getPassword());
		return result;
	}
	/*
	 * To validate the username and password and tell whether it is a manager , employee or admin which calls EmpRepository to perform this function
	 */
	@Override
	public List<EmpBean> getuser(String name) {
		List<EmpBean> user = emprepo.getuser(name);
		return user;
	}
	/*
	 * To add an employee which calls EmpRepository to perform this function and even it calls Repository to add the username and password in adminbean table
	 */
	@Override
	public EmpBean saveEmployee(EmpBean empbean) {
		AdminBean adminbean = new AdminBean();
		adminbean.setusername(empbean.getEmpname());
		adminbean.setPassword(empbean.getEmpname() + "123");
		adminbean.setRole("user");
		repo.save(adminbean);
		EmpBean result = emprepo.save(empbean);
		return result;

	}
	/*
	 * To delete an employee which calls EmpRepository to perform this function and even it calls Repository to delete the username and password in adminbean table
	 */

	public String deleteEmployee(EmpBean empbean) {
		AdminBean adminbean = new AdminBean();
		String empid = empbean.getEmpid();
		List<EmpBean> result = emprepo.getemp(empid);
		for (EmpBean b : result) {
			String name = b.getEmpname();
			adminbean.setusername(name);
		}
		repo.delete(adminbean);
		emprepo.delete(empbean);
		return "SUCCESS";
	}
	/*
	 * To retrieve a list of employee details order by employee id which calls EmpRepository to perform this function
	 */

	public List<EmpBean> listEmployee() {
		List<EmpBean> listemp = emprepo.getlistofempbyid();
		return listemp;
	}
	/*
	 * To retrieve a list of employee details order by department name which calls EmpRepository to perform this function
	 */
	public List<EmpBean> listEmployeebydepart() {
		List<EmpBean> listemp = emprepo.getlistofempbydepart();
		return listemp;
	}
	/*
	 * To retrieve a list of employee details with pf which calls EmpRepository to perform this function
	 */
	public List<EmpBean> listEmployeewithpf() {
		List<EmpBean> listemp = emprepo.findAll();
		return listemp;
	}
	/*
	 * To retrieve a list of employee details under a particular manager which calls EmpRepository to perform this function
	 */

	public List<EmpBean> listEmployeewithreport(EmpBean empbean) {
		List<EmpBean> listemp = emprepo.getlistofempbywithreport(empbean.getReportingmanager());
		return listemp;
	}
	/*
	 * To retrieve a list of employee details whose salary range between 10000 and 20000 which calls EmpRepository to perform this function
	 */
	public List<EmpBean> listEmployeerange() {
		List<EmpBean> listemp = emprepo.getlistofemprange();
		return listemp;
	}
	/*
	 * To apply leave as an employee or manager which calls EmpRepository to perform this function
	 */
	public LeaveBean saveEmpleave(LeaveBean leavebean) {
		leavebean.setStatus("pending");
		LeaveBean result = leaverepo.save(leavebean);
		return result;
	}
	/*
	 * To retrieve a list of employee under a particular manager to grant permission for leave which calls EmpRepository to perform this function
	 */
	public List<LeaveBean> listtograntleave(List<String> empnames) {
		List<LeaveBean> listemp = leaverepo.getlisttogrant(empnames);
		return listemp;
	}
	/*
	 * To accept or reject the leave by the manager which calls EmpRepository to perform this function
	 */
	public String grantpermission(LeaveBean leavebean) {
		leaverepo.grantpermission(leavebean.getLeaveid(), leavebean.getStatus());
		return "SUCCESS";
	}
	/*
	 * To check status for the applied leave which calls EmpRepository to perform this function
	 */
	public List<LeaveBean> checkstatus(LeaveBean leavebean) {
		List<LeaveBean> listemp = leaverepo.checkstatus(leavebean.getEmpname());
		return listemp;
	}
}