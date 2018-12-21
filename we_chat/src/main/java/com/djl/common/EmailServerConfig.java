package com.djl.common;

import java.util.Properties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@EnableConfigurationProperties(value={EmailConfig.class})
public class EmailServerConfig {

	@Bean
	public JavaMailSender javaMailSender(EmailConfig e) {
		JavaMailSenderImpl jm = new JavaMailSenderImpl();
		jm.setHost(e.getHost());
		jm.setPassword(e.getPassword());
		jm.setPort(e.getPort());
		jm.setProtocol(e.getProtocol());
		jm.setUsername(e.getUsername());
		Properties javaMailProperties = new Properties();
		javaMailProperties.setProperty("ail.smtps.auth", "true");
		jm.setJavaMailProperties(javaMailProperties);
		return jm;
	}
}
