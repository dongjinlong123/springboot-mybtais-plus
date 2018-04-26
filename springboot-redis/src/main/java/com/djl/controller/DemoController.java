package com.djl.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.djl.dao.DemoMapper;
import com.djl.entity.Demo;
import com.djl.service.DemoService;
import com.djl.service.RedisService;

@RestController
public class DemoController {
	private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
	@Autowired
	private DemoService demoService;
	@Autowired
	private DemoMapper demoMapper;
	
	@Autowired
	private RedisService redisService;
	/**
	 * 获取demo表中所有的信息
	 * @return
	 */
	@RequestMapping("/getDemoList")
	public List<Demo> getDemoList(@RequestParam(name="name",required=false) String name) {
		if(	StringUtils.isEmpty(name))
		return demoMapper.getDemoList();
		return demoMapper.getDemoListByName(name);
	}
	
	@RequestMapping("/testAsync")
	public String testAsync() {
		logger.info("1. 方法开始");
		demoService.asyncTest();
		logger.info("2. 方法结束");
		return "test async ok";
	}
	
	/**
	 * 测试全局异常捕获
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/testerror")
	public void  testerror() throws Exception {
		
		throw new Exception("测试全局异常捕获");
	}
	@RequestMapping("/testRedis")
	public String testRedis() {
		redisService.cachePut("java", "redis hello", "djl");
		return redisService.cacheResult("java", "djl");
	}
}
