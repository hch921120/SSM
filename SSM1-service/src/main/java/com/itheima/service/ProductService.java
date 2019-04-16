package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.model.Product;

import java.util.List;

public interface ProductService {

    List<Product>list();

    void add(Product product);

    Product getByid(Integer id);



    int update(Product product);

    /**
     * 根据ID删除商品
     * @param id
     * @return
     */

    int  delete(Integer id);


    PageInfo<Product> pageList(int page, int size);
}
