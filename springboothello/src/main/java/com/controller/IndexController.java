package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *	测试全局捕获异常
 * @author     笨笨AA制
 * @createDate 2018年4月3日
 * @fileName   IndexController.java
 * @desc
 */

@Controller
public class IndexController {
	@RequestMapping("/indexTest")
	public String indexTest(Map<String,Object> resultMap){
		List<String> list = new ArrayList<String>();
		list.add("菜单1");
		list.add("菜单2");
		resultMap.put("userList", list);
		return "login";
	}
	@RequestMapping("/testHtml.do")
	public String testHtml(Map<String,Object> resultMap){
		resultMap.put("name", "董锦龙");
		resultMap.put("sex", 1);
		List<String> list = new ArrayList<String>();
		list.add("list add 001");
		list.add("list add 002");
		resultMap.put("userList", list);
		return "html/test";
	}
}
