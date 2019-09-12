package com.EmployeeManagement.repo;

import java.util.List;

import com.comakeit.ems.bean.AdminBean;
import com.comakeit.ems.bean.EmpBean;
import com.comakeit.ems.bean.LeaveBean;

public interface CrudInterface {

	public abstract String getAdminUsername(AdminBean adminbean);

	public abstract List<EmpBean> getuser(String name);

	public abstract EmpBean saveEmployee(EmpBean empbean);

	public abstract String deleteEmployee(EmpBean empbean);

	public abstract List<EmpBean> listEmployee();

	public abstract List<EmpBean> listEmployeebydepart();

	public abstract List<EmpBean> listEmployeewithpf();

	public abstract List<EmpBean> listEmployeewithreport(EmpBean empbean);

	public abstract List<EmpBean> listEmployeerange();

	public abstract LeaveBean saveEmpleave(LeaveBean leavebean);

	public abstract List<LeaveBean> listtograntleave(List<String> empnames);

	public abstract String grantpermission(LeaveBean leavebean);

	public abstract List<LeaveBean> checkstatus(LeaveBean leavebean);

}