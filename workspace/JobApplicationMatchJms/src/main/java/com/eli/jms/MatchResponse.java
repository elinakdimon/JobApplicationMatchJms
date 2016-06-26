package com.eli.jms;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {
	    "positionDetails", "applicantDetails", "matchLevel", "matchCode", "matchDescription", "matchInformation", "matchScore", "matchPercentages"} 
)
public class MatchResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private Position positionDetails = new Position();
	private Applicant applicantDetails = new Applicant();
	private PConsts.MATCH matchLevel;
	private int matchCode;
	private String matchDescription;
	private String matchInformation;
	private int matchScore;
	private MatchPercentages matchPercentages;

	public int getMatchScore() {
		return matchScore;
	}
	public void setMatchScore(int matchScore) {
		this.matchScore = matchScore;
	}
	public String getMatchInformation() {
		return matchInformation;
	}
	public void setMatchInformation(String matchInformation) {
		this.matchInformation = matchInformation;
	}
	public Position getPositionDetails() {
		return positionDetails;
	}
	public void setPositionDetails(Position positionDetails) {
		this.positionDetails = positionDetails;
	}
	public Applicant getApplicantDetails() {
		return applicantDetails;
	}
	public void setApplicantDetails(Applicant applicantDetails) {
		this.applicantDetails = applicantDetails;
	}
	public PConsts.MATCH getMatchLevel() {
		return matchLevel;
	}
	public void setMatchLevel(PConsts.MATCH matchLevel) {
		this.matchLevel = matchLevel;
	}
	public String getMatchDescription() {
		return matchDescription;
	}
	public void setMatchDescription(String matchDescription) {
		this.matchDescription = matchDescription;
	}
	public MatchPercentages getMatchPercentages() {
		return matchPercentages;
	}
	public void setMatchPercentages(MatchPercentages matchPercentages) {
		this.matchPercentages = matchPercentages;
	}
	public int getMatchCode() {
		return matchCode;
	}
	public void setMatchCode(int matchCode) {
		this.matchCode = matchCode;
	} 

}

class Position implements Serializable {
	private static final long serialVersionUID = 1L;
	private String positionCode;
	private String positionTitle;
	private String positionEmpCode;

	Position() {}
	
	public Position(String positionCode, String positionTitle, String positionEmpCode) {
		super();
		this.positionCode = positionCode;
		this.positionTitle = positionTitle;
		this.positionEmpCode = positionEmpCode;
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

	@Override
	public String toString() {
		return "Position [positionCode=" + positionCode + ", positionTitle=" + positionTitle + ", positionEmpCode="
				+ positionEmpCode + "]";
	}
}


class Applicant implements Serializable {
	private static final long serialVersionUID = 1L;
	private String applicantID;	
	private String applicantSurName;	
	private String applicantName;
	
	Applicant() {}
	
	public Applicant(String applicantID, String applicantSurName, String applicantName) {
		super();
		this.applicantID = applicantID;
		this.applicantSurName = applicantSurName;
		this.applicantName = applicantName;
	}
	
	public String getApplicantID() {
		return applicantID;
	}
	public void setApplicantID(String applicantID) {
		this.applicantID = applicantID;
	}
	public String getApplicantSurName() {
		return applicantSurName;
	}
	public void setApplicantSurName(String applicantSurName) {
		this.applicantSurName = applicantSurName;
	}
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	@Override
	public String toString() {
		return "Applicant [applicantID=" + applicantID + ", applicantSurName=" + applicantSurName + ", applicantName="
				+ applicantName + "]";
	}
	
}

class MatchPercentages implements Serializable {
	private static final long serialVersionUID = 1L;
	private int location;
	private int education;
	private int certification;
	private int technologies;
	private int keywords;
	private int armyService;
	private int positionRequirement;

	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public int getEducation() {
		return education;
	}
	public void setEducation(int education) {
		this.education = education;
	}
	public int getCertification() {
		return certification;
	}
	public void setCertification(int certification) {
		this.certification = certification;
	}
	public int getTechnologies() {
		return technologies;
	}
	public void setTechnologies(int technologies) {
		this.technologies = technologies;
	}
	public int getKeywords() {
		return keywords;
	}
	public void setKeywords(int keywords) {
		this.keywords = keywords;
	}
	public int getArmyService() {
		return armyService;
	}
	public void setArmyService(int armyService) {
		this.armyService = armyService;
	}
	public int getPositionRequirement() {
		return positionRequirement;
	}
	public void setPositionRequirement(int positionRequirement) {
		this.positionRequirement = positionRequirement;
	}

}
