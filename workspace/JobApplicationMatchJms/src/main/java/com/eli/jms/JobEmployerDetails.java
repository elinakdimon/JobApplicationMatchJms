package com.eli.jms;

import com.eli.jms.PConsts.AREA;

public class JobEmployerDetails {
	private String empName;
	private String city;
	private String address;
	private String state;
	private String phone;
	private String email;
	private AREA area;
	
	JobEmployerDetails() {}
	
	public JobEmployerDetails(String empName, String city, String address, String state, String phone, String email,
			AREA area) {
		super();
		this.empName = empName;
		this.city = city;
		this.address = address;
		this.state = state;
		this.phone = phone;
		this.email = email;
		this.area = area;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	public AREA getArea() {
		return area;
	}
	public void setArea(AREA area) {
		this.area = area;
	}
	
	
}
