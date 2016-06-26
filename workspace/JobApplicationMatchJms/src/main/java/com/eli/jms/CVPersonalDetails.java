package com.eli.jms;

import com.eli.jms.PConsts.AREA;

public class CVPersonalDetails {
	private String ID;	
	private String surName;	
	private String name;
	private int birthYear;
	private String city;
	private String address;
	private String phone;
	private String email;
	private AREA area;

	CVPersonalDetails() {}

	public CVPersonalDetails(String iD, String surName, String name, int birthYear, String city, String address,
			String phone, String email, AREA area) {
		super();
		ID = iD;
		this.surName = surName;
		this.name = name;
		this.birthYear = birthYear;
		this.city = city;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.area = area;
	}
	
	public AREA getArea() {
		return area;
	}

	public void setArea(AREA area) {
		this.area = area;
	}

	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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

	
}
