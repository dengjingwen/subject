package com.mango.admin.service.impl;

import com.mango.admin.constants.SysConstants;
import com.mango.admin.dao.SysMenuMapper;
import com.mango.admin.model.SysDict;
import com.mango.admin.model.SysMenu;
import com.mango.admin.service.SysMenuService;
import com.mango.core.page.ColumnFilter;
import com.mango.core.page.MybatisPageHelper;
import com.mango.core.page.PageRequest;
import com.mango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    //查询菜单树
    @Override
    public List<SysMenu> findMenuTree(String userName ,int menuType) {
        List<SysMenu> sysMenus = new ArrayList<>();//创建最高节点
        List<SysMenu> menus =findByUserName(userName);//查询菜单
        for (SysMenu menu : menus){//遍历全部菜单
            if (menu.getParentId()==null || menu.getParentId()==0){//查找父节点或者根节点
                menu.setLevel(0);//将父节点加入集合中
                if (!exist(sysMenus,menu)) {
                    sysMenus.add(menu);//将父节点部门加入实体类中
                }
            }
        }
        //将有父节点部门实体类与有父节点的菜单集合作为findChildren的参数，调用该方法
        //找括号里面的数据的父节点数据
        sysMenus.sort((o1, o2) -> o1.getOrderNum().compareTo(o2.getOrderNum()));
        findChildren(sysMenus ,menus ,menuType);
        return sysMenus;
    }

    private void findChildren(List<SysMenu> sysMenus,List<SysMenu> menus,int menuType){
        //遍历实体类菜单
        for(SysMenu sysMenu : sysMenus){
            //创建新的子节点
            List<SysMenu> children = new ArrayList<>();
            //遍历所有的菜单
            for (SysMenu menu : menus){
                if (menuType == 1 && menu.getType() ==2){
                    // 如果是获取类型不需要按钮，且菜单类型是按钮的，直接过滤掉
                    continue;
                }
                //判断菜单的id 不为空且 该菜单的父节点id与实体类菜单id是否相等
                if (menu.getId() != null && menu.getParentId().equals(sysMenu.getId())){
                    //是的话,那么将该菜单的name加入到父节点集合中,并且保存该父节点
                    menu.setParentName(menu.getName());
                    //保存该菜单，并且该菜单级别加一
                    menu.setLevel(sysMenu.getLevel()+1);
                    //将该菜单加入到空的子节点集合中
                    children.add(menu);
                }
            }
            //将该新的子节点集合加入到实体类菜单中
            sysMenu.setChildren(children);
            children.sort((o1, o2) -> o1.getOrderNum().compareTo(o2.getOrderNum()));
            //递归算法
            findChildren(children,menus,menuType);
        }
    }

    //判断子父节点中是否存在该子节点
    private boolean exist(List<SysMenu> sysMenus , SysMenu sysMenu){
        boolean exist = false;
        for (SysMenu menu :sysMenus){
            if (menu.getId().equals(sysMenu.getId())){
                exist = true;
            }
        }
        return exist;
    }


    //分页查询
    @Override
    public List<SysMenu> findPage() {
        return sysMenuMapper.findPage();
    }

    @Override
    public List<SysMenu> findAll() {
        return sysMenuMapper.findAll();
    }

    //通过name模糊查询
    @Override
    public List<SysMenu> findPageByName(String name) {
        return sysMenuMapper.findPageByName(name);
    }

    //通过姓名查权限菜单
    @Override
    public List<SysMenu> findByUserName(String userName) {
        if(userName == null || "".equals(userName) || SysConstants.ADMIN.equals(userName)){
            return sysMenuMapper.findAll();
        }
        return sysMenuMapper.findByUserName(userName);
    }

    @Override
    public int save(SysMenu record) {
        return sysMenuMapper.insertSelective(record);
    }

    @Override
    public int delete(SysMenu record) {
        return sysMenuMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysMenu> record) {
        for(SysMenu records:record){
            delete(records);
        }
        return 1;
    }

    @Override
    public SysMenu findById(Long id) {
        return sysMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        ColumnFilter columnFilter = pageRequest.getColumnFilter("name");
        if(columnFilter != null) {
            return MybatisPageHelper.findPage(pageRequest, sysMenuMapper, "findPageByName", columnFilter.getValue());
        }
        return MybatisPageHelper.findPage(pageRequest, sysMenuMapper);
    }
}
