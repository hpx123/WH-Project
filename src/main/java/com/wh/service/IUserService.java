package com.wh.service;

import com.wh.common.ServerResponse;
import com.wh.pojo.User;

public interface IUserService {
    ServerResponse<User> login(String username, String password);
    ServerResponse<String> register(User user);
}
