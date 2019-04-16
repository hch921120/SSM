package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.SysPermissonDao;
import com.itheima.model.SysPermisson;
import com.itheima.service.SysPermissonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Hch
 * @Date: 2019/3/5 17:04
 * @Description:
 */
@Service
public class SysPermissonServiceimpl implements SysPermissonService {

    @Autowired
    private SysPermissonDao sysPermissonDao;


    public PageInfo<SysPermisson>list(Integer pageNum, Integer pageSize) {


        PageHelper.startPage(pageNum, pageSize);

        List<SysPermisson> sysPermissons = sysPermissonDao.list();


        PageInfo<SysPermisson> pageInfo=new PageInfo<SysPermisson>(sysPermissons);


        return pageInfo;
    }

    public int add(SysPermisson sysPermisson) {

        int add = sysPermissonDao.add(sysPermisson);


        return add;
    }

    public List<SysPermisson> list() {


        List<SysPermisson> sysPermissons = sysPermissonDao.list();


        return sysPermissons;
    }

    /**
     * 查询角色拥有的所有权限
     * @param roleId
     * @return
     */

    public List<SysPermisson> RolePermisson(Integer roleId) {

        return sysPermissonDao.RolePermisson(roleId);


    }
}
