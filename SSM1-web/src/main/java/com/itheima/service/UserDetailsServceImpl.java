package com.itheima.service;

import com.itheima.model.SysRole;
import com.itheima.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 自定义授权认证的方法
 * @Auther: Hch
 * @Date: 2019/3/4 13:05
 * @Description:
 */
public class UserDetailsServceImpl implements UserDetailsService {

    @Autowired
    private  UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //查询用户账号信息
        SysUser sysUser = userService.getByUserName(username);


        //查询用户角色信息

        //String  userRole="ROLE_ADMIN";

        //创建集合
        List<GrantedAuthority> authorities =new ArrayList<GrantedAuthority>();

        //从数据库加载角色信息

        List<SysRole> roles = sysUser.getRoles();

        for (SysRole role : roles) {

            SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(role.getRoleName());

            authorities.add(simpleGrantedAuthority);

        }
        User user = new User(username,sysUser.getPassword(),authorities );



        //将账户信息和角色信息封装到UserDetails中回传给springserurity

        return user;
    }
}
