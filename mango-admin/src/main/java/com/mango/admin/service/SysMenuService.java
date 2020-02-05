package com.mango.admin.service;

import com.mango.admin.model.SysMenu;
import com.mango.core.service.CurdService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysMenuService extends CurdService<SysMenu> {


    //分页查询
    List<SysMenu> findPage();

    //查询全部
    List<SysMenu> findAll();

    //通过name分页查询
    List<SysMenu> findPageByName(@Param(value = "name") String name);

    //通过姓名查权限菜单
    List<SysMenu> findByUserName(@Param(value="userName") String userName);

    //查询菜单树
    List<SysMenu> findMenuTree(String userName ,int menuType);



}
