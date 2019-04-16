package com.itheima.model;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: Hch
 * @Date: 2019/3/5 16:58
 * @Description:
 */
public class SysRole implements Serializable {

    private Integer id;
    private String roleName;
    private String roleDesc;
    //一个角色可以授予多个用户，角色和用户之间属于一对多关系,彼此之间属于多对多关系
    private List<SysUser> users;
    //一个角色可以有多个权限，角色和权限之间属于一对多关系，彼此之间属于多对多关系

    List<SysPermisson> sysPermissons;

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", users=" + users +
                ", sysPermissons=" + sysPermissons +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<SysUser> getUsers() {
        return users;
    }

    public void setUsers(List<SysUser> users) {
        this.users = users;
    }

    public List<SysPermisson> getSysPermissons() {
        return sysPermissons;
    }

    public void setSysPermissons(List<SysPermisson> sysPermissons) {
        this.sysPermissons = sysPermissons;
    }
}
