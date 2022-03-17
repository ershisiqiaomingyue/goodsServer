package com.zx.service;

import com.zx.config.ResponseResult;
import com.zx.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 作者
 * @since 2022-03-12
 */
public interface IUserService extends IService<User> {
    //判断密码是否正确
    User login(String account, String password);

    //注册
    ResponseResult register(String data);
}
