package com.qf.controller;

import com.github.pagehelper.PageInfo;
import com.qf.pojo.DateType;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SessionAttributes("user")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user, Model model){
        User users = userService.selectByTelAndPassword(user.getTel(),user.getPassword());
        if (users!=null){
           model.addAttribute("user",users);
           return "{\"code\":1}";
        }else{
            return "{\"code\":0}";
        }
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(User user){
        Integer i = userService.insertUser(user);
        if (i==1){
            return"{\"code\":1}";
        }else{
            return"{\"code\":0}";
        }
    }
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public DateType getUser(HttpServletRequest request, HttpServletResponse response){
       HttpSession session = request.getSession();
       User user = (User) session.getAttribute("user");
        List users = new ArrayList();
        users.add(user);
        DateType date = new DateType();
        date.setCode(1);
        date.setInfo(users);
        return date;
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public DateType update(HttpServletRequest request, HttpServletResponse response,String tel){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user.setTel(tel);
        Integer i = userService.update(user);
        List users = new ArrayList();
        DateType date = new DateType();
        if (i>0){
            users.add(user);
            date.setCode(1);
            date.setInfo(users);
            return date;
        }else{
            date.setCode(0);
            return  date;
        }
    }

    @RequestMapping(value = "/updateEmail",method = RequestMethod.POST)
    public DateType updateEmail(HttpServletRequest request, HttpServletResponse response,String email){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user.setEmail(email);
        Integer i = userService.update(user);
        List users = new ArrayList();
        DateType date = new DateType();
        if (i>0){
            users.add(user);
            date.setCode(1);
            date.setInfo(users);
            return date;
        }else{
            date.setCode(0);
            return  date;
        }
    }
    @RequestMapping(value = "/updatePassword",method = RequestMethod.POST)
    public DateType updatePassword(HttpServletRequest request, HttpServletResponse response,String password) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user.setPassword(password);
        Integer i = userService.update(user);
        List users = new ArrayList();
        DateType date = new DateType();
        if (i > 0) {
            users.add(user);
            date.setCode(1);
            date.setInfo(users);
            return date;
        } else {
            date.setCode(0);
            return date;
        }
    }
        @RequestMapping(value = "/getName",method = RequestMethod.GET)
        public DateType getName(HttpServletRequest request, HttpServletResponse response,String password) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String name = user.getTel();
        DateType date = new DateType();
        if (user!= null) {
            date.setCode(1);
            date.setName(name);
            return date;
        } else {
            date.setCode(0);
            return date;
        }
    }

    @RequestMapping("/selectAll")
    public DateType selectAll(Integer page,Integer limit){
        List user = userService.selectAll(page,limit);
        PageInfo pageInfo = new PageInfo(user);
        DateType date = new DateType();
        date.setCount(pageInfo.getTotal());
        date.setData(user);
        date.setCode(0);
        return date;
    }
    @RequestMapping("/selectOneById")
    public DateType selectOneById(@RequestBody Map map){
        User users = userService.selectOneById(Integer.valueOf(map.get("id").toString()));
        DateType date = new DateType();
        date.setData(users);
        date.setCode(0);
        return date;
    }
    @RequestMapping(value = "/updateById",method = RequestMethod.POST)
    public Integer updateById(@RequestBody User user){
        if (user.getId()==null){
            return userService.insertUser(user);
        }else{
            return userService.update(user);
        }
    }
    @RequestMapping(value = "/deleteById",method = RequestMethod.POST)
    public Integer deleteById(@RequestBody Map map){
       return  userService.deleteById(Integer.valueOf(map.get("id").toString()));
    }

}
