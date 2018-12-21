package com.djl.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.djl.entity.Demo;
import com.djl.service.MailService;
@Service("mailService")
public class MailServiceImpl implements MailService{
	private static Logger logger =LoggerFactory.getLogger(MailServiceImpl.class);
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Async(value="mySimpleAsync")
	@Override
	public void sendMail(Demo dto) {
		try {
		JavaMailSender sneder =javaMailSender ;

		MimeMessage message = sneder.createMimeMessage();// 新建邮件
		MimeMessageHelper messageHelper = new MimeMessageHelper(message);// 编辑发送内容
		
			messageHelper.setFrom("904118787@qq.com");
			messageHelper.setTo(dto.getQq()+"@qq.com");
			messageHelper.setSubject("来自董小飒答复");
			messageHelper.setText("您发送的主题为"+dto.getTopic()+"的信息已经接收，这是回信，祝你愉快！");
			sneder.send(message);// 发送
			logger.info("发送给"+dto.getQq()+"成功");
		} catch (MessagingException e) {
			logger.info("发送给"+dto.getQq()+"失败");
			
		}
		
		
	}

}
