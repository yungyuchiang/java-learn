package com.yungyu.service;

import com.yungyu.entity.UserEntity;

public interface IUserService {

    UserEntity getUserByUsername (String username);

}
