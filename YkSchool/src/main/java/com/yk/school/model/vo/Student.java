package com.yk.school.model.vo;

import java.sql.Date;
import java.util.Objects;

public class Student {
	private Long studentNo;
	private String studentId;
	private String studentPwd;
	private String studentName;
	private String phone;
	private String lang;
	private Date enrollDate;
	private Date modifyDate;
	private String status;
	
	public Student() {
		super();
	}

	public Student(Long studentNo, String studentId, String studentPwd, String studentName, String phone, String lang,
			Date enrollDate, Date modifyDate, String status) {
		super();
		this.studentNo = studentNo;
		this.studentId = studentId;
		this.studentPwd = studentPwd;
		this.studentName = studentName;
		this.phone = phone;
		this.lang = lang;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}

	public Long getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(Long studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentPwd() {
		return studentPwd;
	}

	public void setStudentPwd(String studentPwd) {
		this.studentPwd = studentPwd;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Student [studentNo=" + studentNo + ", studentId=" + studentId + ", studentPwd=" + studentPwd
				+ ", studentName=" + studentName + ", phone=" + phone + ", lang=" + lang + ", enrollDate=" + enrollDate
				+ ", modifyDate=" + modifyDate + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(enrollDate, lang, modifyDate, phone, status, studentId, studentName, studentNo, studentPwd);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(enrollDate, other.enrollDate) && Objects.equals(lang, other.lang)
				&& Objects.equals(modifyDate, other.modifyDate) && Objects.equals(phone, other.phone)
				&& Objects.equals(status, other.status) && Objects.equals(studentId, other.studentId)
				&& Objects.equals(studentName, other.studentName) && Objects.equals(studentNo, other.studentNo)
				&& Objects.equals(studentPwd, other.studentPwd);
	}
	
	
	
}
