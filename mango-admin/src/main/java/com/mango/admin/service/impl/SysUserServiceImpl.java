package com.mango.admin.service.impl;

import com.mango.admin.dao.SysMenuMapper;
import com.mango.admin.dao.SysUserMapper;
import com.mango.admin.dao.SysUserRoleMapper;
import com.mango.admin.model.SysMenu;
import com.mango.admin.model.SysUser;
import com.mango.admin.model.SysUserRole;
import com.mango.admin.service.SysMenuService;
import com.mango.admin.service.SysUserService;
import com.mango.core.page.ColumnFilter;
import com.mango.core.page.MybatisPageHelper;
import com.mango.core.page.PageRequest;
import com.mango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public Set<String> findPermissions(String username) {
       Set<String> perms = new HashSet<>();
       List<SysMenu> sysMenus = sysMenuService.findByUserName(username);
       for (SysMenu list:sysMenus){
           if(list.getPerms() != null && list.getPerms() !=""){
               perms.add(list.getPerms());
           }
       }
        return perms;
    }

    @Override
    public List<SysUserRole> findUserRole(Long userId) {
        return sysUserRoleMapper.findUserRole(userId);
    }

    @Override
    public List<SysUser> findAll() {
        return sysUserMapper.findAll();
    }

    @Override
    public List<SysUser> findPage() {
        return sysUserMapper.findPage();
    }

    @Override
    public int save(SysUser record) {
        if(record.getId() ==null || record.getId()==0){
            return sysUserMapper.insertSelective(record);
        }
        return sysUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysUser record) {
        return sysUserMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysUser> record) {
        for(SysUser records:record){
            delete(records);
        }
        return 1;
    }

    @Override
    public SysUser findById(Long id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        ColumnFilter columnFilter = pageRequest.getColumnFilter("name");
        if(columnFilter != null) {
            return MybatisPageHelper.findPage(pageRequest, sysUserMapper, "findPageByName", columnFilter.getValue());
        }
        return MybatisPageHelper.findPage(pageRequest, sysUserMapper);
    }

    @Override
    public SysUser findByName(String name) {
        return sysUserMapper.findByName(name);
    }

    @Override
    public List<SysUser> findPageByName(String name) {
        return sysUserMapper.findPageByName(name);
    }
}
