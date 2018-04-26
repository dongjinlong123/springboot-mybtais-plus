package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Business;
import com.service.TestJdbcTemplateService;

/**
 * 
 * @author     笨笨AA制
 * @createDate 2018年4月3日
 * @fileName   HelloWorldController.java
 * @desc
 */
@RestController
public class HelloWorldController {
	@Autowired
	private TestJdbcTemplateService testJdbcTemplateService;
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	@RequestMapping("/index")
	public String index(){
		return "success";
	}
	@RequestMapping("/getMap")
	public Map<String,Object> getMap(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("errorCode", 200);
		map.put("errorMsg", "成功");
		return map;
	}
	/**
	 * test jdbc template
	 * @return
	 */
	@RequestMapping("/insertBook")
	public String insertBook(){
		
		return testJdbcTemplateService.insertBook("DJL", "123", "999");
	}
	/**
	 * test jdbc jpa
	 * @return
	 */
	@RequestMapping("/queryBook")
	public List<Business> queryBook(){
		
		return testJdbcTemplateService.queryBook();
	}
	/**
	 * test jdbc mybatis
	 * @return
	 */
	@RequestMapping("/findByName")
	public Business findByName(){	
		System.out.println((sqlSessionFactory != null)+"---"+sqlSessionFactory.toString());
		return testJdbcTemplateService.findByName("java");
	}
}


