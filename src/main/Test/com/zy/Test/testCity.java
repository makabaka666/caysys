package com.zy.Test;

import com.qf.pojo.City;
import com.qf.service.CityService;
import com.qf.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //使用SpringJUnit4ClassRunner来启动测试
@ContextConfiguration("classpath:spring-context.xml")
public class testCity {
    @Autowired
    CityService cityService;
    @Test
    public void test(){
       List<City>  city=cityService.selectAll();
        System.out.println("city = " + city);
    }
    @Test
    public void test11(){
        List<City> city=cityService.selectById(0);
        System.out.println("city = " + city);
    }
    @Test
    public void test12(){
        List<City> city=cityService.selectOne(1,2);
        System.out.println("city = " + city);
    }
}
