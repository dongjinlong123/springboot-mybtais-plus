package com.djl.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.djl.common.WxMessageUtil;

/**
 * 针对微信H5页面
 * @author 90411
 *
 */
@RestController
public class WxH5Controller {
	private final static Logger logger =LoggerFactory.getLogger(WxH5Controller.class);

	/**
	 * 获取H5页面初始化配置
	 * wx.config({
		    debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
		    appId: '', // 必填，公众号的唯一标识
		    timestamp: , // 必填，生成签名的时间戳
		    nonceStr: '', // 必填，生成签名的随机串
		    signature: '',// 必填，签名
		    jsApiList: [] // 必填，需要使用的JS接口列表
		});
	 * @return
	 */
	@RequestMapping("/getInitConfig")
	public Map<String,String> getInitConfig(@RequestParam("url") String url){
		String timestamp = WxMessageUtil.getTimeStamp();
		String jsapi_ticket = WxMessageUtil.JSAPI_TICKET;
		String nonceStr = WxMessageUtil.createConceStr(16);
		
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("timestamp", timestamp);
		map.put("jsapi_ticket", jsapi_ticket);
		map.put("nonceStr", nonceStr);
		map.put("url", url);
		String signature = WxMessageUtil.createSignSha1(map);
		map.put("signature", signature);
		logger.info("返回的信息："+JSONObject.toJSONString(map));
		return map;
	}
	
	

}
