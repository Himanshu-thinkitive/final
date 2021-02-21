package com.thinkitive.Teacher;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Teacher")
public class Teacher {
	
	@Id
	@Column(name = "tid")
	private int tid;
	
	@Column(name = "tName")
	private String tName;
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tName == null) ? 0 : tName.hashCode());
		result = prime * result + tid;
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
		Teacher other = (Teacher) obj;
		if (tName == null) {
			if (other.tName != null)
				return false;
		} else if (!tName.equals(other.tName))
			return false;
		if (tid != other.tid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tName=" + tName + "]";
	}
	public Teacher(int tid, String tName) {
		super();
		this.tid = tid;
		this.tName = tName;
	}
	public Teacher() {
		super();
	}
	

}
