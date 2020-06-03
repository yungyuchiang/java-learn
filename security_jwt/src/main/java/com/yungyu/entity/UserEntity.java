package com.yungyu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
@AllArgsConstructor
public class UserEntity {
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> role;
}
