package com.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.djl.ApplicationContext;

/**
 * 测试用例：测试controller 层
 * 
 * @author 笨笨AA制
 * @createDate 2018年4月22日
 * @fileName MVCTest.java
 * @desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationContext.class, webEnvironment = WebEnvironment.MOCK)
public class MVCTest {
	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;

	/**
	 * 初始化MockMvc 对象
	 */
	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	/**
	 * 测试是否正常响应，并输出响应结果
	 * 
	 * @throws Exception
	 */
	@Test
	public void testResult() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/testPage")// 调用接口
				.contentType(MediaType.APPLICATION_JSON_UTF8).param("name", "djl").param("value", "aaa")// 传入添加的用户参数
				.accept(MediaType.APPLICATION_JSON))// 接收的类型
				.andExpect(MockMvcResultMatchers.status().isOk()) // 状态是否ok
				.andDo(MockMvcResultHandlers.print()).andReturn();// 输出返回值
	}

	/**
	 * get请求传递参数，输出返回的值
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGet() throws Exception {
		RequestBuilder request = post("/getDemoList").contentType(MediaType.APPLICATION_JSON_UTF8).param("name", "董锦龙")
				.param("value", "aaa");// 传入添加的用户参数
		MvcResult mvcResult = mvc.perform(request).andReturn();
		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println("返回状态：" + status);
		System.out.println("返回内容:" + content);

	}

	/**
	 * post请求传递参数，输出返回的值
	 * 
	 * @throws Exception
	 */
	@Test
	public void testPost() throws Exception {
		JSONObject param = new JSONObject();
		param.put("name", "董锦龙");
		param.put("value", "aaa");
		String jsonstr = param.toString();
		System.out.println("================================请求入参：" + jsonstr);

		RequestBuilder request = MockMvcRequestBuilders.post("/getDemoList").contentType(MediaType.APPLICATION_JSON)
				.content(jsonstr).accept(MediaType.APPLICATION_JSON);

		MvcResult mvcResult = mvc.perform(request).andReturn();
		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println("返回状态：" + status);
		System.out.println("返回内容:" + content);

	}
}
