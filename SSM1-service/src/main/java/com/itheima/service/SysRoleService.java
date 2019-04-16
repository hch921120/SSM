package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.model.SysRole;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface SysRoleService  {


    /**
     * 查询所有角色信息
     */


    List<SysRole>list();

    /**
     * 分页查询角色信息
     * @return
     */

    PageInfo <SysRole> list(Integer pageNum,Integer pageSize);


    /**
     * 添加角色
     */

    int add(SysRole sysRole);


    /**
     * 角色授权
     * @param roleId
     * @param PermissonIds
     * @return
     */

    int addRolePermisson(List<Long>PermissonIds,Integer roleId);


    /**
     * 根据ID查询出用户拥有的用色信息
     *
     */

    List<SysRole> userRoles(Long userId);

}
