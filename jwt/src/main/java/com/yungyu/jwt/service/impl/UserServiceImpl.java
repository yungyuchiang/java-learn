package com.yungyu.jwt.service.impl;

import com.yungyu.jwt.entity.User;
import com.yungyu.jwt.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {


    @Override
    public User findUserById(String userId) {
        if (userId.startsWith("121")) {
            User user = new User();
            user.setId("121");
            user.setUserName("Yungyu");
            user.setPassword("jwt@123");
            return user;
        }
        return null;
    }

    @Override
    public User findUserByName(User user) {
        if (null != user && null != user.getUserName() && user.getUserName().equalsIgnoreCase("Yungyu")) {
            User reUser = new User();
            reUser.setId("121");
            reUser.setUserName("Yungyu");
            reUser.setPassword("jwt@123");
            return reUser;
        }
        return null;
    }
}
