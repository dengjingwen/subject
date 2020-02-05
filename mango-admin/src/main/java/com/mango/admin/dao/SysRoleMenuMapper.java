package com.mango.admin.dao;

import com.mango.admin.model.SysRoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);

    SysRoleMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleMenu record);

    int updateByPrimaryKey(SysRoleMenu record);

    //查询角色菜单
    List<SysRoleMenu> findRoleMenus(@Param(value = "roleId") Long roleId);

    //通过roleId删除权限
    int  deleteByRoleId(@Param(value = "roleId") Long roleId);
}