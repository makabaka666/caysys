package com.qf.controller;

import com.github.pagehelper.PageInfo;
import com.qf.pojo.Car;
import com.qf.pojo.DateType;
import com.qf.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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




    @RequestMapping("/selectAllCar")
    public DateType selectAllCar(Integer page,Integer limit){
        List<Car> car = carService.selectAllCar(page,limit);
        PageInfo pageInfo = new PageInfo(car);
        DateType date = new DateType();
        date.setCount(pageInfo.getTotal());
        date.setCode(0);
        date.setData(car);
        return date;
    }
    @RequestMapping(value = "/selectOneById",method = RequestMethod.POST)
    public DateType selectOneById(@RequestBody Map map){
        Car car = carService.selectOneById(Integer.valueOf(map.get("id").toString()));
        DateType date = new DateType();
        date.setCode(0);
        date.setData(car);
        return date;
    }
    @RequestMapping(value = "/updateById",method = RequestMethod.POST)
    public Integer updateById(@RequestBody Car car){
        if (car.getId()==null){
            return carService.insertCar(car);
        }else{
            return carService.updateById(car);
        }
    }
    @RequestMapping(value = "/deleteById",method = RequestMethod.POST)
    public Integer deleteById(@RequestBody Map map){
        return  carService.deleteById(Integer.valueOf(map.get("id").toString()));
    }


}
