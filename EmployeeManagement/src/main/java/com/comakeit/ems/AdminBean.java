
package com.comakeit.ems;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Component
@Entity
public class AdminBean {

	@Id
	private String username;
	private String password;
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getusername() {
		return this.username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminBean [username=" + username + ", password=" + password + ", role=" + role + "]";
	}

}