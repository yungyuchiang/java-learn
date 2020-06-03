package com.yungyu.service.impl;

import com.yungyu.entity.UserEntity;
import com.yungyu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetialsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userService.getUserByUsername(username);
        if (null == userEntity) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), userEntity.getRole());
    }

}
