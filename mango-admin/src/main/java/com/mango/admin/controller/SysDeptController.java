package com.mango.admin.controller;

import com.mango.admin.model.SysDept;
import com.mango.admin.service.SysDeptService;
import com.mango.core.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("dept")
public class SysDeptController {

    @Autowired
    private SysDeptService sysDeptService;

    //查找全部
    @GetMapping(value = "/findAll")
    public Object findAll(){
        return sysDeptService.findAll();
    }

    //保存机构
    @PostMapping(value = "/save")
    public HttpResult save(SysDept sysDept){
        return HttpResult.ok(sysDeptService.save(sysDept));
    }

    //删除机构
    @PostMapping(value ="/delete")
    public HttpResult delete(List<SysDept> record){
        return HttpResult.ok(sysDeptService.delete(record));
    }

    //查询机构树
    @GetMapping(value ="/findTree")
    public HttpResult findTree(){
        return HttpResult.ok(sysDeptService.findTree());
    }

}
