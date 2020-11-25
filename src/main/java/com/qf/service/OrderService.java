package com.qf.service;

import com.qf.pojo.Order;
import com.qf.pojo.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService {
    Integer delete(Integer id);
    Integer  insert(Order order);
    List<Orders> selectAll(Integer id, Integer page, Integer limit);
}
