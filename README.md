# JobApplicationMatchJms
Match job description &amp; CV

ממשק:

URI	                                                        תיאור
<host> /JobApplicationMatch/JobMatch/getjob	                לבדיקה - מציג תיאור משרה בפורמט XML
<host> /JobApplicationMatch/JobMatch/getcv	                לבדיקה - מציג קורות חיים בפורמט XML
<host> /JobApplicationMatch/JobMatch/getjobcv	              לבדיקה – מציג אובייקט משולב קורות חיים/משרה
<host> /JobApplicationMatch/JobMatch/postjob	              לבדיקה - שולח לשרת תיאור משרה בפורמט XML
<host> /JobApplicationMatch/JobMatch/postcv	                לבדיקה - שולח לשרת קורות חיים בפורמט XML
<host> /JobApplicationMatch/JobMatch/postjobcv	            לבדיקה – שולח לשרת אובייקט משולב קורות חיים/משרה
<host> /JobApplicationMatch/JobMatch/matchJobCvRequest	    הממשק הראשי (POST).
                                                            פרמטר: אובייקט משולב קורות חיים/משרה בפורמט XML
                                                            פלט: אובייקט התאמת משרה לקורות חיים בפורמט XML
