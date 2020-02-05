package com.mango.admin.controller;

import com.mango.admin.constants.SysConstants;
import com.mango.admin.dao.SysRoleMapper;
import com.mango.admin.model.SysRole;
import com.mango.admin.model.SysRoleMenu;
import com.mango.admin.service.SysRoleService;
import com.mango.core.http.HttpResult;
import com.mango.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    private SysRoleMapper sysRoleMapper;

    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysRole record){
        return HttpResult.ok(sysRoleService.save(record));
    }

    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysRole> record){
        return HttpResult.ok(sysRoleService.delete(record));
    }

    @PostMapping("/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest){
        return HttpResult.ok(sysRoleService.findPage(pageRequest));
    }

    //查找全部
    @GetMapping(value = "/findAll")
    public Object findAll(){
        return sysRoleService.findAll();
    }

    @PostMapping("/findByName")
    public  HttpResult findByName(@RequestParam String name){
        return HttpResult.ok(sysRoleService.findByName(name));

    }

    //查询角色菜单
    @GetMapping("/findRoleMenus")
    public HttpResult findRoleMenus(@RequestParam Long id){
        return HttpResult.ok(sysRoleService.findRoleMenus(id));
    }

    //保存角色菜单
    @PostMapping(value = "/saveRoleMenus")
    public HttpResult saveRoleMenus(@RequestBody List<SysRoleMenu> records){
        for (SysRoleMenu record:records){
            SysRole sysRole = sysRoleMapper.selectByPrimaryKey(record.getId());
            if (SysConstants.ADMIN.equalsIgnoreCase(sysRole.getName())){
                //入股市超级管理员，不允许修改
                return HttpResult.error("超级管理员拥有所有菜单权限，不允许修改！");
            }
        }
        return HttpResult.ok(sysRoleService.saveRoleMenus(records));
    }
}
