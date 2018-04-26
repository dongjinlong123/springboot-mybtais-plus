package com.djl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * JPA 注解封装的实体类
 * @author     笨笨AA制
 * @createDate 2018年4月21日
 * @fileName   Demo.java
 * @desc
 */
@Entity
public class Demo {
	@Id
	@GeneratedValue 
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column
	private String value;
	
	@Column
	private String time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
