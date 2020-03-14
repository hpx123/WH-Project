package com.wh.dao;

import com.wh.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int checkUsername(String username);

    User selectLogin(String username, String password);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int uploadPhoto(String url);
}