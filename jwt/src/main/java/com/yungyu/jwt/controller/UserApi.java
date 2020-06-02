package com.yungyu.jwt.controller;

import com.alibaba.fastjson.JSONObject;
import com.yungyu.jwt.entity.User;
import com.yungyu.jwt.service.IUserService;
import com.yungyu.jwt.token.PassToken;
import com.yungyu.jwt.token.UserLoginToken;
import com.yungyu.jwt.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class UserApi {

    @Autowired
    private IUserService userService;

    @PassToken
    @PostMapping("/login")
    public Object login(@RequestBody User user) {
        JSONObject jsonObject = new JSONObject();
        User userForBase = userService.findUserByName(user);
        if (null == userForBase) {
            jsonObject.put("message", "登录失败，用户不存在");
            return jsonObject;
        }
        if (!user.getPassword().equals(userForBase.getPassword())) {
            jsonObject.put("message", "登录失败，密码错误");
            return jsonObject;
        }
        String token = TokenUtils.generateToken(userForBase);
        jsonObject.put("token", token);
        jsonObject.put("user", userForBase);
        return jsonObject;
    }

    @UserLoginToken
    @GetMapping("/get/message")
    public String getMessage () {
        return "you的通过验证的，さびふあ";
    }

}
