package com.qf.dao;

import com.qf.pojo.City;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CityMapper {
    List<City> selectAll();
    List<City> selectById(@Param("pid") Integer pid);
    List<City> selectOne(@Param("getid") Integer getid,@Param("backid") Integer backid);
}
