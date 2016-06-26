package com.eli.jms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.eli.jms.PConsts.AREA;
import com.eli.jms.PConsts.CLASSIFICATION;
import com.eli.jms.PConsts.MATCH;
import com.eli.jms.PConsts.MatchCodes;
import com.eli.jms.PConsts.MatchThresholds;
import com.eli.jms.PConsts.MatchWeight;
import com.eli.jms.PConsts.STATE;

public final class BLJobMatch {
	private BLJobMatch() {}

	public static MatchResponse matchJobCv (Job job, CV cv) {
		
		if (job == null)
			return matchCvAgaintJobPool (cv);
		
		if (cv == null)
			return matchJobAgainstCvPool(job);
		
		return matchSingleJobCv (job, cv);
	}
	
	private static MatchResponse matchCvAgaintJobPool (CV cv) {
		// Match single CV against job pool
		// To be completed in the future
		return null;
	}

	private static MatchResponse matchJobAgainstCvPool (Job job) {
		// Match single CV against job pool
		// To be completed in the future
		return null;
	}

	private static MatchResponse matchSingleJobCv (Job job, CV cv) {

		MatchResponse matchResponse = new MatchResponse();
		
		// Header
		matchResponse.getApplicantDetails().setApplicantID(cv.getPersonalDetails().getID());
		matchResponse.getApplicantDetails().setApplicantName(cv.getPersonalDetails().getName());
		matchResponse.getApplicantDetails().setApplicantSurName(cv.getPersonalDetails().getSurName());
		matchResponse.getPositionDetails().setPositionCode(job.getPositionCode());
		matchResponse.getPositionDetails().setPositionEmpCode(job.getPositionEmpCode());
		matchResponse.getPositionDetails().setPositionTitle(job.getPositionTitle());

		MatchPercentages matchP = new MatchPercentages();
		matchResponse.setMatchPercentages(matchP);

		StringBuffer matchInfo = new StringBuffer();
		Integer matchCode = new Integer(0);
		
		// Match applicant home residence and job location
		matchP.setLocation(matchLocation(job, cv, matchInfo));
		if (matchP.getLocation() == 0)
			return buildRejectResponse(matchResponse, MatchCodes.NO_MATCH_LOCATION_TOO_FAR);
		
		// Match required technologies
		matchP.setTechnologies(matchTechnologies(job, cv, matchInfo));
		if (matchP.getTechnologies() == 0)
			return buildRejectResponse(matchResponse, MatchCodes.NO_MATCH_REQUIRED_TECHNOLOGIES);
		
		// Match professional education
		matchP.setEducation(matchProfessionalEducation(job, cv, matchInfo));
		if (matchP.getEducation() == 0)
			return buildRejectResponse(matchResponse, MatchCodes.NO_MATCH_REQUIRED_EDUCATION);

		// Match army service and classifications
		matchP.setArmyService(matchArmyService(job, cv, matchInfo, matchCode));
		if (matchP.getArmyService() == 0)
			return buildRejectResponse(matchResponse, MatchCodes.NO_MATCH_REQUIRED_TECHNOLOGIES);

		// Match needed certifications
		matchP.setCertification(matchCertifications(job, cv, matchInfo));
		if (matchP.getCertification() == 0)
			return buildRejectResponse(matchResponse, MatchCodes.NO_MATCH_REQUIRED_CERTIFICATION);
		
		// Match position salary and requested salary
		// No matching percentage, just yes/no
		if (matchSalary(job, cv, matchInfo) == 0)
			return buildRejectResponse(matchResponse, MatchCodes.NO_MATCH_REQUESTED_SALARY_TOO_HIGH);

		// Match general keywords
		// No matching percentage, just yes/no
		matchP.setKeywords(matchKeywords(job, cv, matchInfo));
		if (matchP.getKeywords() == 0)
			return buildRejectResponse(matchResponse, MatchCodes.NO_MATCH_REQUIRED_KEYWORDS);
		
		// Match general position requirements:
		//		 * 		SENIORITY
		//		 * 		EXPERIENCE
		//		 * 		requiredYearsExperience
		//		 * 		role
		// TODO
		matchP.setPositionRequirement(matchPositionRequirements(job, cv, matchInfo, matchCode));
		if (matchP.getPositionRequirement() == 0)
			return buildRejectResponse(matchResponse, matchCode);

		calculateMatchPercentage(matchResponse);

		JmsProducer.SendMsg(matchResponse);
		
		return matchResponse;
	}

