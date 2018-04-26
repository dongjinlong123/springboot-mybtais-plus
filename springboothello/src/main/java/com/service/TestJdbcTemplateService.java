package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dao.BusinessDao;
import com.entity.Business;
import com.mapper.BusinessMapper;


@Service("testJdbcTemplateService")
public class TestJdbcTemplateService {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BusinessDao businessDao;
	@Autowired
	private BusinessMapper businessMapper;
	/**
	 * 添加书籍
	 * @param name
	 * @param price
	 * @param num
	 * @return
	 */
	public String insertBook(String name , String price,String num){
			int i = jdbcTemplate.update("insert into business(NAME,price,num) values(?,?,?)", name,price,num);
			if(i>0){
				return "添加数据成功";
			}
		return "添加数据失败";
	}
	/**
	 * 查询所有的信息
	 * @return
	 */
	public List<Business> queryBook(){
		List<Business> list = businessDao.findAll();
		return list;
	}
	/**
	 * 通过名字查询信息
	 * @return
	 */
	public Business findByName(String name){
		Business b = businessMapper.findByName(name);
		System.out.println(businessMapper.queryPriceByName(name).getPrice());
		return b;
	}
}
