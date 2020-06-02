package com.yungyu.jwt.service;

import com.yungyu.jwt.entity.User;

public interface IUserService {
    User findUserById(String userId);

    User findUserByName(User user);
}