	// Match residence with job location
	// TODO: Deal with relocation jobs
	// TODO: fill in 'info' 
	private static int matchLocation (Job job, CV cv, StringBuffer info) {
		AREA applicantLocation = cv.getPersonalDetails().getArea();
		STATE willingToTravel = cv.getPersonalPreferences().getWillingToTravel();
		AREA jobLocation = job.getEmployerDetails().getArea();
		
		if (jobLocation == applicantLocation)
			return 100;
		
	   Set<AREA> areaSet = new HashSet<AREA>();
	   areaSet.add(jobLocation);
	   areaSet.add(applicantLocation);
		   
	   // EILAT
	   if (areaSet.contains(AREA.EILAT_AREA))
		   return 0;
	   
	   // SOUTH
	   if (areaSet.contains(AREA.SOUTH))
		   if (areaSet.contains(AREA.JERUSALEM) || areaSet.contains(AREA.CENTER))
			   return (willingToTravel.equals(STATE.YES)) ? PConsts.PERCENTAGE_DISTANCE_MEDIUM : 0;
		   else if (areaSet.contains(AREA.SHARON))
			   return (willingToTravel.equals(STATE.YES)) ? PConsts.PERCENTAGE_DISTANCE_FAR : 0;
		   else // NORTH, FAR_NORTH
			   return 0;
	   
	   // JERUSALEM
	   // SOUTH already covered above
	   if (areaSet.contains(AREA.JERUSALEM))
		   if (areaSet.contains(AREA.SHARON) || areaSet.contains(AREA.CENTER))
			   return (willingToTravel.equals(STATE.YES)) ? PConsts.PERCENTAGE_DISTANCE_MEDIUM : 0;
		   else if (areaSet.contains(AREA.NORTH))
			   return (willingToTravel.equals(STATE.YES)) ? PConsts.PERCENTAGE_DISTANCE_FAR : 0;
		   else // FAR_NORTH
			   return 0;
		
	   // CENTER
	   // SOUTH, JERUSALEM already covered above
	   if (areaSet.contains(AREA.CENTER))
		   if (areaSet.contains(AREA.SHARON))
			   return 100;
		   else if (areaSet.contains(AREA.NORTH))
			   return (willingToTravel.equals(STATE.YES)) ? PConsts.PERCENTAGE_DISTANCE_MEDIUM : 0;
		   else // AREA.FAR_NORTH
			   return (willingToTravel.equals(STATE.YES)) ? PConsts.PERCENTAGE_DISTANCE_FAR : 0;
		
	   // SHARON
	   // SOUTH, JERUSALEM, CENTER already covered above
	   if (areaSet.contains(AREA.SHARON))
		   if (areaSet.contains(AREA.NORTH))
			   return 100;
		   else // AREA.FAR_NORTH
			   return (willingToTravel.equals(STATE.YES)) ? PConsts.PERCENTAGE_DISTANCE_MEDIUM : 0;
	   
	   // NORTH
	   // SOUTH, JERUSALEM, CENTER, SHARON already covered above
	   if (areaSet.contains(AREA.NORTH))
		   if (areaSet.contains(AREA.NORTH))
			   return 100;
		   else // AREA.FAR_NORTH
			   return (willingToTravel.equals(STATE.YES)) ? PConsts.PERCENTAGE_DISTANCE_MEDIUM : 0;
	   
	   // FAR_NORTH
	   // SOUTH, JERUSALEM, CENTER, SHARON, NORTH already covered above
	   
	   // just for default
	   return 100;
	}

	
	// Match required certifications
	// Applicant certifications MUST contain ALL job required certifications (MUST)
	// If in addition it contains all advantage certifications (PREFERED), match is 100
	// Otherwise, advantage certifications equal 20% of the match (why? because I decided so...)
	// TODO: fill in 'info' 
	private static int matchCertifications (Job job, CV cv, StringBuffer info) {
		Set<String> appCertSet = new HashSet<String>();

		for (int i=0; i<cv.getCert().length; i++)
			appCertSet.add(cv.getCert()[i].getCert());
		
		int numCertAdvantage = 0;
		int numCertMissing = 0;
		for (int i=0; i<job.getCert().length; i++) {
			String c = job.getCert()[i].getCert();
			if (job.getCert()[i].getRequired().equals(STATE.MANADATORY))
				if (! appCertSet.contains(c))
					return 0;

			if (job.getCert()[i].getRequired().equals(STATE.PREFERED)) {
				numCertAdvantage++;
				if (! appCertSet.contains(c))
					numCertMissing++;
				}
		}

		if (numCertAdvantage == 0)
			return 100;
		
		return (100 - PConsts.PERCENTAGE_CERTIFICATE_ADVANTAGE*numCertMissing/numCertAdvantage);
	}


