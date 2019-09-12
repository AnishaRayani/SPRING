package com.comakeit.ems.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.comakeit.ems.bean.LeaveBean;

@Repository
public interface LeaveRepository extends JpaRepository<LeaveBean, Integer> {

	/*
	 * To retrieve a list of leaves applied by an employee under a particular
	 * manager
	 */
	@Query(value = "select e from LeaveBean e where e.empname in :empnames")
	public List<LeaveBean> getlisttogrant(@Param("empnames") List<String> empnames);

	/*
	 * To retrieve a list of leaves applied by an employee to check status for the
	 * applied leave
	 */
	@Query(value = "select e from LeaveBean e where e.empname = :name")
	public List<LeaveBean> checkstatus(@Param("name") String name);

	/*
	 * To accept or reject the leave by the manager
	 */
	@Modifying
	@Transactional
	@Query(value = "UPDATE LeaveBean l SET l.status = :status  WHERE l.leaveid = :leaveid")
	public int grantpermission(@Param("leaveid") int leaveid, @Param("status") String status);

}
