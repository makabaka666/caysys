package com.qf.dao;

import com.qf.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
   User selectByTelAndPassword(@Param("tel") String tel,@Param("password") String password);
   Integer insertUser(User user);
   Integer update(User user);
}
