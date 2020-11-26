package com.qf.service;

import com.qf.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserService {
    User selectByTelAndPassword(String tel,String password);
    Integer insertUser(User user);
    Integer update(User user);
    List selectAll(Integer page,Integer limit);

    User selectOneById(@Param("id")Integer id);
    Integer deleteById(@Param("id")Integer id);
}
