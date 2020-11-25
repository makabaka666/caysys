package com.qf.controller;

import com.github.pagehelper.PageInfo;
import com.qf.pojo.DateType;
import com.qf.pojo.Order;
import com.qf.pojo.User;
import com.qf.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping("/selectAll")
    public DateType selectAll(HttpServletRequest request, HttpServletResponse response,Integer page){
        HttpSession ss = request.getSession();
        User user = (User) ss.getAttribute("user");
        List order = orderService.selectAll(user.getId(),page,5);
        PageInfo pageInfo = new PageInfo(order);
        DateType date = new DateType();
        date.setCount(pageInfo.getTotal());
        date.setInfo(order);
        date.setCode(1);
        return date;
    }
    @RequestMapping("/delete")
    public DateType delete(Integer id){
        Integer i= orderService.delete(id);
        DateType date = new DateType();
        if (i>0){
            date.setCode(1);
            return date;
        }else{
            date.setCode(0);
            return date;
        }

    }
    @RequestMapping("/insert")
    public DateType insert(HttpServletRequest request, HttpServletResponse response, Integer cid, Integer getid, Integer backid,double oprice){
        HttpSession ss = request.getSession();
        User user = (User) ss.getAttribute("user");
        Order order = new Order();
        order.setCid(cid);
        order.setUid(user.getId());
        order.setGetid(getid);
        order.setBackid(backid);
        order.setOprice(oprice);
        order.setStatus("已预订");
        Integer i = orderService.insert(order);
        List list = new ArrayList();
        if (i>0){
            DateType date = new DateType();
            list.add(order);
            date.setInfo(list);
            date.setCode(1);
            return date;
        }
        return null;
    }


}
