package com.djl.service;

public interface RedisService {
	/**
	 * 从缓存获取数据
	 * @param key
	 * @param cacheName
	 * @return
	 */
	public <V> V cacheResult(String key,String cacheName);
	/**
	 * 从缓存删除一条数据
	 * @param key
	 * @param cacheName
	 */
	public void cacheRemove(String key,String cacheName);
	/**
	 * 从缓存新增一条数据
	 * @param key
	 * @param value
	 * @param cacheName
	 */
	public <V> void cachePut(String key,V value,String cacheName);
}
