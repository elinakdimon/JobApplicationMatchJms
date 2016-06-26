package com.eli.jms;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.eli.jms.PConsts.jms;

// A singleton class
public class JmsProducer {
	static Logger log4j = Logger.getLogger(JmsProducer.class.getName());	
    private static JmsProducer jmsProducer = null;
    private static final Object lock = new Object();
	static private MessageProducer producer = null;
	static private Session session = null;
	
	// Initiate JMS and Queue once
	private JmsProducer() {

		try {
			InitialContext initCtx = new InitialContext();
	        log4j.log(Level.INFO, "Initial Context created");

		    Context envContext = (Context) initCtx.lookup(jms.ENV_CONTEXT);
		    log4j.log(Level.INFO, "Context found: " + jms.ENV_CONTEXT);

			ConnectionFactory connectionFactory = (ConnectionFactory) envContext.lookup(jms.CONNECTION_FACTORY);
			log4j.log(Level.INFO, "ConnectionFactory found: " + jms.CONNECTION_FACTORY);

			Connection connection = connectionFactory.createConnection();
			log4j.log(Level.INFO, "Connection Created ");

			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			log4j.log(Level.INFO, "Session Created ");

			Destination destination = session.createQueue(jms.QUEUE);
			log4j.log(Level.INFO, "Destination Queue found and created: " + jms.QUEUE);

			producer = session.createProducer(destination);
			log4j.log(Level.INFO, "Destination Producer created");
			
		} catch (JMSException e) {
	        log4j.log(Level.SEVERE, PUtil.getStackTrace(e));
		    return;
		} catch (NamingException e) {
	        log4j.log(Level.SEVERE, PUtil.getStackTrace(e));
		    return;
		} catch (Exception e) {
	        log4j.log(Level.SEVERE, PUtil.getStackTrace(e));
		    return;
		}
	}
	
    public static JmsProducer getInstance() {
        synchronized(lock) {
            if(jmsProducer == null) {
            	jmsProducer = new JmsProducer();
            }
        }
        return jmsProducer;
    }
	

    // Send Match Response msg
    public static void SendMsg(MatchResponse matchResponse) {
    	
		try {
			ObjectMessage msg = session.createObjectMessage(matchResponse);
			log4j.log(Level.INFO, "Object Msg Created for matchResponse: " + "\n\t" +
					matchResponse.getPositionDetails() + "\n\t" +
					matchResponse.getApplicantDetails());

			producer.send(msg);
			log4j.log(Level.INFO, "Msg Successfully Sent to " + jms.QUEUE);

		} catch (JMSException e) {
	        log4j.log(Level.SEVERE, PUtil.getStackTrace(e));
		    return;
		} catch (Exception e) {
	        log4j.log(Level.SEVERE, PUtil.getStackTrace(e));
		    return;
		}
    }
}
