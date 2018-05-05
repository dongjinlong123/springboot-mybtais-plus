package com.djl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 下拉刷新参考
 * https://blog.csdn.net/u010568344/article/details/78630300
 * @author     笨笨AA制
 * @createDate 2018年4月27日
 * @fileName   Application.java
 * @desc
 */
@SpringBootApplication
@MapperScan(basePackages = { "com.djl.dao" })
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