	// Match required Professional Education
	// Applicant Professional Education MUST contain ALL job required Professional Education (MUST)
	// If in addition it contains all advantage Professional Education (PREFERED), match is 100
	// Otherwise, advantage Professional Education equal 20% of the match (why? because I decided so...)
	// TODO: Logic is partial. For the moment, only degree is compared. In the future also compare CV major to job field requirement
	// TODO: fill in 'info' 
	private static int matchProfessionalEducation (Job job, CV cv, StringBuffer info) {
		Set<String> appEducationSet = new HashSet<String>();

		for (int i=0; i<cv.getProfessionalEducation().length; i++)
			appEducationSet.add(cv.getProfessionalEducation()[i].getDegree());
		
		int numEducationAdvantage = 0;
		int numEducationMissing = 0;
		for (int i=0; i<job.getProfessionalEducation().length; i++) {
			String c = job.getProfessionalEducation()[i].getDegree();
			if (job.getProfessionalEducation()[i].getRequired().equals(STATE.MANADATORY))
				if (! appEducationSet.contains(c))
					return 0;

			if (job.getProfessionalEducation()[i].getRequired().equals(STATE.PREFERED)) {
				numEducationAdvantage++;
				if (! appEducationSet.contains(c))
					numEducationMissing++;
				}
		}

		if (numEducationAdvantage == 0)
			return 100;
		
		return (100 - PConsts.PERCENTAGE_EDUCATION_ADVANTAGE*numEducationMissing/numEducationAdvantage);
	}


	// Match required technologies
	// Applicant technologies MUST contain ALL job required technologies
	// If in addition it contains all advantage technologies, match is 100
	// Otherwise, advantage technologies equal 20% of the match (why? because I decided so...)
	// TODO: fill in 'info' 
	private static int matchTechnologies (Job job, CV cv, StringBuffer info) {
		Set<String> appTechnologiesSet = new HashSet<String>(Arrays.asList(cv.getTechnology()));
		Set<String> jobTechnologiesRequiredSet = new HashSet<String>(Arrays.asList(job.getTechnologyRequired()));
		String[] jobTechnologiesAdvantage = job.getTechnologyAdvantage();

		return matchRequiredAdvantageSets(appTechnologiesSet, 
				jobTechnologiesRequiredSet, 
				jobTechnologiesAdvantage, 
				PConsts.PERCENTAGE_TECHNOLOGIES_ADVANTAGE);
	}


