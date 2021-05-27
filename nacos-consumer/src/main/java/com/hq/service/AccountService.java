package com.hq.service;

import com.hq.generator.domain.Account;
import com.hq.generator.mapper.AccountMapper;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountMapper mapper;
    public int deleteByPrimaryKey(String id){
        return mapper.deleteByPrimaryKey(id);
    }

    public int insert(Account record){
       return mapper.insert(record);
    }

    public Account selectByPrimaryKey(String id){
        return mapper.selectByPrimaryKey(id);
    }

    @GlobalTransactional(rollbackFor = Exception.class)
    public int updateByPrimaryKey(Account record){
        return mapper.updateByPrimaryKey(record);
    }

}
