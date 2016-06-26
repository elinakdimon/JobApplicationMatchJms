package com.eli.jms;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {
	    "positionCode", "positionTitle", "positionEmpCode", "employerDetails", "jobDetails", "jobPreferences", "professionalEducation", 
	    "cert", "experience", "technologyRequired", "technologyAdvantage", 
	    "keywordRequired", "keywordAdvantage", "armyService"} 
)
public class Job {
	private String positionCode;
	private String positionTitle;
	private String positionEmpCode;
	
	private JobEmployerDetails employerDetails;
	private JobDetails jobDetails; 
	
	private CVPersonalPreferences jobPreferences;
	private CVProfEducation[] professionalEducation;
	private CVCertification[] cert;
	private CVWorkExperience[] experience; 

	private String[] technologyRequired;
	private String[] technologyAdvantage;
	private String[] keywordRequired;
	private String[] keywordAdvantage;
	private CVArmyService armyService;

	Job() {}

	public Job(String positionCode, String positionTitle, String positionEmpCode, JobEmployerDetails employerDetails,
			JobDetails jobDetails, CVPersonalPreferences jobPreferences, CVProfEducation[] professionalEducation,
			CVCertification[] cert, CVWorkExperience[] experience, String[] technologyRequired,
			String[] technologyAdvantage, String[] keywordRequired, String[] keywordAdvantage,
			CVArmyService armyService) {
		super();
		this.positionCode = positionCode;
		this.positionTitle = positionTitle;
		this.positionEmpCode = positionEmpCode;
		this.employerDetails = employerDetails;
		this.jobDetails = jobDetails;
		this.jobPreferences = jobPreferences;
		this.professionalEducation = professionalEducation;
		this.cert = cert;
		this.experience = experience;
		this.technologyRequired = technologyRequired;
		this.technologyAdvantage = technologyAdvantage;
		this.keywordRequired = keywordRequired;
		this.keywordAdvantage = keywordAdvantage;
		this.armyService = armyService;
	}

	public String getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	public String getPositionTitle() {
		return positionTitle;
	}

	public void setPositionTitle(String positionTitle) {
		this.positionTitle = positionTitle;
	}

	public String getPositionEmpCode() {
		return positionEmpCode;
	}

	public void setPositionEmpCode(String positionEmpCode) {
		this.positionEmpCode = positionEmpCode;
	}

	public JobEmployerDetails getEmployerDetails() {
		return employerDetails;
	}

	public void setEmployerDetails(JobEmployerDetails employerDetails) {
		this.employerDetails = employerDetails;
	}

	public JobDetails getJobDetails() {
		return jobDetails;
	}

	public void setJobDetails(JobDetails jobDetails) {
		this.jobDetails = jobDetails;
	}

	public CVPersonalPreferences getJobPreferences() {
		return jobPreferences;
	}

	public void setJobPreferences(CVPersonalPreferences jobPreferences) {
		this.jobPreferences = jobPreferences;
	}

	public CVProfEducation[] getProfessionalEducation() {
		return professionalEducation;
	}

	public void setProfessionalEducation(CVProfEducation[] professionalEducation) {
		this.professionalEducation = professionalEducation;
	}

	public CVCertification[] getCert() {
		return cert;
	}

	public void setCert(CVCertification[] cert) {
		this.cert = cert;
	}

	public CVWorkExperience[] getExperience() {
		return experience;
	}

	public void setExperience(CVWorkExperience[] experience) {
		this.experience = experience;
	}

	public String[] getTechnologyRequired() {
		return technologyRequired;
	}

	public void setTechnologyRequired(String[] technologyRequired) {
		this.technologyRequired = technologyRequired;
	}

	public String[] getTechnologyAdvantage() {
		return technologyAdvantage;
	}

	public void setTechnologyAdvantage(String[] technologyAdvantage) {
		this.technologyAdvantage = technologyAdvantage;
	}

	public String[] getKeywordRequired() {
		return keywordRequired;
	}

	public void setKeywordRequired(String[] keywordRequired) {
		this.keywordRequired = keywordRequired;
	}

	public String[] getKeywordAdvantage() {
		return keywordAdvantage;
	}

	public void setKeywordAdvantage(String[] keywordAdvantage) {
		this.keywordAdvantage = keywordAdvantage;
	}

	public CVArmyService getArmyService() {
		return armyService;
	}

	public void setArmyService(CVArmyService armyService) {
		this.armyService = armyService;
	}
	
}
