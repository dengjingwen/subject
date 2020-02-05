package com.mango.admin.service;

import com.mango.admin.model.SysUser;
import com.mango.admin.model.SysUserRole;
import com.mango.core.service.CurdService;
import org.apache.ibatis.annotations.Param;

import java.util.*;

public interface SysUserService extends CurdService<SysUser> {
    //查询全部
    List<SysUser> findAll();

    //分页查询
    List<SysUser> findPage();

    //根据标签名称查询
    SysUser findByName(@Param(value = "name") String name);

    //根据标签名称分页查询
    List<SysUser> findPageByName(@Param(value = "name") String name);

    //查找用户的菜单权限
    Set<String> findPermissions(String name);

    //查询用户角色
    List<SysUserRole> findUserRole(Long userId);
}
