package com.datasource;


import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;

/**
 * 
 * @author     笨笨AA制
 * @createDate 2018年4月11日
 * @fileName   DataSourceConfig.java
 * @desc	自定义数据源
 */
@Configuration //注册到springboot 容器中
@MapperScan(basePackages={"com.test1.dao"},sqlSessionFactoryRef="test1SqlSessionFactory")
public class DataSourceTest1Config {
	/**
	 * 配置dataSourceTest1数据源
	 * @return
	 * @throws SQLException 
	 */
	@Bean(name="test1DataSource")
	@Primary//多数据源的时候设置默认的主数据源，不设置会报错
	public DataSource test1DataSource(DBConfig1 dbConfig1) throws SQLException{
		MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
		mysqlXADataSource.setUrl(dbConfig1.getUrl());
		mysqlXADataSource.setPassword(dbConfig1.getPassword());
		mysqlXADataSource.setUser(dbConfig1.getUsername());
		mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
		
		
		/*数据源交给 atomikos 管理*/
		AtomikosDataSourceBean xaDataSoruce = new AtomikosDataSourceBean();
		xaDataSoruce.setXaDataSource(mysqlXADataSource);
		xaDataSoruce.setUniqueResourceName("test1DataSource");
		
		xaDataSoruce.setMinPoolSize(dbConfig1.getMinPoolSize());
		xaDataSoruce.setMaxPoolSize(dbConfig1.getMaxPoolSize());
		xaDataSoruce.setMaxLifetime(dbConfig1.getMaxLifetime());
		xaDataSoruce.setBorrowConnectionTimeout(dbConfig1.getBorrowConnectionTimeout());
		xaDataSoruce.setLoginTimeout(dbConfig1.getLoginTimeout());
		xaDataSoruce.setMaintenanceInterval(dbConfig1.getMaintenanceInterval());
		xaDataSoruce.setMaxIdleTime(dbConfig1.getMaxIdleTime());
		xaDataSoruce.setTestQuery(dbConfig1.getTestQuery());
		return xaDataSoruce;
	}
	/**
	 * 创建会话工厂bean
	 * @param dataSource
	 * @return
	 * @throws Exception
	 */
	@Bean(name="test1SqlSessionFactory")
	@Primary
	public SqlSessionFactory test1SqlSessionFactory(@Qualifier("test1DataSource") DataSource dataSource) throws Exception{
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		//mybatis 写配置文件
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/test1/dao/sql/*.xml"));
		bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/test1/mybatis-config.xml"));
		return bean.getObject();
	}
	/**
	 * test1  无需事务管理  由atomikos 统一进行事务管理
	 * @param dataSource
	 * @return
	 */
/*	@Bean(name="test1TransactionManager")
	@Primary
	public DataSourceTransactionManager test1TransactionManager(@Qualifier("test1DataSource") DataSource dataSource){
		return new DataSourceTransactionManager(dataSource);
	}*/
	/**
	 * 创建模版
	 * @param sqlSessionFactory
	 * @return
	 */
	@Bean(name="test1SqlSessionTemplate")
	@Primary
	public SqlSessionTemplate test1sqlSessionTemplate(@Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
