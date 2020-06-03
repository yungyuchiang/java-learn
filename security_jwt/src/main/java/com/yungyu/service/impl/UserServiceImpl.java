package com.yungyu.service.impl;

import com.yungyu.data.Database;
import com.yungyu.entity.UserEntity;
import com.yungyu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private Database database;

    @Override
    public UserEntity getUserByUsername(String username) {
        return database.getDatabase().get(username);
    }
}
