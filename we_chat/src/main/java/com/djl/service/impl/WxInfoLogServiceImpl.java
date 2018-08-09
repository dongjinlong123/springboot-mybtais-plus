package com.djl.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.djl.dao.WxInfoLogMapper;
import com.djl.entity.WxInfoLog;
import com.djl.service.WxInfoLogService;
import com.djl.service.support.BaseServiceImpl;

@Service
public class WxInfoLogServiceImpl extends BaseServiceImpl<WxInfoLogMapper, WxInfoLog> implements WxInfoLogService {
	private final Logger logger =LoggerFactory.getLogger(WxInfoLogServiceImpl.class);

	/**
	 * 异步记录日志
	 */
	@Async(value="mySimpleAsync")
	@Override
	public void saveWXLog(WxInfoLog log) {
		try {
			boolean b = this.insert(log);
			logger.info("添加数据成功" + b);
		} catch (Exception e) {
			logger.info("记录日志异常"+e.fillInStackTrace());
		}
	
	}
	

}