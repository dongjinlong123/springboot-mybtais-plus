package com.djl.common;

import java.io.UnsupportedEncodingException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class HttpSendUtil {
	private final static Logger logger =LoggerFactory.getLogger(HttpSendUtil.class);
	/**
	 * post请求API
	 * 
	 * @param url
	 * @param param json格式字符串
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws JSONException 
	 */
	public static String post(String url, String param) throws UnsupportedEncodingException {
		logger.info("传递的参数为:"+param);
		RestTemplate restTemplate = new RestTemplate();
		/* 注意：必须 http、https……开头 */
		HttpHeaders headers = new HttpHeaders();
		/* 解决中文乱码的关键，设置请求体格式 */

		 MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		 headers.setContentType(type);  
		 headers.add("Accept", MediaType.APPLICATION_JSON.toString()); 
		JSONObject jsonObj = JSON.parseObject(param);
		HttpEntity<String> entity = new HttpEntity<String>(jsonObj.toString(), headers);
		/* body是Http消息体例如json串 */
		ResponseEntity<String> resp = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		String resultStr =new String(resp.getBody().getBytes("ISO-8859-1"),"UTF-8");
		logger.info("调用" + url + "返回的信息:" + resultStr);
		return resultStr;
	}
	/**
	 * get请求API
	 * @param url
	 * @return
	 */
	public static String get(String url) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		/*设置请求数据类型*/
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity entity = new HttpEntity("", headers);
		/* body是Http消息体例如json串 */
		ResponseEntity<String> resp = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		String resultStr = resp.getBody();
		logger.info("调用" + url + "返回的信息:" + resultStr);
		return resultStr;
	}

}
