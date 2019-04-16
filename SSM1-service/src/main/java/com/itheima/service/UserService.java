package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.model.SysRole;
import com.itheima.model.SysUser;

import java.util.List;


public interface UserService  {
    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */

    SysUser getByUserName(String username);

    /**
     * 查询用户集合
     * @return
     */

   PageInfo<SysUser> list(Integer pageNum,Integer size);


    /**
     * 添加用户
     */

    int add(SysUser sysUser);


    /**
     * 查询所有用户信息
     */

    List<SysRole> list();


    /**
     * 给用户添加角色
     */


    int  addUserRole(Long userId,List<Integer> roleIds);

    //删除用户已经存在的角色信息

    /**
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    SysUser getUserByid(Long id);





}
