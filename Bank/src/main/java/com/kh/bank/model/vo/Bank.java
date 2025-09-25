package com.kh.bank.model.vo;

public class Bank {
	
	private String name;
	private String id;
	private String phone;
	private String email;
	private String address;
	private String type;

	public Bank() {
		
	}

	public Bank(String name, String id, String phone, String email, String address, String type) {
		super();
		this.name = name;
		this.id = id;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
}
