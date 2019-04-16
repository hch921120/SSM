package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.ProductDao;
import com.itheima.model.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Hch
 * @Date: 2019/3/1 12:10
 * @Description:
 */

@Service
public class ProductServiceimpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    public List<Product> list() {

        List<Product> list = productDao.list();
        return list;
    }

    public void add(Product product) {

        productDao.add(product);

    }

    public Product getByid(Integer id) {

        Product product = productDao.getByid(id);

        return product;
    }

    public int update(Product product) {

         return productDao.add(product);

    }

    public int delete(Integer id) {

        int acount = productDao.delete(id);

        return acount;
    }

    public PageInfo<Product> pageList(int page, int size) {


//
//        /**
//         * 获取总记录数
//         *
//         */
//        int account= productDao.findAccount();
//
//        pageInfo.setTotal(account);
//        /**
//         * 获取结果集对象
//         */
//
//        int start =(page-1)*size+1;
//
//        int end=page*size;
//
//        List<Product>products= productDao.pageList(start,end);
//
//        pageInfo.setList(products);
//
//
//        pageInfo.setPageNum(page);


        PageHelper.startPage(page, size);

        List<Product> products = productDao.pageList(page,size);


        PageInfo<Product> pageInfo= new PageInfo<Product>(products);

        return pageInfo;




    }
}
