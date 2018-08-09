package com.djl.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.djl.service.MenuService;
/**
 * 获取微信accessToken 的定时任务，同时更新菜单信息
 * @author 90411
 *
 */
@Component
public class WeixinAccessTokenTask {
	Logger logger = LoggerFactory.getLogger(WeixinAccessTokenTask.class);

	@Autowired
	private WxMessageUtil wxMessageUtil;
	@Autowired
	private MenuService menuService;
	
	// 第一次延迟1秒执行，当执行完后7100秒再执行
	@Scheduled(initialDelay = 1000, fixedDelay = 7000 * 1000)
	public void getWeixinAccessToken() {

		try {
			//获取accessToken
			wxMessageUtil.getAccessToken();
			
			//获取菜单信息
			String menuStr = menuService.initMenu();
			//菜单初始化
			wxMessageUtil.initMenu(menuStr);
			
			//获取JSAPI_TICKET
			wxMessageUtil.getJsapiTicket();
		} catch (Exception e) {
			logger.error("获取微信adcessToken出错，信息如下");
		}

	}

}
