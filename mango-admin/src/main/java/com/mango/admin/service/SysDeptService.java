package com.mango.admin.service;

import com.mango.admin.model.SysDept;
import com.mango.core.service.CurdService;

import java.util.List;

public interface SysDeptService extends CurdService<SysDept> {
    //查找全部
    List<SysDept> findAll();

    //分页
    List<SysDept> findPage();

    //查询机构树
    List<SysDept> findTree();
}
