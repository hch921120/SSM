package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.model.Product;
import com.itheima.service.ProductService;
import com.itheima.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Auther: Hch
 * @Date: 2019/3/1 12:31
 * @Description:
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    /**
     * 商品列表查询
     *
     */
    @RequestMapping(value = "/list")
    public String list(Model model){

        List<Product> list = productService.list();

        model.addAttribute("list",list);

        return "product-list";

    }


    /**
     * 添加用户操作
     *
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String  add(Product product){

        productService.add(product);

        return "redirect:/product/list";

    }


    /**
     * 根据ID查询一条数据
     */

    @RequestMapping(value = "/one")
    public String getByid(Integer id,Model model){

        Product product = productService.getByid(id);


        model.addAttribute("product",product);

        return "product-update";

    }


    /**
     * 修改产品
     * @return
     */
    @RequestMapping(value = "/update")
    public String update(Product product){

        int account = productService.update(product);


        return "redirect:/product/list";

    }


    /**
     * 根据ID删除商品
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)

    public  String  delete(@PathVariable(value = "id")Integer id){


        int acount = productService.delete(id);

        return "redirect:/product/list";

    }


    /**
     * 分页查询
     */

    @RequestMapping(value = "/listall")
        public String lista11(@RequestParam(value = "page",required = false,defaultValue = "1") int page,
                              @RequestParam(value = "size",required = false,defaultValue = "5") int size,
                              Model model){

            PageInfo<Product> pageInfo=productService.pageList(page,size);



            model.addAttribute("pageInfo",pageInfo);

            return "product-list";



    }


}
