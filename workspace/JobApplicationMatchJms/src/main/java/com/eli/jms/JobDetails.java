package com.eli.jms;

import com.eli.jms.PConsts.EXPERIENCE;
import com.eli.jms.PConsts.SENIORITY;

public class JobDetails {
	private SENIORITY seniority;
	private EXPERIENCE experience;
	private int requiredYearsExperience;
	private int numEmpsToLead;
	private String descrition;
	
	JobDetails() {}
	
	public JobDetails(SENIORITY seniority, EXPERIENCE experience, int requiredYearsExperience, int numEmpsToLead,
			String descrition) {
		super();
		this.seniority = seniority;
		this.experience = experience;
		this.requiredYearsExperience = requiredYearsExperience;
		this.numEmpsToLead = numEmpsToLead;
		this.descrition = descrition;
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
	public int getRequiredYearsExperience() {
		return requiredYearsExperience;
	}
	public void setRequiredYearsExperience(int requiredYearsExperience) {
		this.requiredYearsExperience = requiredYearsExperience;
	}
	public int getNumEmpsToLead() {
		return numEmpsToLead;
	}
	public void setNumEmpsToLead(int numEmpsToLead) {
		this.numEmpsToLead = numEmpsToLead;
	}
	public String getDescrition() {
		return descrition;
	}
	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}

	
}
