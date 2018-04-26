package com;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 * 主函数开始运行spring-boot 项目
 * @author     笨笨AA制
 * @createDate 2018年4月3日
 * @fileName   App.java
 * @desc
 */
//@ComponentScan(basePackages={"controller","service"})
//@EnableJpaRepositories("com.dao")//将dao注入到JPA容器中
//@EntityScan("com.entity")//扫描JPA 实现类
@SpringBootApplication
@MapperScan(basePackages={"com.mapper"})//扫描Mapper 包
//@EnableAutoConfiguration
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
