package com.springboot.chapter12.service.impl;

import com.springboot.chapter12.dao.ClientNameDao;
import com.springboot.chapter12.pojo.ClientInfo;
import com.springboot.chapter12.service.LogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogInfoServiceImpl implements LogInfoService {
    @Autowired
    private ClientNameDao clientNameDao;
    @Override
    public ClientInfo findClientInfoByClientName(String clientName) {
       return clientNameDao.findClientInfoByClientName(clientName);
    }
}
