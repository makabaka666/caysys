package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.qf.dao.OrderMapper;
import com.qf.pojo.Order;
import com.qf.pojo.Orders;
import com.qf.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;
    @Override
    public Integer delete(Integer id) {
        return orderMapper.delete(id);
    }

    @Override
    public Integer insert(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public List<Orders> selectAll(Integer id, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        return orderMapper.selectAll(id);
    }
}
