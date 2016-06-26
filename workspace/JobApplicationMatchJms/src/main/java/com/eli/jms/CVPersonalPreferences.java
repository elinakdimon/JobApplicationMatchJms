package com.eli.jms;

import com.eli.jms.PConsts.STATE;

public class CVPersonalPreferences {
	private STATE willingToTravel;
	private STATE willingToRelocate;
	private STATE requestedSalary;
	private int requestedSalaryLow;
	private int requestedSalaryHigh;
	
	CVPersonalPreferences() {}

	public CVPersonalPreferences(STATE willingToTravel, STATE willingToRelocate, STATE requestedSalary,
			int requestedSalaryLow, int requestedSalaryHigh) {
		super();
		this.willingToTravel = willingToTravel;
		this.willingToRelocate = willingToRelocate;
		this.requestedSalary = requestedSalary;
		this.requestedSalaryLow = requestedSalaryLow;
		this.requestedSalaryHigh = requestedSalaryHigh;
	}

	public STATE getWillingToTravel() {
		return willingToTravel;
	}

	public void setWillingToTravel(STATE willingToTravel) {
		this.willingToTravel = willingToTravel;
	}

	public STATE getWillingToRelocate() {
		return willingToRelocate;
	}

	public void setWillingToRelocate(STATE willingToRelocate) {
		this.willingToRelocate = willingToRelocate;
	}

	public STATE getRequestedSalary() {
		return requestedSalary;
	}

	public void setRequestedSalary(STATE requestedSalary) {
		this.requestedSalary = requestedSalary;
	}

	public int getRequestedSalaryLow() {
		return requestedSalaryLow;
	}

	public void setRequestedSalaryLow(int requestedSalaryLow) {
		this.requestedSalaryLow = requestedSalaryLow;
	}

	public int getRequestedSalaryHigh() {
		return requestedSalaryHigh;
	}

	public void setRequestedSalaryHigh(int requestedSalaryHigh) {
		this.requestedSalaryHigh = requestedSalaryHigh;
	}
		
}
