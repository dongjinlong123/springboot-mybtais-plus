package com.djl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.djl.entity.Demo;
import com.djl.entity.WxInfoLog;
import com.djl.service.DemoService;
import com.djl.service.WxInfoLogService;

/**
 * 测试mybatis-plus
 * 
 * @author 笨笨AA制
 * @createDate 2018年4月26日
 * @fileName TestMybatisPlusController.java
 * @desc
 */
@RestController
public class TestMybatisPlusController {
	
	@Autowired
	private DemoService demoService;
	
	@Autowired
	private WxInfoLogService wxInfoLogService;

	@RequestMapping("/testLog")
	public String testLog() {
		System.out.println("异步调用开始------------");
		WxInfoLog log = new WxInfoLog ();
		log.setContent("content");

		log.setFromUserName("fromuser");
		log.setImgUrl("http://image");
		log.setMediaId("123");
		log.setMsgId("111");
		log.setMsgType("msgtype");
		log.setRecognition("recognition");
		log.setResMsg("resmsg");
		log.setCreateTime("2018-06-26");
		log.setToUserName("djl");
		wxInfoLogService.saveWXLog(log);
		System.out.println("异步调用结束------------");
		return "success";
	}
	
	/**
	 * 测试分页功能
	 * 
	 * @param _index
	 * @param _size
	 * @return
	 */
	@RequestMapping("/testPage")
	public Map<String, Object> testPage(
			@RequestParam(value = "_index", required = false, defaultValue = "1") String _index,
			@RequestParam(value = "_size", required = false, defaultValue = "3") String _size,
			HttpServletResponse rep) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		//允许跨域
		rep.setHeader("Access-Control-Allow-Origin", "*");
		// 定义返回的信息
		int retCode = 0;
		String retMsg = "成功";
		// int _index = 1;// 页次
		// int _size = 3;// 每页展示数量
		// 分页类
		Page<Demo> page = new Page<Demo>(Integer.valueOf(_index), Integer.valueOf(_size));
		Demo demo = new Demo();
		// 条件查询类
		Wrapper<Demo> w = new EntityWrapper<Demo>(demo);
		Page<Demo> data = demoService.selectPage(page, w);
		resultMap.put("retCode", retCode);
		resultMap.put("retMsg", retMsg);
		resultMap.put("data", data);
		return resultMap;
	}

	@RequestMapping("/inserDemo")
	public String insertTest(Demo demo) {
		System.out.println(demo.getName());
		if (demoService.insert(demo))
			return "00";
		else
			return "01";
	}
}
