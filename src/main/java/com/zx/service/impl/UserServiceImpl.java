package com.zx.service.impl;

import com.alibaba.fastjson.JSON;
import com.zx.config.ResponseResult;
import com.zx.entity.User;
import com.zx.mapper.UserMapper;
import com.zx.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zx.utils.md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 作者
 * @since 2022-03-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String account, String password) {
        //前端传入的密码，转换为md5
        String md5Pwd = md5Utils.MD5(password);
        //返回比较的结果
        return userMapper.login(account,md5Pwd);
    }

    @Override
    public ResponseResult register(String data) {
        User user = JSON.parseObject(data, User.class);
        user.setNickName("user");
        user.setName("普通用户");
        String password = md5Utils.MD5(user.getPassword());
        user.setAvatar("https://qiniuyun.zxpersonalweb.top/%E5%A4%B4%E5%83%8F.jpg");
        Boolean result = userMapper.register(user.getAccount(), user.getName(),
                user.getNickName(), password, user.getAvatar());
        if (result) return new ResponseResult(200, "注册成功");
        else return new ResponseResult(205, "注册失败");
    }

}
