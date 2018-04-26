package com.djl.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.djl.entity.vo.PageVO;

/**
 *
 * 操作demo表
 *
 */
@TableName(value = "demo")
public class Demo extends PageVO implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 主键 */
	@TableId
	private Long id;
	/**
	 * name
	 */
	private String name;
	/**
	 * value
	 */
	private String value;
	/**
	 * time
	 */
	private Date time;
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Demo [id=" + id + ", name=" + name + ", value=" + value + "]";
	}
	
}
