package com.mango.admin.service.impl;

import com.mango.admin.constants.SysConstants;
import com.mango.admin.dao.SysMenuMapper;
import com.mango.admin.dao.SysRoleMapper;
import com.mango.admin.dao.SysRoleMenuMapper;
import com.mango.admin.model.SysMenu;
import com.mango.admin.model.SysRole;
import com.mango.admin.model.SysRoleMenu;
import com.mango.admin.service.SysRoleService;
import com.mango.core.page.ColumnFilter;
import com.mango.core.page.MybatisPageHelper;
import com.mango.core.page.PageRequest;
import com.mango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Autowired
    private SysMenuMapper  sysMenuMapper;

    @Override
    public List<SysRole> findAll() {
        return sysRoleMapper.findAll();
    }
    @Override
    public List<SysRole> findPage() {
        return sysRoleMapper.findPage();
    }

    @Override
    public List<SysMenu> findRoleMenus(Long roleId) {
        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(roleId);
        if(SysConstants.ADMIN.equalsIgnoreCase(sysRole.getName())){
            //如果是超级管理员，则返回全部
            return sysMenuMapper.findAll();
        }
        return sysMenuMapper.findRoleMenus(roleId);
    }

    @Transactional
    @Override
    public int saveRoleMenus(List<SysRoleMenu> records) {
        if(records ==null || records.isEmpty()){
            return 1;
        }
        Long roleId = records.get(0).getRoleId();
        sysRoleMenuMapper.deleteByRoleId(roleId);
        for (SysRoleMenu record :records){
            sysRoleMenuMapper.insertSelective(record);
        }
        return 1;
    }

    @Override
    public List<SysRole> findByName(String name) {
        return sysRoleMapper.findByName(name);
    }

    @Override
    public List<SysRole> findPageByName(String name) {
        return sysRoleMapper.findPageByName(name);
    }

    @Override
    public int save(SysRole record) {
        return sysRoleMapper.insertSelective(record);
    }

    @Override
    public int delete(SysRole record) {
        return sysRoleMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysRole> record) {
        for (SysRole records:record){
            delete(records);
        }
        return 1;
    }

    @Override
    public SysRole findById(Long id) {
        return sysRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        ColumnFilter columnFilter = pageRequest.getColumnFilter("name");
        if(columnFilter != null) {
            return MybatisPageHelper.findPage(pageRequest, sysRoleMapper, "findPageByName", columnFilter.getValue());
        }
        return MybatisPageHelper.findPage(pageRequest, sysRoleMapper);
    }
}
