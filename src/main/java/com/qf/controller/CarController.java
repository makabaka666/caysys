package com.qf.controller;

import com.qf.pojo.Car;
import com.qf.pojo.DateType;
import com.qf.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    CarService carService;

    @RequestMapping("/selectAll")
    public DateType selectAll(){
        List<Car> car = carService.selectAll();
        DateType date = new DateType();
        date.setCode(1);
        date.setInfo(car);
        return date;
    }
    @RequestMapping("/selectAllByNumber")
    public DateType selectAllByNumber(){
        List<Car> car = carService.selectAllByNumber();
        DateType date = new DateType();
        date.setCode(1);
        date.setInfo(car);
        return date;
    }

    @RequestMapping("/selectOne")
    public DateType selectOne(Integer cid){
        List<Car> car = carService.selectOne(cid);
        DateType date = new DateType();
        date.setCode(1);
        date.setInfo(car);
        return date;
    }


}
