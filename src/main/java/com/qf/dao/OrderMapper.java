package com.qf.dao;

import com.qf.pojo.Order;
import com.qf.pojo.Orders;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderMapper {
    Integer delete(@Param("id") Integer id);
    Integer  insert(Order order);
    List<Orders> selectAll(@Param("id")Integer id);
}
