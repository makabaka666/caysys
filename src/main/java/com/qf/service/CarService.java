package com.qf.service;

import com.qf.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarService {
    List<Car> selectAll();
    List<Car> selectAllByNumber();
    List<Car> selectOne(Integer cid);
}
