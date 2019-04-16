package com.itheima.model;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: Hch
 * @Date: 2019/3/5 16:58
 * @Description:
 */
public class SysPermisson implements Serializable {

    private Long id;
    private String permissionName;
    private String url;
    private Long pid;
    //一个权限可以授予多个角色，权限和角色之间属于一对多关系，彼此之间属于多对多关系
    private List<SysRole> rols;

    @Override
    public String toString() {
        return "SysPermisson{" +
                "id=" + id +
                ", permissionName='" + permissionName + '\'' +
                ", url='" + url + '\'' +
                ", pid=" + pid +
                ", rols=" + rols +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public List<SysRole> getRols() {
        return rols;
    }

    public void setRols(List<SysRole> rols) {
        this.rols = rols;
    }
}
