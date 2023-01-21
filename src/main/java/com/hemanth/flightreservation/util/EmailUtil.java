package com.hemanth.flightreservation.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtil {

	@Value("${com.hemanth.flightreservation.itinerary.email.subject}")
	private String EMAIL_BODY;
	
	@Value("${com.hemanth.flightreservation.itinerary.email.body}")
	private String EMAIL_SUBJECT;
	@Autowired
	private JavaMailSender sender;
	
	public void sendItinerary(String toAddress, String filePath) {
		
		MimeMessage message = sender.createMimeMessage();
		
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
			messageHelper.setTo(toAddress);
			messageHelper.setSubject(EMAIL_SUBJECT);
			messageHelper.setText(EMAIL_BODY);
			messageHelper.addAttachment("itinerary",new File(filePath));
			sender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
}
