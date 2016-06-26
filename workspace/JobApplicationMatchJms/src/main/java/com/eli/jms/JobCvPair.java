package com.eli.jms;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {
"cv", "job"} 
) 
public class JobCvPair {
	private CV cv;
	private Job job;
	
	JobCvPair() {}
	
	public JobCvPair(CV cv, Job job) {
		super();
		this.cv = cv;
		this.job = job;
	}
	
	public CV getCv() {
		return cv;
	}
	public void setCv(CV cv) {
		this.cv = cv;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}

}
