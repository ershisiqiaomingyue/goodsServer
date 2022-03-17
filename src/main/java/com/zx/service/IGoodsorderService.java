package com.zx.service;

import com.alibaba.fastjson.JSONArray;
import com.zx.config.ResponseResult;
import com.zx.entity.Goodsorder;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 作者
 * @since 2022-03-16
 */
public interface IGoodsorderService extends IService<Goodsorder> {

    //购买、添加订单
    ResponseResult add(JSONArray data);

    //获取订单
    ResponseResult get(String data);
}
