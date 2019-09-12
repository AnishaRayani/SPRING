package com.EmployeeManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.comakeit.ems.AdminBean;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<AdminBean, String> {

	/*
	 * To validate the username and password and tell whether it is a manager ,
	 * employee or admin
	 */
	@Query(value = "select e.role from AdminBean e where e.username= :username and e.password = :password")
	public String getAdminUsername(@Param("username") String username, @Param("password") String password);

}
