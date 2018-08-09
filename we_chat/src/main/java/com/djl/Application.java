package com.djl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
/**
 * 微信小程序项目
 * @author 90411
 *
 */
@SpringBootApplication
@MapperScan(basePackages = { "com.djl.dao" })
@EnableScheduling
@EnableAsync   //加载spring 异步框架
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
