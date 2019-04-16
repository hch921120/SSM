package com.itheima.dao;

import com.itheima.model.SysPermisson;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SysPermissonDao {

    /**
     *查询权限列表
     *
     */

    @Select("SELECT * FROM Sys_Permission")

    List<SysPermisson> list();

    /**
     *添加权限信息
     * @param sysPermisson
     * @return
     */

    @SelectKey(
            statement = "select Sys_Permission_seq.Nextval from dual",
            keyProperty = "id",
            before = true,

            resultType =Long.class
    )

    @Insert("insert into Sys_Permission ( id,permissionName,url,pid)values( #{id},#{permissionName},#{url},#{pid})")
    int add(SysPermisson sysPermisson);


    /**
     * 给角色添加权限
     * @return
     */
    @Insert("insert into sys_role_permission(permissionId,roleId)values(#{permissionId},#{roleId})")
    int addRolePermisson(
            @Param(value = "permissionId") Long permissionId,
            @Param(value = "roleId") Integer roleId);


    /**
     * 查询用户拥有的所有权限
     *
     * 角色ID
     */
    @Select("select sp.* from sys_permission sp,sys_role_permission srp where sp.id=srp.permissionid and srp.roleid=#{roleId}")
    List<SysPermisson> RolePermisson(Integer roleId);


    /**
     * 删除用户已经拥有的权限
     */

    @Delete("delete from sys_role_permission where roleid=#{id}")
    int deleteRolePermisson(Integer id);









}
