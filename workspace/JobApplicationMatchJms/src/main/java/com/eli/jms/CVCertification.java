package com.eli.jms;
import com.eli.jms.PConsts.STATE;

public class CVCertification {
	private String cert;
	private String institute;
	private String state;
	private STATE required;
	
	CVCertification() {}

	public CVCertification(String cert, String institute, String state, STATE required) {
		super();
		this.cert = cert;
		this.institute = institute;
		this.state = state;
		this.required = required;
	}

	public String getCert() {
		return cert;
	}

	public void setCert(String cert) {
		this.cert = cert;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public STATE getRequired() {
		return required;
	}

	public void setRequired(STATE required) {
		this.required = required;
	}
	

}
