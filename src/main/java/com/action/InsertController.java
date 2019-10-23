package com.action;

import com.entity.*;
import com.dao.*;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

// ajax 跨域问题  解决
@CrossOrigin(allowCredentials = "true",maxAge = 3600)
@RestController
public class InsertController {

    @Autowired
    private IAskService  askservice;


    //新增订单
    @RequestMapping(value = "/insertQuestion",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer insertQuestion(Ask ask) {

        int num = askservice.insertNewProblems(ask);

        return num;
    }
}
