package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.dao.SysRoleDao;
import com.itheima.model.SysRole;
import com.itheima.model.SysUser;
import com.itheima.service.SysRoleService;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Hch
 * @Date: 2019/3/5 13:53
 * @Description:
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping(value = "/list")
    public String list(
            @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(value = "size",required = false,defaultValue = "2") Integer size,
            Model model){




        PageInfo<SysUser> pageInfo = userService.list(pageNum, size);

        model.addAttribute("pageInfo",pageInfo);

        return "user-list";
    }


    @RequestMapping(value = "/add")
    public  String  add(SysUser sysUser){

        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

        String pwd = encoder.encode(sysUser.getPassword());

        sysUser.setPassword(pwd);

        int i = userService.add(sysUser);

        return "redirect:/user/list";


    }

    /**给用户添加角色
     * user/role/add  get
     *
     * 接收参数:userid
     *
     * 存入Model回显
     *
     */

    @RequestMapping(value = "/role/add",method = RequestMethod.GET)

    public  String  addUserRole(Long id,Model model){

        List<SysRole> userRoles = sysRoleService.userRoles(id);

        if (userRoles!=null){


            StringBuffer buffer=new StringBuffer();


                for (SysRole userRole : userRoles) {

                buffer.append("["+userRole.getId()+"]");
            }

            model.addAttribute("userRoles",buffer.toString());



        }

        /**
         * 查询所有角色信息
         */
        List<SysRole> roles = sysRoleService.list();

        //将角色信息存储到model回显

        model.addAttribute("roles", roles);

        //将用户ID存储到model回显

        model.addAttribute("id", id);


        return "user-role-add";

    }

    /**
     * 给用户添加角色
     *
     * url:/user/role/add
     *
     * 接收参数:userID,list<Integer> roleId</>
     *
     * 调用service
     * 设计json响应格式
     *
     *执行状态:success,
     * 提示信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/role/add",method = RequestMethod.POST)

    public  Map<String,Object> add(Long userId,@RequestParam List<Integer>ids){

        Map<String,Object>result=new HashMap<String, Object>();

        try {
            int account =userService.addUserRole(userId, ids);

            if (account>0){

                result.put("success", true);

                result.put("message", "恭喜你添加角色成功");
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        result.put("success", false);

        result.put("message", "添加角色失败");

        return result;


    }


    /**
     * 根据ID查询用户信息
     * url:/user/one/{id}
     *
     * 获取用户ID
     *
     * 调用service实现查询
     *
     * 数据存储到model回显
     */
    @RequestMapping(value = "/one/{id}")
    public String  findUserByid(@PathVariable(value = "id")Long id, Model model){

        SysUser sysUser = userService.getUserByid(id);

        model.addAttribute("sysUser",sysUser);


        return "user-show";


    }



}
