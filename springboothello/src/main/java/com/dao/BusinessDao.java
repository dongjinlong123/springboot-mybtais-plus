package com.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Business;



public interface BusinessDao extends JpaRepository<Business, Serializable>{

}
