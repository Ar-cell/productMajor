package com.javaBrains.productMajor.serviceImpl;

import java.util.Properties;
import com.javaBrains.productMajor.service.EmailService;
import org.springframework.stereotype.Service;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {
	
	@Override
	public void sendEmail(String subject, String message, String to) {
//		boolean f = false;
//		
		String from = "arun.mudgal@sastechstudio.com";
		
		//variable for mail
		String host = "smtp.gmail.com";
		
		//get the system property
		Properties properties = System.getProperties();
		System.out.println("Properties "+ properties);
		
		//setting import information to properties object
		
		//host set
		
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		   protected PasswordAuthentication getPasswordAuthentication() {
		      return new PasswordAuthentication("arun.mudgal@sastechstudio.com","7877632410" );
		   }
		});
		

		
		//step 1 to get the session object
		javax.mail.Session sessio = javax.mail.Session.getInstance(properties, new Authenticator() {
			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
				return new javax.mail.PasswordAuthentication("arun.mudgal@sastechstudio.com", "7877632410");
			}
		});
		
//		session.setDebug(true);
		session.setDebug(true);
		
		//step 2 : compose the message [text, multi media]
		MimeMessage m = new MimeMessage(session);
		
		try{
			
			//from email
			m.setFrom(from);
			//adding recipient to message
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//adding subject to message
			m.setSubject(subject);
			
			//adding text to message
			m.setText(message);
			
		

			
			//send
			
			//step 3 send the message using Transport class
			Transport.send(m);
			
			System.out.println("send success.............");
			//f = true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		//new
//		try {
//			m.setRecipients(Message.RecipientType.TO, InternetAddress.parse("arun.mudgal@sastechstudio.com", false));
//			Transport transport = session.getTransport();
//			transport.send(m);
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	
	// till new
		
	}
}
