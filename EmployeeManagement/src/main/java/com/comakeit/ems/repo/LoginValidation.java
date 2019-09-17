package com.comakeit.ems.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comakeit.ems.bean.AdminBean;

@Repository
public interface LoginValidation extends JpaRepository<AdminBean, String> {

	@Query(value = "select e.role from AdminBean e where e.username= :username and e.password = :password")
	public String getAdminUsername(@Param("username") String username, @Param("password") String password);

}
