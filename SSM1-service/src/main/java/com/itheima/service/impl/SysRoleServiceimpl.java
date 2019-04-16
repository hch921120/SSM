package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.SysPermissonDao;
import com.itheima.dao.SysRoleDao;
import com.itheima.model.SysRole;
import com.itheima.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Hch
 * @Date: 2019/3/5 17:03
 * @Description:
 */
@Service
public class SysRoleServiceimpl implements SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private SysPermissonDao sysPermissonDao;


    public List<SysRole> list() {

        List<SysRole> roles = sysRoleDao.list();

        return roles;
    }

    public PageInfo<SysRole> list(Integer pageNum, Integer pageSize) {


        PageHelper.startPage(pageNum, pageSize);


        List<SysRole> roles = sysRoleDao.list();


        PageInfo<SysRole> pageInfo=new PageInfo<SysRole>(roles);

        return pageInfo;
    }

    public int add(SysRole sysRole) {

       return sysRoleDao.add(sysRole);
    }

    /**添加角色权限
     *
     * @param roleId
     * @param PermissonIds
     * @return
     */
    public int addRolePermisson(List<Long> PermissonIds,Integer roleId ) {


        int i = sysPermissonDao.deleteRolePermisson(roleId);

        int account=0;


        //循环所有权限ID;

        for (Long permissonId : PermissonIds) {

            //循环增加
            account += sysPermissonDao.addRolePermisson(permissonId, roleId);
        }

        return account;
    }

    /**
     * 根据ID查询出用户拥有的所有角色信息
     * @param userId
     * @return
     */

    public List<SysRole> userRoles(Long userId) {

        List<SysRole> userRoles = sysRoleDao.userRoles(userId);


        return userRoles;
    }


}
