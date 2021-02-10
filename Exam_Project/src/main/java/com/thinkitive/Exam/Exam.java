package com.thinkitive.Exam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Exam")
public class Exam {

	@Id
	@Column(name = "examid")
	private int examId;
	
	@Column(name = "studentId")
	private String studentId;
	
	@Column(name = "result")
	private String result;
	
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + examId;
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
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
		Exam other = (Exam) obj;
		if (examId != other.examId)
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", studentId=" + studentId + ", result=" + result + "]";
	}
	public Exam() {
		super();
	}
	public Exam(int examId, String studentId, String result) {
		super();
		this.examId = examId;
		this.studentId = studentId;
		this.result = result;
	}
	
	
	
}
