package com.service.impl;


import com.dao.*;
import com.entity.*;
import com.service.IAskService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("IAskService")
@Transactional
@MapperScan(basePackages = "com.dao")
public class AskService implements IAskService {

    @Autowired
    private IAskDao askDao;

    @Override
    public int insertNewProblems(Ask ask) {
        return askDao.insert(ask);
    }
}
