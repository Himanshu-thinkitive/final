package com.thinkitive.Admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin {
	
	@Id
	@Column(name = "aid")
	private int aid;
	
	@Column(name = "adminName")
	private String adminName;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminName == null) ? 0 : adminName.hashCode());
		result = prime * result + aid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		if (adminName == null) {
			if (other.adminName != null)
				return false;
		} else if (!adminName.equals(other.adminName))
			return false;
		if (aid != other.aid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", adminName=" + adminName + "]";
	}

	public Admin(int aid, String adminName) {
		super();
		this.aid = aid;
		this.adminName = adminName;
	}

	public Admin() {
		super();
	}
	
		

}
