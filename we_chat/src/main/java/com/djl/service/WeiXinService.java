package com.djl.service;

import java.util.Map;

import com.djl.entity.WxMessage;

public interface WeiXinService {
	/**
	 * 微信参数验证
	 * @param token	令牌
	 * @param timestamp 时间戳
	 * @param nonce	随机数
	 * @param signature 微信加密签名
	 * @return
	 */
	public Boolean checkConnection(String token,String timestamp,String nonce,String signature);
	/**
	 * 根据用户输入的信息返回指定的信息给用户
	 * @param message
	 * @param xmlMap
	 * @return
	 */
	public String getReturnMsg(WxMessage message, Map<String, String> xmlMap);
}
