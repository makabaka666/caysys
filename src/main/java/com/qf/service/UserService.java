package com.qf.service;

import com.qf.pojo.User;
import org.apache.ibatis.annotations.Param;


public interface UserService {
    User selectByTelAndPassword(String tel,String password);
    Integer insertUser(User user);
    Integer update(User user);
}