	// Match required keywords
	// Applicant keywords MUST contain ALL job required keywords
	// If in addition it contains all advantage keywords, match is 100
	// Otherwise, advantage keywords equal 30% of the match (why? because I decided so...)
	// TODO: fill in 'info' 
	private static int matchKeywords (Job job, CV cv, StringBuffer info) {
		Set<String> appKeywordsSet = new HashSet<String>(Arrays.asList(cv.getKeyword()));
		Set<String> jobKeywordsRequiredSet = new HashSet<String>(Arrays.asList(job.getKeywordRequired()));
		String[] jobKeywordsAdvantage = job.getKeywordAdvantage();

		return matchRequiredAdvantageSets(appKeywordsSet, 
				jobKeywordsRequiredSet, 
				jobKeywordsAdvantage, 
				PConsts.PERCENTAGE_KEYWORDS_ADVANTAGE);
	}


	private static int matchRequiredAdvantageSets (Set<String> appSet, Set<String> jobRequiredSet, String[] advantageArray, int advantagePercantage) {
		if (! appSet.containsAll(jobRequiredSet))
			return 0;

		if (advantageArray.length == 0)
			return 100;
		
		int numAdvantageMissing = 0;
		for (int i=0; i<advantageArray.length; i++)
		   if (appSet.contains(advantageArray[i]))
			   numAdvantageMissing++;
		
		return (100 - advantagePercantage*numAdvantageMissing/advantageArray.length);
	}

	

	// Match army service and classifications
	//	yearsRegular - mandatory unless NA_INT
	//	yearsPermanent - mandatory unless NA_INT
	//	combat, intelligence, u8200, officier - either mandatory or preferred.
	//	classificationLevel - either mandatory or preferred according to classification 
	// Applicant army service MUST contain ALL mandatory items.
	// If in addition it contains all advantage keywords, match is 100
	// Otherwise, advantage keywords equal 10% of the match (why? because I decided so...)
	// TODO: fill in 'info' 
	private static int matchArmyService (Job job, CV cv, StringBuffer info, Integer matchCode) {
		CVArmyService appArmy = cv.getArmyService();
		CVArmyService jobArmy = job.getArmyService();

		int armyAdvantage = 0;
		int armyMissing = 0;

		if (jobArmy.getYearsRegular() != PConsts.NA_INT)
			if (appArmy.getYearsRegular() < jobArmy.getYearsRegular()) {
				matchCode = MatchCodes.NO_MATCH_NO_REGULAR_SERVICE;
				return 0;
			}
		
		if (jobArmy.getYearsPermanent() != PConsts.NA_INT)
			if (appArmy.getYearsPermanent() < jobArmy.getYearsPermanent()) {
				matchCode = MatchCodes.NO_MATCH_NO_PERMANENT_SERVICE;
				return 0;
			}

		// TODO: Figure out an intelligent solution for code reuse
		switch (jobArmy.getCombat()) {
			case MANADATORY:
				if (appArmy.getCombat() != STATE.YES) {
					matchCode = MatchCodes.NO_MATCH_NO_COMBAT;
					return 0;
				}
				break;
			case PREFERED:
				armyAdvantage++;
				if (appArmy.getCombat() != STATE.YES)
					armyMissing++;
				break;
			default:
				break;
			}
		
		switch (jobArmy.getIntelligence()) {
		case MANADATORY:
			if (appArmy.getIntelligence() != STATE.YES) {
				matchCode = MatchCodes.NO_MATCH_NO_INTELLIGENCE;
				return 0;
			}
			break;
		case PREFERED:
			armyAdvantage++;
			if (appArmy.getIntelligence() != STATE.YES)
				armyMissing++;
			break;
		default:
			break;
		}

		switch (jobArmy.getOfficier()) {
		case MANADATORY:
			if (appArmy.getOfficier() != STATE.YES) {
				matchCode = MatchCodes.NO_MATCH_NO_OFFICIER;
				return 0;
			}
			break;
		case PREFERED:
			armyAdvantage++;
			if (appArmy.getOfficier() != STATE.YES)
				armyMissing++;
			break;
		default:
			break;
		}

		switch (jobArmy.getU8200()) {
		case MANADATORY:
			if (appArmy.getU8200() != STATE.YES) {
				matchCode = MatchCodes.NO_MATCH_NO_U8200;
				return 0;
			}
			break;
		case PREFERED:
			armyAdvantage++;
			if (appArmy.getU8200() != STATE.YES)
				armyMissing++;
			break;
		default:
			break;
		}

		CLASSIFICATION appClevel = appArmy.getClassificationLevel();
		switch (jobArmy.getClassification()) {
		case MANADATORY:
			if (jobArmy.getClassificationLevel().compareTo(appClevel) < 0) {
				// Job required class BEFORE applicant class, i.e. HIGHER
				matchCode = MatchCodes.NO_MATCH_INSUFFICIENT_CLASSIFICATION;
				return 0;
			}
			break;
		case PREFERED:
			armyAdvantage++;
			if (jobArmy.getClassificationLevel().compareTo(appClevel) < 0)
				// Job required class BEFORE applicant class, i.e. HIGHER
				armyMissing++;
			break;
		default:
			break;
		}

		return (100 - PConsts.PERCENTAGE_ARMY_ADVANTAGE*armyMissing/armyAdvantage);
	}
	
