package com.zx.service;

import com.zx.config.ResponseResult;
import com.zx.entity.Collect;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 作者
 * @since 2022-03-15
 */
public interface ICollectService extends IService<Collect> {

    //查询喜欢的商品
    ResponseResult get(Integer user_id);

    //删除喜欢的商品
    ResponseResult delete(String data);
}
