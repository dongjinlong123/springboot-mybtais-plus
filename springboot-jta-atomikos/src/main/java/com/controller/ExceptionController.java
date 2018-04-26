package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice//切面
public class ExceptionController {
	/**
	 * 捕获异常
	 * @return
	 */
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public Map<String,Object> resultError(Exception e){
		System.out.println(e.getMessage());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("errorCode", 500);
		map.put("errorMsg", "系统错误");
		return map;
	}

}
