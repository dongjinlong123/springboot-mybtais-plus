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
@MapperScan(basePackages={"com.test2.dao"},sqlSessionFactoryRef="test2SqlSessionFactory")
public class DataSourceTest2Config {
	/**
	 * 配置dataSourcetest2数据源
	 * @return
	 * @throws SQLException 
	 */
	@Bean(name="test2DataSource")
	//@Primary 多数据源的时候设置默认的主数据源，不设置会报错
	public DataSource test2DataSource(DBConfig2 dbConfig2) throws SQLException{
		MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
		mysqlXADataSource.setUrl(dbConfig2.getUrl());
		mysqlXADataSource.setPassword(dbConfig2.getPassword());
		mysqlXADataSource.setUser(dbConfig2.getUsername());
		mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
		
		
		/*数据源交给 atomikos 管理*/
		AtomikosDataSourceBean xaDataSoruce = new AtomikosDataSourceBean();
		xaDataSoruce.setXaDataSource(mysqlXADataSource);
		xaDataSoruce.setUniqueResourceName("test2DataSource");
		
		xaDataSoruce.setMinPoolSize(dbConfig2.getMinPoolSize());
		xaDataSoruce.setMaxPoolSize(dbConfig2.getMaxPoolSize());
		xaDataSoruce.setMaxLifetime(dbConfig2.getMaxLifetime());
		xaDataSoruce.setBorrowConnectionTimeout(dbConfig2.getBorrowConnectionTimeout());
		xaDataSoruce.setLoginTimeout(dbConfig2.getLoginTimeout());
		xaDataSoruce.setMaintenanceInterval(dbConfig2.getMaintenanceInterval());
		xaDataSoruce.setMaxIdleTime(dbConfig2.getMaxIdleTime());
		xaDataSoruce.setTestQuery(dbConfig2.getTestQuery());
		return xaDataSoruce;
	}
	/**
	 * 创建会话工厂bean
	 * @param dataSource
	 * @return
	 * @throws Exception
	 */
	@Bean(name="test2SqlSessionFactory")
	public SqlSessionFactory test2SqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource) throws Exception{
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		//mybatis 写配置文件
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/test2/dao/sql/*.xml"));
		bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/test2/mybatis-config.xml"));
		return bean.getObject();
	}

	/**
	 * 创建模版
	 * @param sqlSessionFactory
	 * @return
	 */
	@Bean(name="test2SqlSessionTemplate")
	public SqlSessionTemplate test2sqlSessionTemplate(@Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
