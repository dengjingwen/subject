package com.mango.admin.dao;

import com.mango.admin.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    //查询全部
    List<SysUser> findAll();

    //分页查询
    List<SysUser> findPage();

    //根据标签名称查询
    SysUser findByName(@Param(value = "name") String name);

    //根据标签名称分页查询
    List<SysUser> findPageByName(@Param(value = "name") String name);




}