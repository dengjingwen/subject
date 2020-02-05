package com.mango.admin.dao;

import com.mango.admin.model.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    //查询全部菜单
     List<SysMenu> findPage();

     //查询全部
     List<SysMenu> findAll();

     //通过name分页查询
     List<SysMenu> findPageByName(@Param(value = "name") String name);

     //通过姓名查权限菜单
     List<SysMenu> findByUserName(@Param(value="userName") String userName);

     //查找权限菜单
    List<SysMenu> findRoleMenus(@Param(value="roleId")Long roleId);

}