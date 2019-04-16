package com.itheima.dao;

import com.itheima.model.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

        /**
        * 根据用户名查询用户信息
        */
        @Select("select * from sys_user where username=#{username}")
        @ResultMap(value = "userRoleMap")
        SysUser getByUserName(String username);

         /**
         * 查询用户所有信息
         */
         @Select("select * from sys_user")

         List<SysUser> list();


    /**
     * 添加用户信息
     *
     *
     */

    @SelectKey(

            statement = "select SYS_USER_seq.Nextval from dual",
            keyProperty = "id",
            before = true,
            resultType =Long.class
    )
    @Insert("insert into sys_user(id,username,email,password,phoneNum,status)values(#{id},#{username},#{email},#{password},#{phoneNum},#{status})")
    int add(SysUser sysUser);


    /**
     * 根据ID查询用户信息
     */
    @Select("select * from sys_user where id=#{id}")
    @Results(id = "userRoleMap",
            value = {

                    @Result(
                            property = "roles",

                            column = "id",

                            many=@Many(select = "com.itheima.dao.SysRoleDao.userRoles")

                    ),

                   @Result(property = "id",column = "id"

                    )
            }
    )
    SysUser getUserByid(Long id);










}
