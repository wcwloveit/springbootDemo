package com.springboot.chapter12.dao;

import com.springboot.chapter12.pojo.ClientInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface ClientNameDao {
    public ClientInfo findClientInfoByClientName(String clientName);
}
