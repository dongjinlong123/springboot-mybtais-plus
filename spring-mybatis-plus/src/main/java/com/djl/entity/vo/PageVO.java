package com.djl.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;

public class PageVO {
	@TableField(exist = false)
	private int size;
	@TableField(exist = false)
	private int pageNum;
	@TableField(exist = false)
	private int total;
	@TableField(exist = false)
	private int startNum;
	@TableField(exist = false)
	private int endNum;
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getEndNum() {
		return endNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	
	
}
