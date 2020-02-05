package com.mango.admin.service.impl;

import com.mango.admin.dao.SysDictMapper;
import com.mango.admin.model.SysDict;
import com.mango.admin.service.SysDictService;
import com.mango.core.page.ColumnFilter;
import com.mango.core.page.MybatisPageHelper;
import com.mango.core.page.PageRequest;
import com.mango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDictServiceImpl implements SysDictService {

    @Autowired
    public SysDictMapper sysDictMapper;

    @Override
    public List<SysDict> findPage() {
        return sysDictMapper.findPage();
    }

    @Override
    public List<SysDict> findByLabel(String label) {
        return sysDictMapper.findByLabel(label);
    }

    @Override
    public List<SysDict> findPageByLabel(String label) {
        return sysDictMapper.findPageByLabel(label);
    }

    @Override
    public int save(SysDict record) {
        if(record.getId() ==null || record.getId()==0){
            return sysDictMapper.insertSelective(record);
        }
        return sysDictMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysDict record) {
        return sysDictMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysDict> record) {
        for(SysDict records:record){
            delete(records);
        }
        return 1;
    }

    @Override
    public SysDict findById(Long id) {
        return sysDictMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        ColumnFilter columnFilter = pageRequest.getColumnFilter("label");
        if(columnFilter != null) {
            return MybatisPageHelper.findPage(pageRequest, sysDictMapper, "findPageByLabel", columnFilter.getValue());
        }
        return MybatisPageHelper.findPage(pageRequest, sysDictMapper);
    }
}
