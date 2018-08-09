package com.djl.service;

import com.baomidou.mybatisplus.service.IService;
import com.djl.entity.WxInfoLog;

public interface WxInfoLogService extends IService<WxInfoLog> {
	/**
	 * 异步记录日志信息
	 * @param log
	 */
	public void saveWXLog(WxInfoLog log);
}
