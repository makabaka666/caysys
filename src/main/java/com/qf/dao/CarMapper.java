package com.qf.dao;

import com.qf.pojo.Car;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarMapper {
    List<Car> selectAll();
    List<Car> selectAllByNumber();
    List<Car> selectOne(@Param("cid") Integer cid);
}
