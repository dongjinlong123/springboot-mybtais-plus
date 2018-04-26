package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Business;
import com.mapper.BusinessMapper;
import com.test1.dao.BusinessTest1Dao;
import com.test2.dao.BusinessTest2Dao;


@Service("testJdbcTemplateService")
public class TestJdbcTemplateService {
	@Autowired
	private BusinessMapper businessMapper;
	@Autowired
	private BusinessTest1Dao businessTest1Dao;
	@Autowired
	private BusinessTest2Dao businessTest2Dao;
	/**
	 * 通过名字查询信息
	 * @return
	 */
	public Business findByName(String name){
		Business b = businessMapper.queryPriceByName(name);
		return b;
	}
	public Business findByName1(String name){
		Business b = businessTest1Dao.queryPriceByNameTest1(name);
		return b;
	}
	
	public Business findByName2(String name){
		Business b = businessTest2Dao.queryPriceByNameTest2(name);
		return b;
	}

}
