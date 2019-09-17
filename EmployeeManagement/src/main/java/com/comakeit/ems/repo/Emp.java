package com.comakeit.ems.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.comakeit.ems.bean.EmpBean;

@org.springframework.stereotype.Repository
public interface Emp extends JpaRepository<EmpBean, String> {

	@Query(value = "select e from EmpBean e where e.reportingmanager= :name")
	public List<EmpBean> getuser(@Param("name") String name);

	@Query(value = "select e from EmpBean e where e.empid= :empid")
	public List<EmpBean> getemp(@Param("empid") String empid);

	@Query(value = "SELECT x FROM EmpBean x ORDER BY x.empid")
	public List<EmpBean> getlistofempbyid();

	@Query(value = "SELECT x FROM EmpBean x ORDER BY x.departmentname")
	public List<EmpBean> getlistofempbydepart();

	@Query(value = "SELECT x FROM EmpBean x where x.reportingmanager= :name")
	public List<EmpBean> getlistofempbywithreport(@Param("name") String name);

	@Query(value = "select e from EmpBean e where salary between 10000 and 20000")
	public List<EmpBean> getlistofemprange();

}
