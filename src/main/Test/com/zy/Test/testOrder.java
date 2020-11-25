package com.zy.Test;

import com.qf.pojo.Order;
import com.qf.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //使用SpringJUnit4ClassRunner来启动测试
@ContextConfiguration("classpath:spring-context.xml")
public class testOrder {
    @Autowired
    OrderService orderService;
    @Test
    public  void  tets1(){
        List list = orderService.selectAll(1,1,5);
        System.out.println("list = " + list);
    }
}
