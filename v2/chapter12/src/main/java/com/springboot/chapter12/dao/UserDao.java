package com.springboot.chapter12.dao;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.chapter12.pojo.DatabaseUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserDao {
	
	public DatabaseUser getUser(@Param("userName") String userName);
}
