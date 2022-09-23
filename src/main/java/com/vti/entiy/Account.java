package com.vti.entiy;

import java.util.Date;

public class Account {
	private int id;
	private String email;
	private String userName;
	private String password;
	private String fullName;
	private Department department;
	private Date createDate;

	public Account(int id, String email, String userName, String password, String fullName, Department department,
			Date createDate) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.department = department;
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", userName=" + userName + ", password=" + password
				+ ", fullName=" + fullName + ", department=" + department + ", createDate=" + createDate + "]";
	}

}
