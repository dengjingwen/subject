package com.mango.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mango.admin.model.SysDict;
import com.mango.admin.model.SysRole;
import com.mango.admin.model.SysUser;
import com.mango.admin.service.SysMenuService;
import com.mango.admin.service.SysRoleService;
import com.mango.admin.service.SysUserService;
import com.mango.core.http.HttpResult;
import com.mango.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;


    //查找全部
    @GetMapping(value = "/findAll")
    public Object findAll(){
        return sysUserService.findAll();
    }

    //保存用户(保存记录)
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysUser record){
       return HttpResult.ok(sysUserService.save(record));
    }

    //删除用户（删除记录）
   @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysUser> record){
       for (SysUser records:record){
            SysUser sysUser =sysUserService.findById(records.getId());
       }
       return HttpResult.ok(sysUserService.delete(record));
    }

    //分页查询
    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest){
        return HttpResult.ok(sysUserService.findPage(pageRequest));
    }
    //根据名称查询
    @PostMapping(value = "/findByName")
    public HttpResult findByName(@RequestParam String name){
        return HttpResult.ok(sysUserService.findByName(name));
    }

    //查询用户权限
    @PostMapping(value = "/findPermissions")
    public HttpResult findPermissions(@RequestParam String username){
            return HttpResult.ok(sysUserService.findPermissions(username));
    }

    //查询用户角色
    @PostMapping(value = "/findUserRoles")
    public HttpResult findUserRole(Long userId){
        return HttpResult.ok(sysUserService.findUserRole(userId));
    }
}
