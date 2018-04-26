package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.datasource.DBConfig1;
import com.datasource.DBConfig2;

@SpringBootApplication
//启动的时候读取配置信息到数据源配置类中
@EnableConfigurationProperties(value={DBConfig1.class,DBConfig2.class})
@MapperScan(basePackages={"com.mapper"})
public class ApplicationContenxt {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationContenxt.class, args);
	}
}
