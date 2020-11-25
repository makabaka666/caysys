package com.qf.service.impl;

import com.qf.dao.CityMapper;
import com.qf.pojo.City;
import com.qf.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


import java.util.List;
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityMapper cityMapper;

    @Override
    public List<City> selectAll() {
        return cityMapper.selectAll();
    }

    @Override
    public List<City> selectById(Integer pid) {
        return cityMapper.selectById(pid);
    }

    @Override
    public  List<City> selectOne(Integer getid,Integer backid) {
        return cityMapper.selectOne(getid,backid);
    }
}
