package com.zy.Test;

import com.qf.dao.CarMapper;
import com.qf.pojo.Car;
import com.qf.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //使用SpringJUnit4ClassRunner来启动测试
@ContextConfiguration("classpath:spring-context.xml")
public class testcar {
    @Autowired
        CarService  carservice;
    @Test
    public  void  test1(){
       List<Car> cars= carservice.selectOne(6);
        System.out.println("cars = " + cars);
    }
}
