package com.djl.service;

import java.util.List;

import com.djl.entity.Demo;

public interface DemoService {
	public List<Demo> getDemoList();

	public void asyncTest();
}
