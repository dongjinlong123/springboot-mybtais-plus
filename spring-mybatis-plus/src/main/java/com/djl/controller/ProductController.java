package com.djl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.djl.entity.Product;
import com.djl.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	/**
	 * 测试分页功能
	 * 
	 * @param _index
	 * @param _size
	 * @return
	 */
	@RequestMapping("/ProductPage")
	public Map<String, Object> testPage(
			@RequestParam(value = "_index", required = false, defaultValue = "1") String _index,
			@RequestParam(value = "_size", required = false, defaultValue = "3") String _size,
			HttpServletResponse rep) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		//允许跨域
		rep.setHeader("Access-Control-Allow-Origin", "*");
		// 定义返回的信息
		int retCode = 0;
		String retMsg = "成功";
		// int _index = 1;// 页次
		// int _size = 3;// 每页展示数量
		// 分页类
		Page<Product> page = new Page<Product>(Integer.valueOf(_index), Integer.valueOf(_size));
		Product product = new Product();
		// 条件查询类
		Wrapper<Product> w = new EntityWrapper<Product>(product);
		Page<Product> data = productService.selectPage(page, w);
		resultMap.put("retCode", retCode);
		resultMap.put("retMsg", retMsg);
		resultMap.put("data", data);
		return resultMap;
	}

	@RequestMapping("/inserProduct")
	public String insertTest(Product product) {
		if (productService.insert(product))
			return "insert success";
		else
			return "insert fail";
	}
}
