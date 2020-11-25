package com.qf.controller;

import com.qf.pojo.City;
import com.qf.pojo.DateType;
import com.qf.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    CityService cityService;

    @RequestMapping(value = "/selectAll",method = RequestMethod.GET)
    public String selectAll(Model model){
        List<City> city = cityService.selectAll();
        model.addAttribute("city","city");
        return "";
    }
    @RequestMapping("/selectById")
    public DateType selectById(Integer pid){
        List<City> city = cityService.selectById(pid);
        DateType date = new DateType();
        date.setCode(1);
        date.setInfo(city);
        return date;
    }
    @RequestMapping("/selectOne")
    public DateType selectOne(Integer getid,Integer backid){
        List<City> city = cityService.selectOne(getid,backid);
        DateType date = new DateType();
        date.setCode(1);
        date.setInfo(city);
        return date;
    }
}
