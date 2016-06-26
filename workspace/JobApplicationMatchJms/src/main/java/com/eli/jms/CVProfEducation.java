package com.eli.jms;

import com.eli.jms.PConsts.STATE;

public class CVProfEducation {
	private String degree;
	private String major;
	private String university;
	private String state;
	private int grade;
	private STATE required;
	
	CVProfEducation() {}

	public CVProfEducation(String degree, String major, String university, String state, int grade, STATE required) {
		super();
		this.degree = degree;
		this.major = major;
		this.university = university;
		this.state = state;
		this.grade = grade;
		this.required = required;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public STATE getRequired() {
		return required;
	}

	public void setRequired(STATE required) {
		this.required = required;
	}
	
	
}
