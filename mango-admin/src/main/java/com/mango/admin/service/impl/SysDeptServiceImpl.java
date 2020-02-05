package com.mango.admin.service.impl;

import com.mango.admin.dao.SysDeptMapper;
import com.mango.admin.model.SysDept;
import com.mango.admin.service.SysDeptService;
import com.mango.core.page.MybatisPageHelper;
import com.mango.core.page.PageRequest;
import com.mango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SysDeptServiceImpl implements SysDeptService {

    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Override
    public List<SysDept> findAll() {
        return sysDeptMapper.findAll();
    }

    @Override
    public List<SysDept> findPage() {
        return sysDeptMapper.findPage();
    }

    @Override
    public List<SysDept> findTree() {
        List<SysDept> sysDepts =new ArrayList<>();//创建最高层节点
        List<SysDept> depts =sysDeptMapper.findAll();//找到全部的部门

        for(SysDept dept:depts){//遍历全部的部门
            if(dept.getParentId()==null || dept.getParentId()==0){//查找根节点或父节点
                dept.setLevel(0);//将父节点加入集合中
                sysDepts.add(dept);//将父节点部门加入实体类中
            }
        }
        //将有父节点部门实体类与全部部门集合作为findChildren的参数，调用该方法
        //找括号里面的数据的父节点数据
        findChildren(sysDepts,depts);
        return sysDepts;
    }

    private void findChildren(List<SysDept> sysDepts, List<SysDept> depts) {
        //遍历部门实体类
        for (SysDept sysDept:sysDepts){
            //创建子节点
            List<SysDept> children =new ArrayList<>();
            //遍历全部部门
            for (SysDept dept:depts){
                //如果该部门id!= null 且 实体类部门id与部门父节点id相等
                if (sysDept.getId() != null && sysDept.getId().equals(dept.getParentId())){
                //那么将该部门的name加入父节点集合
                    dept.setParentName(dept.getName());
                 //保存该部门的级别，且该部门级别加一
                    dept.setLevel(sysDept.getLevel()+1);
                 //将该集合加入子节点集合中
                    children.add(dept);
                }
            }
            //将子节点集合加入部门实体类中
            sysDept.setChildren(children);
            //找括号里面的数据的子节点数据
            findChildren(children,depts);//递归算法
        }


    }

    @Override
    public int save(SysDept record) {
        return sysDeptMapper.insertSelective(record);
    }

    @Override
    public int delete(SysDept record) {
        return sysDeptMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysDept> record) {
        for (SysDept records:record){
            delete(records);
        }
        return 1;
    }

    @Override
    public SysDept findById(Long id) {
        return sysDeptMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, sysDeptMapper);
    }
}
