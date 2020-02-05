package com.mango.admin.service.impl;

import com.mango.admin.model.SysLog;
import com.mango.admin.service.SysLogService;
import com.mango.core.page.PageRequest;
import com.mango.core.page.PageResult;

import java.util.List;

public class SysLogServiceImpl implements SysLogService {
    @Override
    public int save(SysLog record) {
        return 0;
    }

    @Override
    public int delete(SysLog record) {
        return 0;
    }

    @Override
    public int delete(List<SysLog> record) {
        return 0;
    }

    @Override
    public SysLog findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return null;
    }
}
