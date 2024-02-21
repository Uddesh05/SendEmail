package com.numetry.SendEmail.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.numetry.SendEmail.Entiy.MailEntity;

import org.springframework.mail.SimpleMailMessage;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender javamailsender ;
	
	@Value("${spring.mail.username}")
	private String frommail;
	
	
	public void sendMail(String mail,MailEntity entity ) {
		
		SimpleMailMessage smm=new SimpleMailMessage();
		//jis mail se send krna hai vo application.properties me mentioned kiya hai....
	smm.setFrom(frommail);
	
	// Postman /entity se jo subject or message send krna hai ....
	smm.setSubject(entity.getSubject());
	smm.setText(entity.getMessage());
	
	
	// pathvaribale se jo mail liya hai
	smm.setTo(mail);
	  
	// jise mail send krna hai usko  JavaMailSender ka use kr k send krte hai...
javamailsender.send(smm);
	}
	
}
