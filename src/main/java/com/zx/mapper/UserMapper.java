package com.zx.mapper;

import com.zx.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 作者
 * @since 2022-03-12
 */

public interface UserMapper extends BaseMapper<User> {
    //登录的接口
    User login(String account,String password);

    //注册
    Boolean register(String account, String name,
                     String nick_name, String password, String avatar);
}
