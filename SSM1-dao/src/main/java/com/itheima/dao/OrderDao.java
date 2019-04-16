package com.itheima.dao;

import com.itheima.model.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderDao {
    @SelectKey(statement = "select orders_seq.nextval from dual",keyProperty = "id",before =true ,resultType = Long.class)
    @Insert("insert into orders (id,orderNum,orderTime,peopleCount,orderDesc,payType,orderStatus,productId) values (#{id},#{orderNum},#{orderTime},#{peopleCount},#{orderDesc},#{payType},#{orderStatus},#{product.id})")
    int add(Orders orders);


    @Select("select o.* ,p.productName,p.departureTime from orders o ,product p where o.productId=p.id")
    @Results(value = {

            @Result(property = "product.productName",column = "productName"),
            @Result(property = "product.departureTime",column = "departureTime")
    }

    )
    List<Orders> list();
}
