package com.mango.admin.controller;

import com.mango.admin.model.SysMenu;
import com.mango.admin.service.SysMenuService;
import com.mango.core.http.HttpResult;
import com.mango.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("menu")
public class SysMenuController {

    @Autowired
    private SysMenuService  sysMenuService;

    //保存
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysMenu record){
        return HttpResult.ok(sysMenuService.save(record));
    }

    //删除
    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysMenu> record){
        return HttpResult.ok(sysMenuService.delete(record));
    }

    //分页查询
    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest){
        return HttpResult.ok(sysMenuService.findPage(pageRequest));
    }

    //通过name模糊查询
    @PostMapping(value = "/findPageByName")
    public HttpResult findPageByName(@RequestParam String name){
        return HttpResult.ok(sysMenuService.findPageByName(name));
    }

    //查询导航菜单树
    @GetMapping(value ="/findNavTree")
    public HttpResult findNavTree(@RequestParam String userName){
        return HttpResult.ok(sysMenuService.findMenuTree(userName, 1));
    }
    //查询菜单树
    @GetMapping(value ="/findMenuTree")
    public HttpResult findMenuTree(){
        return HttpResult.ok(sysMenuService.findMenuTree(null,0));
    }
}
