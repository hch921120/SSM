package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.SysRoleDao;
import com.itheima.dao.UserDao;
import com.itheima.model.SysRole;
import com.itheima.model.SysUser;
import com.itheima.service.SysRoleService;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Hch
 * @Date: 2019/3/4 09:30
 * @Description:
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private SysRoleDao sysRoleDao;


    public SysUser getByUserName(String username) {

        SysUser sysUser = userDao.getByUserName(username);



        return sysUser;
    }

    public PageInfo<SysUser> list(Integer pageNum,Integer size) {


        PageHelper.startPage(pageNum, size);

        List<SysUser> users = userDao.list();


        PageInfo<SysUser> pageInfo=new PageInfo<SysUser>(users);


        return pageInfo;
    }

    public int add(SysUser sysUser) {

        return  userDao.add(sysUser);

    }

    public List<SysRole> list() {

        List<SysRole> roles = sysRoleDao.list();

        return roles;


    }


    /**
     * 增加用户角色
     * @param userId
     * @param roleIds
     * @return
     */


    public int addUserRole(Long userId, List<Integer> roleIds) {

        int i = sysRoleDao.deleteUserRole(userId);

        int account=0;

        for (Integer roleId : roleIds) {

            account+= sysRoleDao.addUserRole(userId, roleId);

        }
        return account;
    }

    /**
     * 根据ID查询用户信息
     * @param id
     * @return
     */

    public SysUser getUserByid(Long id) {


        SysUser sysUser = userDao.getUserByid(id);
        return  sysUser;
    }


}

