package com.djl.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.djl.dao.DemoJPADao;
import com.djl.entity.Demo;
import com.djl.service.DemoService;

@Service("demoService")
public class DemoServiceImpl implements DemoService {
	private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

	@Autowired
	private DemoJPADao demoJPADao;

	@Override
	public List<Demo> getDemoList() {
		return demoJPADao.findAll();
	}
	@Override
	@Async("mySimpleAsync")
	public void asyncTest() {
		logger.info("异步开始");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("异步结束");
		
	}
	
}
