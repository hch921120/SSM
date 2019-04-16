package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.model.Orders;

import java.util.List;

public interface OrderSevice {

    int add(Orders orders);

    List<Orders> list();

    PageInfo<Orders> pageList(int pageNum, int pageSize);

}

