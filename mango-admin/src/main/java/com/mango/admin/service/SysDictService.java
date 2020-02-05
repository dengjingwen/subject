package com.mango.admin.service;

import com.mango.admin.model.SysDict;
import com.mango.core.service.CurdService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysDictService extends CurdService<SysDict> {
    //分页查询
    List<SysDict> findPage();

    //根据标签名称查询
    List<SysDict> findByLabel(@Param(value = "label") String label);

    //根据标签名称分页查询
    List<SysDict> findPageByLabel(@Param(value = "label") String label);
}
