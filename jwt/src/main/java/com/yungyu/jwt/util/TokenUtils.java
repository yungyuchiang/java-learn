package com.yungyu.jwt.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.yungyu.jwt.entity.User;

public class TokenUtils {

    public static String generateToken(User user) {
        String token = "";
        token = JWT.create().withAudience(user.getId())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

}
