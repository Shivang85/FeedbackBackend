package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import com.example.demo.entity.EmailDetails;

@Service
public class EmailServiceImpl {
	@Autowired
	private JavaMailSender javaMailSender;
	@Value("${spring.mail.username}")
	private String sender;
	
	public String sendSimpleMail(EmailDetails details){
		try{
		    	
		    SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		    mailMessage.setFrom(sender);
		    mailMessage.setTo(details.getRecipient());
		    mailMessage.setText("Thank you for visiting this site"
		        		+ " please provide valuable feedback to help us to grow");
		    mailMessage.setSubject("Hi from Feedback!");
		
		    javaMailSender.send(mailMessage);
		    return "Mail Sent Successfully...";
		   }
		
		 catch (Exception e) {
		        return "Error while Sending Mail";
		 }
}
}

