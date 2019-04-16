package com.itheima.controller;
import com.github.pagehelper.PageInfo;
import com.itheima.model.SysPermisson;
import com.itheima.model.SysRole;
import com.itheima.model.SysUser;
import com.itheima.service.SysPermissonService;
import com.itheima.service.SysRoleService;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Hch
 * @Date: 2019/3/5 17:11
 * @Description:
 */
@Controller
@RequestMapping(value = "/role")
@RolesAllowed("ROLE_ADMIN")
//@Secured("ROLE_ADMIN")
public class SysRoleController {

    /**
     * 查询所有角色
     */

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysPermissonService sysPermissonService;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/list")
    public String list(
            @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(value = "PageSize",required = false,defaultValue = "2") Integer PageSize,
            Model model){

        PageInfo<SysRole> pageInfo = sysRoleService.list(pageNum, PageSize);

        model.addAttribute("pageInfo",pageInfo);

        return "role-list";

    }

    /**
     * 添加角色
     */
    @RequestMapping(value = "/add")
    public String add(SysRole sysRole){

        int add = sysRoleService.add(sysRole);

        return "redirect:/role/list";
    }


    /**
     * 角色授权弹框
     * url:/role/permission/add   get
     *
     * 需要获取角色ID
     *
     * 跳转页面
     */

    @RequestMapping(value = "/permission/add",method = RequestMethod.GET)

    public  String addRolepermission(Integer id,Model model){

        /**
         * 查询角色拥有的所有权限
         */

        List<SysPermisson> rolePermissonss = sysPermissonService.RolePermisson(id);


        if (rolePermissonss!=null){

            StringBuffer buffer=new StringBuffer();

            for (SysPermisson rolePermisson : rolePermissonss) {

                //循环拼接
                buffer.append("["+rolePermisson.getId()+"]");
            }
            model.addAttribute("rolePermisson", buffer.toString());

        }
        //加载所有菜单数据

        List<SysPermisson> rolepermissons = sysPermissonService.list();

        //所有菜单数据存储到Model中页面回显

        model.addAttribute("rolepermissons",rolepermissons);

        //角色ID存储到model中,页面回显

        model.addAttribute("id",id);

        return "role-permission-add";
    }

    /***
     * 给角色添权限
     *
     * URL:/role/permission/add   post
     *
     * 接收参数:roleId,list<Long>IDS
     *
     * 调用service
     *
     * 设计响应信息:json
     *
     * 执行状态:success,成功false;失败
     * 提示信息
     */
    @ResponseBody
    @RequestMapping(value = "/permission/add",method = RequestMethod.POST)

    public Map<String,Object> add(Integer roleId,@RequestParam List<Long>ids){

        //创建一个map结构响应数据,存储响应数据

        Map<String,Object> result=new HashMap<String,Object>();

            try {

                int account = sysRoleService.addRolePermisson(ids,roleId);

                    if (account>0) {

                        result.put("success", true);

                        result.put("message", "恭喜你授权成功");

                        return result;
                    }
            } catch (Exception e) {
                e.printStackTrace();
            }
            result.put("success", false);

            result.put("message", "授权不成功");

            return result;


    }


}



