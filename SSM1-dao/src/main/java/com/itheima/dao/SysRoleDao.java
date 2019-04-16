package com.itheima.dao;

import com.itheima.model.SysRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SysRoleDao {

    /**
     * 查询角色
     */

    @Select("SELECT * FROM Sys_Role")
    List<SysRole> list();


    /**
     * 添加角色
     */

    @SelectKey(

            statement = "select Sys_Role_seq.Nextval from dual",
            keyProperty = "id",

            before = true,

            resultType = Integer.class
    )
    @Insert("insert into Sys_Role( id,roleName,roleDesc)values(#{id},#{roleName},#{roleDesc})")
    int add(SysRole sysRole);



    //给用户添加角色

    @Insert("insert into sys_user_role(userId,roleId)values(#{userId},#{roleId})")
    int addUserRole(@Param(value = "userId") Long userId,
                    @Param(value = "roleId") Integer roleId);



    //删除用户已经存在的角色信息

    @Delete("delete from sys_user_role where userId=#{userId}")
    int deleteUserRole(Long userId);

    /**
     * 根据ID查询用户的角色
     * @param userId
     * @return
     */

    @Select("select sr.* from sys_role sr, sys_user_role sur where sur.userid=#{userId}and sur.roleid=sr.id ")

    @Results(
            value = {
                    @Result(
                            property = "sysPermissons",

                            column = "id",

                            many =@Many(select = "com.itheima.dao.SysPermissonDao.RolePermisson")


                    ),
                    @Result(property = "id" ,column = "id")
            }
    )

    List<SysRole> userRoles(Long userId);

}
