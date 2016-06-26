package com.eli.jms;

import com.eli.jms.PConsts.EXPERIENCE;
import com.eli.jms.PConsts.SENIORITY;

public class CVWorkExperience {
	private boolean current;
	private int yearStart;
	private int yearEnd;
	private int years;
	private String company;
	private SENIORITY seniority;
	private EXPERIENCE experience;
	private int numEmpsLead;
	private String role;

	CVWorkExperience() {}

	public CVWorkExperience(boolean current, int yearStart, int yearEnd, String company, SENIORITY seniority,
			EXPERIENCE experience, int numEmpsLead, String role) {
		super();
		this.current = current;
		this.yearStart = yearStart;
		this.yearEnd = yearEnd;
		this.company = company;
		this.seniority = seniority;
		this.experience = experience;
		this.numEmpsLead = numEmpsLead;
		this.role = role;
		
		this.years = yearEnd - yearStart;
	}

	public boolean isCurrent() {
		return current;
	}

	public void setCurrent(boolean current) {
		this.current = current;
	}

	public int getYearStart() {
		return yearStart;
	}

	public void setYearStart(int yearStart) {
		this.yearStart = yearStart;
	}

	public int getYearEnd() {
		return yearEnd;
	}

	public void setYearEnd(int yearEnd) {
		this.yearEnd = yearEnd;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public SENIORITY getSeniority() {
		return seniority;
	}

	public void setSeniority(SENIORITY seniority) {
		this.seniority = seniority;
	}

	public EXPERIENCE getExperience() {
		return experience;
	}

	public void setExperience(EXPERIENCE experience) {
		this.experience = experience;
	}

	public int getNumEmpsLead() {
		return numEmpsLead;
	}

	public void setNumEmpsLead(int numEmpsLead) {
		this.numEmpsLead = numEmpsLead;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
