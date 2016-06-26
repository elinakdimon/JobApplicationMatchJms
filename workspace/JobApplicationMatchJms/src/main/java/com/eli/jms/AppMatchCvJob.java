package com.eli.jms;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.eli.jms.PConsts.AREA;
import com.eli.jms.PConsts.CLASSIFICATION;
import com.eli.jms.PConsts.EXPERIENCE;
import com.eli.jms.PConsts.SENIORITY;
import com.eli.jms.PConsts.STATE;

@Path("/JobMatch")
public class AppMatchCvJob {
	
    public AppMatchCvJob() {
		super();
		JmsProducer.getInstance();
	}

	@POST
    @Path("/matchJobCvRequest")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response MatchCvJob2InXML(JobCvPair jobCvPair) {

    	MatchResponse matchResponse = BLJobMatch.matchJobCv(jobCvPair.getJob(), jobCvPair.getCv());
        return Response.status(201).entity(matchResponse).build();
    }

    @POST
    @Path("/postjobcv")
    @Consumes(MediaType.APPLICATION_XML)
    public Response MatchCvJobInXML(JobCvPair jobCvPair) {

        String result = "JobCvPair saved : " + jobCvPair;
        return Response.status(201).entity(result).build();
    }

    @POST
    @Path("/postcv")
    @Consumes(MediaType.APPLICATION_XML)
    public Response MatchCvJobInXML(CV cv) {

        String result = "CV saved : " + cv;
        return Response.status(201).entity(result).build();

    }
    @POST
    @Path("/postjob")
    @Consumes(MediaType.APPLICATION_XML)
    public Response PostJobInXML(Job job) {

        String result = "Job saved : " + job;
        return Response.status(201).entity(result).build();

    }
    
    @GET
    @Path("/getjobcv")
    @Produces(MediaType.APPLICATION_XML)
    public JobCvPair getJobCv() {
    	
    	JobCvPair jobCvPair = new JobCvPair(getCV(), getJob());
    	
//    	jobCvPair.setCv(getCV());
//    	jobCvPair.setJob(getJob());
    	
    	return jobCvPair;
    }
    
