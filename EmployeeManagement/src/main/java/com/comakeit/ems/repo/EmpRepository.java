package com.comakeit.ems.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.comakeit.ems.bean.EmpBean;

@org.springframework.stereotype.Repository
public interface EmpRepository extends JpaRepository<EmpBean, String> {

	/*
	 * To validate the username and password and tell whether it is a manager ,
	 * employee or admin
	 */
	@Query(value = "select e from EmpBean e where e.reportingmanager= :name")
	public List<EmpBean> getuser(@Param("name") String name);

	/*
	 * To retrieve a list of employee details using empid so as to add or delete an
	 * employee
	 */
	@Query(value = "select e from EmpBean e where e.empid= :empid")
	public List<EmpBean> getemp(@Param("empid") String empid);

	/*
	 * To retrieve a list of employee details order by employee id
	 */
	@Query(value = "SELECT x FROM EmpBean x ORDER BY x.empid")
	public List<EmpBean> getlistofempbyid();

	/*
	 * To retrieve a list of employee details order by department name
	 */
	@Query(value = "SELECT x FROM EmpBean x ORDER BY x.departmentname")
	public List<EmpBean> getlistofempbydepart();

	/*
	 * To retrieve a list of employee details under a particular manager
	 */
	@Query(value = "SELECT x FROM EmpBean x where x.reportingmanager= :name")
	public List<EmpBean> getlistofempbywithreport(@Param("name") String name);

	/*
	 * To retrieve a list of employee details whose salary range between 10000 and
	 * 20000
	 */
	@Query(value = "select e from EmpBean e where salary between 10000 and 20000")
	public List<EmpBean> getlistofemprange();

}
