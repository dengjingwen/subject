package com.mango.core.service;

import com.mango.core.page.PageRequest;
import com.mango.core.page.PageResult;

import java.util.List;

//通用CURD接口
/*
* 是对通用增删改查接口的封装，统一定义了包含保存、
* 删除、批量删除、根据id查询和分页查询方法，一般的业务Service
* 接口会继承此接口，提供基础增删改查服务，这几个接口能满足大部分基础CURD
* 业务的需求
* */
public interface CurdService<T> {
    //保存操作  @param record
    int save(T record);

    //删除操作  @param record
    int delete(T record);

    //批量删除操作  @param  entities
    int delete(List<T> record);

    //根据id查询   @param  id
    T findById(Long id);

    /*
    * 分页查询
    *这里统一封装了分页请求和结果，避免直接引入具体框架的分页对象，
    * 如mybatis 或 jpa 的分页对象从而避免因为替换ORM 框架而导致服务层、
    * 控制层的分页接口也需要变动的情况，替换ORM框架也不会影响服务层
    * 以上的分页接口，起到了了解耦的作用
    * @param pageRequest  自定义：统一分页查询请求
    * @param PageResult   自定义：统一分页查询结果
    * */


    PageResult findPage(PageRequest pageRequest);
}
