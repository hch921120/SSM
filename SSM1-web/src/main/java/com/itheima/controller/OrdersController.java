package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.model.Orders;
import com.itheima.model.Product;
import com.itheima.service.OrderSevice;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Auther: Hch
 * @Date: 2019/3/2 13:31
 * @Description:
 */
@Controller
@RequestMapping(value = "/order")
public class OrdersController {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderSevice orderSevice;

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String list(Model model){

        List<Product> list = productService.list();

        System.out.println(list);

        model.addAttribute("list",  list);

        return "order-add";


    }

    @RequestMapping(value = "/list")
    public  String add(Model model){

        List<Orders> orders = orderSevice.list();

        model.addAttribute("orders",orders);

        return "order-list";

    }




    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(Orders orders){

        int account = orderSevice.add(orders);


        return "redirect:/order/list";

    }

    /**
     * 分页查看订单信息
     * @param pageNum
     * @param pageSize
     * @param model
     * @return
     */


    @RequestMapping(value = "/page")
    public String orderPage(
          @RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
           @RequestParam(value ="pageSize" ,required = false,defaultValue = "2") int pageSize,
            Model model){

        PageInfo<Orders> pageInfo=orderSevice.pageList(pageNum,pageSize);

        model.addAttribute("pageInfo", pageInfo);

        return "order-list";

    }

}
