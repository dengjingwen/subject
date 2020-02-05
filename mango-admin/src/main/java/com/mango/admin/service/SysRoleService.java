package com.mango.admin.service;

import com.mango.admin.model.SysDict;
import com.mango.admin.model.SysMenu;
import com.mango.admin.model.SysRole;
import com.mango.admin.model.SysRoleMenu;
import com.mango.core.service.CurdService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleService extends CurdService<SysRole> {

    //查找全部
    List<SysRole> findAll();

    //分页查询
    List<SysRole> findPage();

    //按name分页
    List<SysRole> findByName(@Param(value = "name") String name);

    //按name 模糊查询
    List<SysRole> findPageByName(@Param(value = "name")String name);

    //查询角色菜单集合
    List<SysMenu> findRoleMenus( Long roleId);

    //保存角色菜单
    int saveRoleMenus(List<SysRoleMenu> records);
}
