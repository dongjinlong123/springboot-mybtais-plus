package com.djl.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //控制切面
public class MyExceptionHandler {
	private static final Logger logger =LoggerFactory.getLogger(MyExceptionHandler.class);
	//捕获异常
	@ExceptionHandler(Exception.class)
	public String dispatchExceptionPage(Exception e) {
		logger.info("异常信息为"+e.getMessage());
		//自动跳转500页面
		return "/500";
	}
}
