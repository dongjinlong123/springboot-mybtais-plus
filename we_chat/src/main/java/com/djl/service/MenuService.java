package com.djl.service;

import com.baomidou.mybatisplus.service.IService;
import com.djl.entity.Menu;

/**
 *
 * 菜单服务类
 *
 */
public interface MenuService extends IService<Menu> {
	/**
	 * 初始化菜单字符串
	 * @return
	 */
	public String initMenu();
}