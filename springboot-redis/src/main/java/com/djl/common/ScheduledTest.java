package com.djl.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ScheduledTest {
	private static final Logger logger = LoggerFactory.getLogger(ScheduledTest.class);
	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Scheduled(cron = "0 */1 *  * * ? ") // 每1分钟执行一次
	public void quartzTest() {
		logger.info("定时调度：" + sdf.format(new Date()));
	}
}
