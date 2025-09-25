package com.kh.java.member.model.vo;

import java.sql.Date;
import java.util.Objects;

public class Member {
	// int vs long --> long이 우세합니다. int = 4byte 음수 21억개, 양수 21억개 ...
	// 시퀀스를 사용하면 1부터 시작하니까 사실상 21억개이고 ... 유명한 사이트 게시판은 사용자가 21억명 넘을 수 있거든요?
	// long은 죽었다 깨어나도 다 못써요. (920경...?) 요새는 디폴트가 long 입니다.
	// long vs Long => Long을 선호합니다. 프레임워크 호환성 때문에.
	private Long userNo; // 보통은 Long 사용합니다.
	private String userId;
	private String userPwd;
	private String userName;
	private String email;
	private Date enrollDate;
	private Date modifyDate;
	private String status;
	
	public Member() {
		super();
	}

	public Member(Long userNo, String userId, String userPwd, String userName, String email, Date enrollDate,
			Date modifyDate, String status) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", email=" + email + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", status="
				+ status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, enrollDate, modifyDate, status, userId, userName, userNo, userPwd);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(email, other.email) && Objects.equals(enrollDate, other.enrollDate)
				&& Objects.equals(modifyDate, other.modifyDate) && Objects.equals(status, other.status)
				&& Objects.equals(userId, other.userId) && Objects.equals(userName, other.userName)
				&& Objects.equals(userNo, other.userNo) && Objects.equals(userPwd, other.userPwd);
	}
	
	
	
	
}
