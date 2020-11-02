package com.mycompany.mysite.service;

import java.io.UnsupportedEncodingException;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailHandler {
	
	private JavaMailSender mailSender;
	private MimeMessage message;
	private MimeMessageHelper messageHelper;
	
	public MailHandler(JavaMailSender mailSender) throws MessagingException {
		this.mailSender = mailSender;
		message = this.mailSender.createMimeMessage();
		messageHelper = new MimeMessageHelper(message, true, "UTF-8");
	}
	
	public void setSubject(String subject) throws MessagingException {
		messageHelper.setSubject(subject);
	}
	
	public void setText(String htmlContent) throws MessagingException {
		messageHelper.setText(htmlContent, true);
	}
	
	public void setFrom(String useremail, String username) throws UnsupportedEncodingException, MessagingException {
		messageHelper.setFrom(useremail, username);
	}
	
	public void setTo(String useremail) throws MessagingException {
		messageHelper.setTo(useremail);
	}
	
	public void addInline(String contentId, DataSource dataSource) throws MessagingException {
		messageHelper.addInline(contentId, dataSource);
	}
	
	public void send() {
		try {
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
