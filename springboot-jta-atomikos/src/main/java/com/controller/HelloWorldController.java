package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Business;
import com.service.TestJdbcTemplateService;
import com.test1.service.BusinessTest1Service;

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
	private BusinessTest1Service test1Service;
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
	 * test jdbc mybatis
	 * @return
	 */
	@RequestMapping("/findByName")
	public Business findByName(){	
		System.out.println(" test -----------");
		return testJdbcTemplateService.findByName("java");
	}
	@RequestMapping("/findByName1")
	public Business findByName1(){	
		System.out.println(" test1 -----------");
		return testJdbcTemplateService.findByName1("java");
	}
	@RequestMapping("/findByName2")
	public Business findByName2(){	
		System.out.println(" test2 -----------");
		return testJdbcTemplateService.findByName2("java");
	}
	/**
	 * test jta + atomikos
	 * @return
	 */
	@RequestMapping("/insertBook")
	public String insertBook1(){	
		Business business = new Business();
		business.setName("djl");
		business.setPrice("1");
		business.setNum("1");
		test1Service.insertBook1(business);
		return "insert success";
	}
}