	// Match job salary and requested salary
	//	If job salary is not MANADATORY, match = 100%.
	//	Otherwise, allow a maximum gap of ALLOWED_SALARY_GAP
	// TODO: fill in 'info' 
	private static int matchSalary (Job job, CV cv, StringBuffer info) {
		STATE jobSalary = job.getJobPreferences().getRequestedSalary();

		if (! jobSalary.equals(STATE.MANADATORY))
			return 100;
		
		int jobMaxSalary = job.getJobPreferences().getRequestedSalaryHigh();
		int appMinSalary = job.getJobPreferences().getRequestedSalaryLow();
		
		if (jobMaxSalary >= appMinSalary)
			return 100;
		if (appMinSalary > jobMaxSalary*(1+PConsts.ALLOWED_SALARY_GAP))
			return 0;
		
		return 100;
	}


	// TODO: complete Business Logic
	private static int matchPositionRequirements (Job job, CV cv, StringBuffer info, Integer matchCode) {
		return 100;
	}
	
	private static void calculateMatchPercentage(MatchResponse matchResponse) {
		MatchPercentages matchP = matchResponse.getMatchPercentages();
		
		matchResponse.setMatchScore((int)
				(matchP.getArmyService() * MatchWeight.PERCENTAGE_ARMY +
				matchP.getCertification() * MatchWeight.PERCENTAGE_CERTIFICATION +
				matchP.getEducation() * MatchWeight.PERCENTAGE_EDUCATION +
				matchP.getKeywords() * MatchWeight.PERCENTAGE_KEYWORDS +
				matchP.getLocation() * MatchWeight.PERCENTAGE_LOCATION +
				matchP.getPositionRequirement() * MatchWeight.PERCENTAGE_POSITION_REQUIREMENT +
				matchP.getTechnologies() * MatchWeight.PERCENTAGE_TECHNOLOGIES));
		
		matchResponse.setMatchLevel(
				matchResponse.getMatchScore() >= MatchThresholds.MATCH_PERFECT ? MATCH.PERFECT :
				matchResponse.getMatchScore() >= MatchThresholds.MATCH_HIGH ? MATCH.HIGH :
				matchResponse.getMatchScore() >= MatchThresholds.MATCH_PARTIAL ? MATCH.PARTIAL :
					MATCH.NONE);
		
	}


	private static MatchResponse buildRejectResponse(MatchResponse matchResponse, int matchCode) {
		matchResponse.setMatchLevel(MATCH.NONE);
		matchResponse.setMatchCode(matchCode);
		matchResponse.setMatchDescription(PUtil.getMatchMsg(matchCode));
		
		return matchResponse;
	}

}
