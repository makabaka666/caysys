package com.qf.controller;

import com.qf.pojo.DateType;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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

}
