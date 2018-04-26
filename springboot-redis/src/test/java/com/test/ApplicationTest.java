package com.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.djl.ApplicationContext;
import com.djl.service.RedisService;


/**
 * 测试用例
 * @author     笨笨AA制
 * @createDate 2018年4月22日
 * @fileName   ApplicationTest.java
 * @desc
 */
@RunWith(SpringRunner.class)//spring环境运行
@SpringBootTest(classes = ApplicationContext.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTest {
	@Autowired 
	private RedisService redisService;
	@Test
	public void testHello() {
		System.out.println("hello");
		Assert.assertEquals("redis hello", redisService.cacheResult("java", "djl"));
	}
}