    @GET
    @Path("/getjob")
    @Produces(MediaType.APPLICATION_XML)
    public Job getJob() {

    	JobEmployerDetails employerDetails = new JobEmployerDetails("NICE", "RAANANA", "NR", "IL", null, "hr@nice.com", AREA.SHARON);
    	JobDetails jobDetails = new JobDetails(SENIORITY.PROG_MANAGER, EXPERIENCE.JUNIOR, 5, PConsts.NA_INT, 
    			"Do you have a zest for working with cutting edge products and helping customers succeed?\n" +  
				"Ready to be part of a game-changing global company? \n" +
				"Do you have 3 to 6 years of technical experience and a passion for working directly with customers?\n" + 
				"We are searching for a talented Project Manager/Support Engineer who will enjoy working hands-on in a fast-paced, start-up environment.\n" + 
				"Join Applause and have the room to apply your expertise to solve technical challenges and to grow professionally. \n" +
				"This position is ideally suited for someone with software QA/Development / technical support experience and has the ability to manage client expectations while juggling parallel projects.\n" + 
				"As the single point of contact - and key stakeholder during the delivery period - the Project Manager will be responsible for communication with clients and testing community, learning new products,developing/managing test plans, managing project budgets, triaging bugs, and quickly resolving issues"  
    			);
    	
    	CVPersonalPreferences jobPreferences = new CVPersonalPreferences(STATE.UNKNOWN, STATE.UNKNOWN, STATE.MANADATORY, 12000, 17000);
        
        CVProfEducation profEducation[] = new CVProfEducation[2];
        profEducation[0] = new CVProfEducation("MSC", null, null, null, PConsts.NA_INT, STATE.MANADATORY);
        profEducation[1] = new CVProfEducation("MBA", "Business Administration", null, null, PConsts.NA_INT, STATE.PREFERED);
        
        CVCertification cert[] = new CVCertification[1];
        cert[0] = new CVCertification("PMP", null, null, STATE.PREFERED);

    	String[] technologyRequired = {"MSPROJECT", "JAVA"};
    	String[] technologyAdvantage = {"J2EE", "DOT.NET", "SPRING", "mobile"};

    	String[] keywordRequired = {"planning", "development", "time management", "WEB"};
    	String[] keywordAdvantage = {"parallel", "scope", "budget"};

    	CVWorkExperience[] experience = new CVWorkExperience[2];
    	experience[0] = new CVWorkExperience(false, 3, 5, null, SENIORITY.PROJ_MANAGER, EXPERIENCE.SENIOR, 10, "project manager");
    	experience[1] = new CVWorkExperience(false, 5, 5, null, SENIORITY.ENGINEER, EXPERIENCE.JUNIOR, 0, "Programmer");
  	
    	CVArmyService armyService = new CVArmyService(PConsts.NA_INT, PConsts.NA_INT, null, STATE.PREFERED, STATE.NO, STATE.NO, STATE.PREFERED, CLASSIFICATION.BLMS, STATE.NO);

        Job job = new Job("PL-01982", "SW Project Manager", "NC1308", employerDetails, jobDetails, jobPreferences, profEducation, cert, 
        		experience, technologyRequired, technologyAdvantage, keywordRequired, keywordAdvantage, armyService);
        
//        Job job = new Job();
//        job.setEmployerDetails(employerDetails);
//        job.setJobPreferences(jobPreferences);
//        job.setArmyService(null);
//        job.setCert(cert);
//        job.setEmployerDetails(employerDetails);
//        job.setExperience(experience);
//        job.setJobDetails(jobDetails);
//        job.setKeywordAdvantage(keywordAdvantage);
//        job.setKeywordRequired(keywordRequired);
//        job.setProfessionalEducation(profEducation);
//        job.setTechnologyAdvantage(technologyAdvantage);
//        job.setTechnologyRequired(technologyRequired);

        return job;
    }

    
    @GET
    @Path("/getcv")
    @Produces(MediaType.APPLICATION_XML)
    public CV getCV() {

        CVPersonalDetails personalDetails = new CVPersonalDetails("057898751", "Eli", "Nar", 1972, 
        		"Ramat Gan", "Haroe 23", "052-4573666", "e.m@gmail.com", AREA.CENTER);
        CVPersonalPreferences personalPreferences = new CVPersonalPreferences(STATE.YES, STATE.NO, STATE.PREFERED, 20000, 25000);
        
        CVProfEducation profEducation[] = new CVProfEducation[2];
        profEducation[0] = new CVProfEducation("MSC", "Comuter Science", "Hebrew University", "IL", 90, STATE.YES);
        profEducation[1] = new CVProfEducation("MBA", "Business Administration", "BostonUniversity", "USA", 93, STATE.YES);
        
        CVCertification cert[] = new CVCertification[3];
        cert[0] = new CVCertification("PMP", "P.M.team LTD", "IL", STATE.YES);
        cert[1] = new CVCertification("MCP", "Microsoft", "IL", STATE.YES);
        cert[2] = new CVCertification("CCSA", "Checkpoint", "IL", STATE.YES);

        CVArmyService armyService = new CVArmyService(3, 0, "MP", STATE.NO, STATE.NO, STATE.NO, STATE.NO, CLASSIFICATION.SECRET, STATE.PREFERED);
        
        CVWorkExperience workExperience[] = new CVWorkExperience[3];
        workExperience[0] = new CVWorkExperience(false, 2008, 2015, "Nice", SENIORITY.PROJ_MANAGER, EXPERIENCE.SENIOR, 12, "project manager");
        workExperience[1] = new CVWorkExperience(false, 2004, 2008, "Experon", SENIORITY.TEAM_LEADER, EXPERIENCE.SEMI_SENIOR, 5, "SW Team Leader");
        workExperience[2] = new CVWorkExperience(false, 1999, 2004, "Forcharge", SENIORITY.ENGINEER, EXPERIENCE.JUNIOR, 0, "Programmer");
        
        String technology[] = {"C", "C++", "OFFICE", "MSPROJECT", "JAVA", "J2EE", "VISIO"};

        String keyword[] = {"planning", "IT", "comlplex", "WEB", "scope", "budget", "development", "time management", "WEB"};

        CV cv = new CV(personalDetails, personalPreferences, profEducation, cert, technology, keyword, workExperience, armyService);
//        CV cv = new CV();
//        cv.setPersonalDetails(personalDetails);
//        cv.setPersonalPreferences(personalPreferences);
//        cv.setProfessionalEducation(profEducation);
//        cv.setCert(cert);
//        cv.setArmyService(armyService);
//        cv.setExperience(workExperience);
//        cv.setTechnology(technology);
//        cv.setKeyword(keyword);

        return cv;
    }

    
}