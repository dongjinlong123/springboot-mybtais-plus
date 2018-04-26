package com.djl.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.djl.entity.Demo;

public interface DemoJPADao extends JpaRepository<Demo, Serializable>{

}
