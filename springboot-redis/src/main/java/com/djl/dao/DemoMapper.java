package com.djl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.djl.entity.Demo;

public interface DemoMapper {
	@Select("select * from demo")
	List<Demo> getDemoList();
	
	List<Demo> getDemoListByName(String name);
}
