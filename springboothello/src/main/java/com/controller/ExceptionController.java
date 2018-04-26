package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局捕获异常类
 * @author     笨笨AA制
 * @createDate 2018年4月3日
 * @fileName   ExceptionController.java
 * @desc
 */
@ControllerAdvice//控制切面，通过AOP的异常通知进行拦截
public class ExceptionController {
	@ExceptionHandler(RuntimeException.class)//捕获运行时异常
	//如果返回JSON 格式添加ResponseBody 
	//返回页面 ， 返回String 类型 类型结果指定404页面
	@ResponseBody
	public Map<String,Object> resultError(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("errorCode", 500);
		map.put("errorMsg", "系统错误");
		return map;
	}
/*	
	@ExceptionHandler(Exception.class)
	public String resultPage(){
		
		return "404.html";
	}*/
}
