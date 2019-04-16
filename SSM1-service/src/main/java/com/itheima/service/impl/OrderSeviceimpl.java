package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.OrderDao;
import com.itheima.model.Orders;
import com.itheima.service.OrderSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Hch
 * @Date: 2019/3/2 12:57
 * @Description:
 */

@Service
public class OrderSeviceimpl implements OrderSevice {

    @Autowired
    private OrderDao orderDao;

    public int add(Orders orders) {

       return orderDao.add(orders);

    }

    public List<Orders> list() {

        List<Orders> orders = orderDao.list();
        return orders;
    }

    public PageInfo<Orders> pageList(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);

        List<Orders> orders = orderDao.list();

        PageInfo<Orders> pageInfo=new PageInfo<Orders>(orders);

        return pageInfo;
    }
}
