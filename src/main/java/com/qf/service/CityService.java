package com.qf.service;

import com.qf.pojo.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CityService {
    List<City> selectAll();
    List<City> selectById(Integer pid);
    List<City> selectOne(Integer getid,Integer backid);
}
