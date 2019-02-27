package com.springboot.chapter12.service;

import com.springboot.chapter12.pojo.ClientInfo;

public interface LogInfoService {
    public ClientInfo findClientInfoByClientName(String clientName);
}
