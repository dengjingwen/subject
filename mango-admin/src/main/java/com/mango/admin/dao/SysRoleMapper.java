package com.mango.admin.dao;

import com.mango.admin.model.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    //查找全部
    List<SysRole> findAll();

    //分页查询
    List<SysRole> findPage();

    //按name分页
    List<SysRole> findByName(@Param(value = "name") String name);

    //按name 模糊查询
    List<SysRole> findPageByName(@Param(value = "name")String name);

}