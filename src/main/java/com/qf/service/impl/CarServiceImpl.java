package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.qf.dao.CarMapper;
import com.qf.pojo.Car;
import com.qf.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarMapper carMapper;
    @Override
    public List<Car> selectAll() {
        return carMapper.selectAll();
    }

    @Override
    public List<Car> selectAllByNumber() {
        return carMapper.selectAllByNumber();
    }

    @Override
    public List<Car> selectOne(Integer cid) {
        return carMapper.selectOne(cid);
    }

    @Override
    public List<Car> selectAllCar(Integer page,Integer limit) {
        PageHelper.startPage(page,limit);
        return carMapper.selectAllCar();
    }

    @Override
    public Car selectOneById(Integer id) {
        return carMapper.selectOneById(id);
    }

    @Override
    public Integer insertCar(Car car) {
        return carMapper.insertCar(car);
    }

    @Override
    public Integer updateById(Car car) {
        return carMapper.updateById(car);
    }

    @Override
    public Integer deleteById(Integer id) {
        return carMapper.deleteById(id);
    }
}
