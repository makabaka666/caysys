package com.zy.Test;

import com.qf.pojo.User;
import com.qf.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //使用SpringJUnit4ClassRunner来启动测试
@ContextConfiguration("classpath:spring-context.xml")
public class testUser {
    @Autowired
    UserService userService;

    @Test
    public void test(){
        User user = userService.selectByTelAndPassword("123456","123456");
        System.out.println("user = " + user);
    }
    @Test
    public void testInsert(){
        User users = new User(null,"11","11","11","11");
       int i = userService.insertUser(users);
        System.out.println("user = " + i);
    }
}
