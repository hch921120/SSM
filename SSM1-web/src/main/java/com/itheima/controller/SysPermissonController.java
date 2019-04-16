package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.model.SysPermisson;
import com.itheima.service.SysPermissonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Auther: Hch
 * @Date: 2019/3/5 18:15
 * @Description:
 */

@Controller
@RequestMapping(value = "/sysPermisson")
public class SysPermissonController {

    @Autowired
    private SysPermissonService sysPermissonService;

    @RequestMapping(value = "/list")
    public  String  list(
            @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",required = false,defaultValue = "2")Integer pageSize,
            Model model){

        PageInfo<SysPermisson> pageInfo = sysPermissonService.list(pageNum, pageSize);

        model.addAttribute("pageInfo",pageInfo);

        return "permission-list";
    }


    /**
     * 添加数据操作回显
     */

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(Model model){

        List<SysPermisson> sysPermissons = sysPermissonService.list();

        model.addAttribute("sysPermissons", sysPermissons);


        return "permission-add";

    }

    /**
     * 添加数据
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST)

    public  String add(SysPermisson sysPermisson){

        int account = sysPermissonService.add(sysPermisson);

        return "redirect:/sysPermisson/list";

    }

}
