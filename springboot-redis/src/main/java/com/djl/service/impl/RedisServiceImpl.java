package com.djl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import com.djl.service.RedisService;
@Service("redisService")
public class RedisServiceImpl implements RedisService {
	@Autowired
	private CacheManager cacheManager; 
	/**
	 * 从缓存中查询数据
	 */
	@Override
	public <V> V cacheResult(String key, String cacheName) {
		ValueWrapper valueWrapper = cacheManager.getCache(cacheName).get(key);
		return (V)(valueWrapper == null?null:valueWrapper.get());
	}
	/**
	 * 从缓存中删除数据
	 */
	@Override
	public void cacheRemove(String key, String cacheName) {
		cacheManager.getCache(cacheName).evict(key);
	}
	/**
	 * 从缓存中添加数据
	 */
	@Override
	public <V> void cachePut(String key, V value, String cacheName) {
		cacheManager.getCache(cacheName).put(key, value);
	}
}
