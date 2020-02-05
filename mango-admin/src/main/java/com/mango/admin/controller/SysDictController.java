package com.mango.admin.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mango.admin.model.SysDict;
import com.mango.admin.service.*;

import com.mango.core.http.HttpResult;
import com.mango.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dict")
public class SysDictController {

    @Autowired
    public SysDictService sysDictService;

    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysDict record){
        return HttpResult.ok(sysDictService.save(record));
    }

    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysDict> record){
        return HttpResult.ok(sysDictService.delete(record));
    }

    @PostMapping("/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest){
        return HttpResult.ok(sysDictService.findPage(pageRequest));
    }

    @PostMapping("/findByLabel")
    public  HttpResult findByLabel(@RequestParam String label){
        return HttpResult.ok(sysDictService.findByLabel(label));

    }



}
