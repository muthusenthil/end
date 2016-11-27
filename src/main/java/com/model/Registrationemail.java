/*package com.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("registerMail")
@Transactional
public class Registrationemail {
	
	
	@Autowired
	
	MailSender regmail;
	
	
	public void readyToSendMail(String toAddress, String fromAddress, String subject, String msgBody)
	{
		SimpleMailMessage regmsg= new SimpleMailMessage();
		regmsg.setFrom(fromAddress);
		regmsg.setTo(toAddress);
		regmsg.setSubject(subject);
		regmsg.setText(msgBody);
		regmail
		
		
		
		
		
	}
	

}
*/