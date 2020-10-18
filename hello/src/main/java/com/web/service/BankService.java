package com.web.service;

import com.web.mapper.BankMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    @Autowired
    private BankMapper bankMapper;

    public void addMoney() {
        bankMapper.addMoney("张三",100);
        int x = 3/0;
        bankMapper.loseMoney("李四",100);
    }
}
