package com.eli.jms;

import com.eli.jms.PConsts.CLASSIFICATION;
import com.eli.jms.PConsts.STATE;

public class CVArmyService {
	private int yearsRegular;
	private int yearsPermanent;
	private String unit;
	private STATE combat;
	private STATE intelligence;
	private STATE u8200;
	private STATE officier;
	private CLASSIFICATION classificationLevel;
	private STATE classification;
	
	CVArmyService() {}

	public CVArmyService(int yearsRegular, int yearsPermanent, String unit, STATE combat, STATE intelligence,
			STATE u8200, STATE officier, CLASSIFICATION classificationLevel, STATE classification) {
		super();
		this.yearsRegular = yearsRegular;
		this.yearsPermanent = yearsPermanent;
		this.unit = unit;
		this.combat = combat;
		this.intelligence = intelligence;
		this.u8200 = u8200;
		this.officier = officier;
		this.classificationLevel = classificationLevel;
		this.classification = classification;
	}

	public int getYearsRegular() {
		return yearsRegular;
	}

	public void setYearsRegular(int yearsRegular) {
		this.yearsRegular = yearsRegular;
	}

	public int getYearsPermanent() {
		return yearsPermanent;
	}

	public void setYearsPermanent(int yearsPermanent) {
		this.yearsPermanent = yearsPermanent;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public STATE getCombat() {
		return combat;
	}

	public void setCombat(STATE combat) {
		this.combat = combat;
	}

	public STATE getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(STATE intelligence) {
		this.intelligence = intelligence;
	}

	public STATE getU8200() {
		return u8200;
	}

	public void setU8200(STATE u8200) {
		this.u8200 = u8200;
	}

	public STATE getOfficier() {
		return officier;
	}

	public void setOfficier(STATE officier) {
		this.officier = officier;
	}

	public CLASSIFICATION getClassificationLevel() {
		return classificationLevel;
	}

	public void setClassificationLevel(CLASSIFICATION classificationLevel) {
		this.classificationLevel = classificationLevel;
	}

	public STATE getClassification() {
		return classification;
	}

	public void setClassification(STATE classification) {
		this.classification = classification;
	}

}
