package com.djl.service.impl;

import org.springframework.stereotype.Service;

import com.djl.dao.ProductMapper;
import com.djl.entity.Product;
import com.djl.service.ProductService;
import com.djl.service.support.BaseServiceImpl;

/**
 *
 * demo 表数据服务层接口实现类
 *
 */
@Service
public class ProductServiceImpl extends BaseServiceImpl<ProductMapper, Product> implements ProductService {
	

}
