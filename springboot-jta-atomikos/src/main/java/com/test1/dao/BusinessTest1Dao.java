package com.test1.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.entity.Business;

public interface BusinessTest1Dao {
	/**
	 * 通过名称查询
	 * @param name
	 * @return
	 */
	@Select("select * from business where name =#{name}")
	Business findByNameTest1(@Param("name") String name);
	/**
	 * 查询书本的价格通过名称
	 * @param value
	 * @return
	 */
	Business queryPriceByNameTest1 (String value);
	/**
	 * 添加书本
	 * @param business
	 */
	@Insert(value={"insert into business(NAME,price,num) values(#{business.name},#{business.price},#{business.num})"})
	void insertBook(@Param("business") Business business);
}
