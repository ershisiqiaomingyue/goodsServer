package com.zx.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zx.config.ResponseResult;
import com.zx.entity.User;
import com.zx.mapper.UserMapper;
import com.zx.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 作者
 * @since 2022-03-12
 */

@RestController
public class UserController {

    @Resource
    private IUserService userService;
    @Resource
    private UserMapper mapper;

    @PostMapping("/login")
    ResponseResult login(@RequestBody String data) {
        User info = JSON.parseObject(data, User.class);
        String account = info.getAccount();
        String password = info.getPassword();
        User user = userService.login(account, password);
        if (user != null) return new ResponseResult(200, "成功", user);
        else return new ResponseResult<>(201, "账号密码错误");
    }

    @PostMapping("/user/account/exists")
    ResponseResult checkIsExists(@RequestBody String data) {
        System.out.println(data);
        HashMap map = JSON.parseObject(data, HashMap.class);
        String account = (String) map.get("account");
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("account", account);
        User user = mapper.selectOne(wrapper);
        if (user == null) {
            return new ResponseResult<>(200, "账号不存在");
        } else {
            return new ResponseResult(205, "账号已经存在，请重新输入");
        }
    }

    @PostMapping("/user/account/register")
    ResponseResult register(@RequestBody String data) {
        System.out.println(data);
        return userService.register(data);
    }

}
