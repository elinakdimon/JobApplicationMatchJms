package com.eli.jms;

import java.lang.reflect.Field;

public class PUtil {
	private PUtil() {}
	
    public static String getStackTrace(Throwable source) {
        // work in jdk >= 1.4
        StringBuffer target = new StringBuffer(source.getMessage() != null ? source.getMessage() : "null\n");
        String lineSeparator = System.getProperty("line.separator");
        StackTraceElement[] ste = source.getStackTrace();
        for(int i=0 ; i<ste.length ; i++) {
            target.append(lineSeparator).append(ste[i]);
        }
        target.append(lineSeparator);
        return target.toString();
    }

    public static String getMatchMsg(int value){
    	
    	String result = "Unrecognized Code " + value;
    	try {
    		Integer intValue = new Integer(value);
    		
    		Field[] fields = PConsts.MatchCodes.class.getFields();
    		for(int i=0; i<fields.length; i++) {
    			Field f = fields[i];
    			Object o = f.get(intValue);
    			if (o instanceof Integer) {
    				if(value == ((Integer)o).intValue()){
    					result = f.getName();
    					break;
    				}
    			}
    		}
    	} catch(Exception e){
        	return result;
    	}
    	return result;
    }

}
