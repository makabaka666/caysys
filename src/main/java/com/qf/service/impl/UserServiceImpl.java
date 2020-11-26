package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.qf.dao.UserMapper;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User selectByTelAndPassword(String tel,String password) {
        return userMapper.selectByTelAndPassword(tel,password);
    }

    @Override
    public Integer insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public Integer update(User user) {
        return userMapper.update(user);
    }

    @Override
    public List selectAll(Integer page,Integer limit) {
        PageHelper.startPage(page,limit);
        return userMapper.selectAll();
    }

    @Override
    public User selectOneById(Integer id) {
        return userMapper.selectOneById(id);
    }

    @Override
    public Integer deleteById(Integer id) {
        return userMapper.deleteById(id);
    }
}
