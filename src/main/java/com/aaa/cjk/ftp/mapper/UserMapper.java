package com.aaa.cjk.ftp.mapper;

import com.aaa.cjk.ftp.model.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User getUserByUsernameAndPassword(User user);
}