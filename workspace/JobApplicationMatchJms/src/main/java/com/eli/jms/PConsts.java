package com.eli.jms;

public final class PConsts {
	private PConsts() {}
	
	public class jms {
		public static final String ENV_CONTEXT = "java:comp/env";
		public static final String CONNECTION_FACTORY = "jms/ConnectionFactory";
		public static final String QUEUE = "jms/queue/MyQueue";
	}
	
	public enum SENIORITY {VC, PROJ_MANAGER, PROG_MANAGER, TEAM_LEADER, ENGINEER, OTHER };
	public enum EXPERIENCE {SENIOR, SEMI_SENIOR, JUNIOR, STUDENT };
	public enum CLASSIFICATION {TOP_SECRET, SECRET, RESERVED, LIMITED, BLMS };
	public enum AREA {EILAT_AREA, SOUTH, JERUSALEM, CENTER, SHARON, NORTH, FAR_NORTH };
	public enum STATE {MANADATORY, PREFERED, YES, NO, UNKNOWN};
	public enum MATCH {NONE, PARTIAL, HIGH, PERFECT };
	
	public static final int NA_INT = -1;
	
	public static final int PERCENTAGE_KEYWORDS_ADVANTAGE = 30;
	public static final int PERCENTAGE_TECHNOLOGIES_ADVANTAGE = 20;
	public static final int PERCENTAGE_CERTIFICATE_ADVANTAGE = 20;
	public static final int PERCENTAGE_EDUCATION_ADVANTAGE = 20;
	public static final int PERCENTAGE_DISTANCE_MEDIUM = 70;
	public static final int PERCENTAGE_DISTANCE_FAR = 40;
	public static final int PERCENTAGE_ARMY_ADVANTAGE = 10;

	public static final double ALLOWED_SALARY_GAP = 0.2;
	public static final double ALLOWED_EMP_LEAD_GAP = 0.5;

	public static class MatchWeight {
		public static final double PERCENTAGE_POSITION_REQUIREMENT = 0.60;
		public static final double PERCENTAGE_EDUCATION = 0.15;
		public static final double PERCENTAGE_CERTIFICATION = 0.05;
		public static final double PERCENTAGE_TECHNOLOGIES = 0.05;
		public static final double PERCENTAGE_ARMY = 0.02;
		public static final double PERCENTAGE_LOCATION = 0.03;
		public static final double PERCENTAGE_KEYWORDS = 0.10;
		// All sum to 1.0
	}

	public static class MatchThresholds {
		public static final int MATCH_PERFECT = 95;
		public static final int MATCH_HIGH = 80;
		public static final int MATCH_PARTIAL = 70;
	}
	
	public static class MatchCodes {
		public static final int MATCH = 0;
		public static final int NO_MATCH_LOCATION_TOO_FAR = 1;
		public static final int NO_MATCH_NOT_WILLING_TO_RELOCATE = 2;

		public static final int NO_MATCH_REQUIRED_TECHNOLOGIES = 11;
		public static final int NO_MATCH_REQUIRED_KEYWORDS = 12;
		public static final int NO_MATCH_REQUIRED_CERTIFICATION = 13;
		public static final int NO_MATCH_REQUIRED_EDUCATION = 14;
		public static final int NO_MATCH_REQUESTED_SALARY_TOO_HIGH = 15;
		public static final int NO_MATCH_INSUFFICIENT_EXPERIENCE_YEARS = 16;
		public static final int NO_MATCH_INSUFFICIENT_EXPERIENCE_ROLE = 17;

		public static final int NO_MATCH_NO_REGULAR_SERVICE = 100;
		public static final int NO_MATCH_NO_PERMANENT_SERVICE = 101;
		public static final int NO_MATCH_NO_OFFICIER = 102;
		public static final int NO_MATCH_NO_COMBAT = 103;
		public static final int NO_MATCH_NO_INTELLIGENCE = 104;
		public static final int NO_MATCH_NO_U8200 = 105;
		public static final int NO_MATCH_INSUFFICIENT_CLASSIFICATION = 106;

	}
	
}
