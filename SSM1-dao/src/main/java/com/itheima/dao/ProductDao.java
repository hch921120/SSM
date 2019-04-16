package com.itheima.dao;

import com.itheima.model.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProductDao {

    /**
     * 查询商品信息
     * @return
     */
    @Select("select * from product")
    List<Product> list();

    /***
     * 增加操作
     * @param product
     * @return
     */
    @SelectKey(statement = "SELECT PRODUCT_SEQ.NEXTVAL FROM dual", keyProperty = "id", before = true, resultType =Integer.class)
    @Insert("insert into product(id,productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)values(#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    int add(Product product);


    /**
     * 根据Id查询商品信息
     *
     */

    @Select("select * from product where id=#{id}")
    Product getByid(Integer id);


    @Update("update product set productNum = #{productNum},productName=#{productName},cityName=#{cityName},departureTime=#{departureTime},productPrice=#{productPrice},productDesc=#{productDesc},productStatus=#{productStatus} where id = #{id}")
    int update(Product product);


    /**
     * 根据ID删除商品
     */

    @Delete("delete from  product where id =#{id}")
    int  delete(Integer id);


    /**
     * 在注解SQL语句中,如果有多个基本数据类型或是string类型有用注解
     * s使用@Param设置别名
     * @return
     */


    @Select("select count(*) from product")
    int findAccount();

//    @Select("select * from(select rownum rn,p.* from product p) rp where rp.rn between #{start} and #{end}")
    @Select("select * from product")
    List<Product> pageList(@Param(value = "start") int start,@Param(value = "end") int end);

}
