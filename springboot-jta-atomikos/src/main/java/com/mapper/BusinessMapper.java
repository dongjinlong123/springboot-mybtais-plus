package com.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.entity.Business;

public interface BusinessMapper {
	/**
	 * 通过名称查询
	 * @param name
	 * @return
	 */
	@Select("select * from business where name =#{name}")
	Business findByName(@Param("name") String name);
	/**
	 * 查询书本的价格通过名称
	 * @param value
	 * @return
	 */
	Business queryPriceByName (String value);
}
