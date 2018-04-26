package com.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Business;
import com.test1.dao.BusinessTest1Dao;
import com.test2.dao.BusinessTest2Dao;

@Service("test1Service")
public class BusinessTest1Service {
	@Autowired
	private BusinessTest1Dao businessTest1Dao;
	@Autowired
	private BusinessTest2Dao businessTest2Dao;
	/**
	 * test 事务
	 * @param business
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertBook1(Business business){
		
		businessTest1Dao.insertBook(business);
		//test1中引入另一个数据源test2的
		//异常回滚 ： test1 会回滚
		//test2 不会回滚 ： 不同包不同的事务
		//引入了jta + atomikos 则统一了事务管理
		businessTest2Dao.insertBook(business);
		int i = 1/0;
	}
}
