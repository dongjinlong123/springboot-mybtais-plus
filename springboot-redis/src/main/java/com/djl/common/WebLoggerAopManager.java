package com.djl.common;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
/**
 * web 日志管理切换
 * @author     笨笨AA制
 * @createDate 2018年4月21日
 * @fileName   WebLoggerAopManager.java
 * @desc
 */
@Aspect
@Component
public class WebLoggerAopManager {
	private static final Logger logger = LoggerFactory.getLogger(WebLoggerAopManager.class);
	@Pointcut(value="execution(public * com.djl.controller.*.*(..))")
	public void pointcut() {}
	
	/**
	 * 前置通知
	 * @param jp
	 */
	@Before("pointcut()")
	public void beforeLog(JoinPoint jp) {
		// 获取request
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		String url  = request.getRequestURI().toString();
		String method = request.getMethod();
		String ip = request.getRemoteAddr();
		logger.info("访问的 ip" + ip + ";请求类型：" + method +";地址："+url+";方法名："+jp.getSignature().getName()+";参数："+Arrays.asList(jp.getArgs()));
	}
	/**
	 * 返回通知
	 * @param jp
	 * @param ret
	 */
	@AfterReturning(returning="ret",pointcut="pointcut()")
	public void returnLog(JoinPoint jp,Object ret){
		logger.info("方法名："+jp.getSignature().getName()+";参数："+Arrays.asList(jp.getArgs())+";返回的值："+ret);
	}

	
}
