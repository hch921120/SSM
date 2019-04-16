package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.dao.SysPermissonDao;
import com.itheima.model.SysPermisson;

import java.util.List;

public interface SysPermissonService {

    /**
     * 分页查询,用户权限列表
     */

    PageInfo<SysPermisson>list(Integer pageNum,Integer pageSize);


    int add(SysPermisson sysPermisson);



    List<SysPermisson> list();

    /**
     * 查询角色拥有的所有权限
     * @param roleId
     * @return
     */

    List<SysPermisson> RolePermisson(Integer roleId);






}
