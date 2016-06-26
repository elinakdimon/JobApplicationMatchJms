package com.eli.jms;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {
"personalDetails", "personalPreferences", "professionalEducation", "cert", "experience", "technology", "armyService", "keyword"} 
) 
public class CV {
	private CVPersonalDetails personalDetails;
	private CVPersonalPreferences personalPreferences;
	private CVProfEducation[] professionalEducation;
	private CVCertification[] cert;

	private String[] technology;
	private String[] keyword;

	private CVWorkExperience[] experience; 

	private CVArmyService armyService;

	CV() {}
	
	public CV(CVPersonalDetails personalDetails, CVPersonalPreferences personalPreferences,
			CVProfEducation[] professionalEducation, CVCertification[] cert, String[] technology, String[] keyword,
			CVWorkExperience[] experience, CVArmyService armyService) {
		super();
		this.personalDetails = personalDetails;
		this.personalPreferences = personalPreferences;
		this.professionalEducation = professionalEducation;
		this.cert = cert;
		this.technology = technology;
		this.keyword = keyword;
		this.experience = experience;
		this.armyService = armyService;
	}

	public CVPersonalDetails getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(CVPersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
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

	public String[] getTechnology() {
		return technology;
	}

	public void setTechnology(String[] technology) {
		this.technology = technology;
	}

	public String[] getKeyword() {
		return keyword;
	}

	public void setKeyword(String[] keyword) {
		this.keyword = keyword;
	}

	public CVWorkExperience[] getExperience() {
		return experience;
	}

	public void setExperience(CVWorkExperience[] experience) {
		this.experience = experience;
	}

	public CVArmyService getArmyService() {
		return armyService;
	}

	public void setArmyService(CVArmyService armyService) {
		this.armyService = armyService;
	}

	public CVPersonalPreferences getPersonalPreferences() {
		return personalPreferences;
	}

	public void setPersonalPreferences(CVPersonalPreferences personalPreferences) {
		this.personalPreferences = personalPreferences;
	}

	
//	public CuriculumVitae() {
//		super();
//	}
//	
//	public CuriculumVitae(PersonalDetails personalDetails, ProfEducation[] proffesionalEducation, Certification[] cert,
//			String[] technology, String[] keyword, WorkExperience[] experience, ArmyService armyService) {
//		super();
//		this.personalDetails = personalDetails;
//		this.professionalEducation = proffesionalEducation;
//		this.cert = cert;
//		this.technology = technology;
//		this.keyword = keyword;
//		this.experience = experience;
//		this.armyService = armyService;
//	}


	
}
