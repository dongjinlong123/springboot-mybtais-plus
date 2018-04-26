package com.djl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * springboot 入口
 * @author     笨笨AA制
 * @createDate 2018年4月21日
 * @fileName   ApplicationContext.java
 * @desc
 */
@SpringBootApplication
@MapperScan(basePackages= {"com.djl.dao"})
public class ApplicationContext {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationContext.class,args);
	}
}
