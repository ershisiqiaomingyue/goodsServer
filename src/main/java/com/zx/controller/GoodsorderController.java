package com.zx.controller;

import com.alibaba.fastjson.JSONArray;
import com.zx.config.ResponseResult;
import com.zx.service.IGoodsorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 作者
 * @since 2022-03-16
 */
@RestController
public class GoodsorderController {

    @Resource
    private IGoodsorderService service;

    //直接用JSONArray收取数据、添加订单商品
    @PostMapping("/add")
    ResponseResult add(@RequestBody JSONArray data) {
        System.out.println(data);
        return service.add(data);
    }

    //获取订单数据
    @PostMapping("/get")
    ResponseResult get(@RequestBody String data) {
        System.out.println(data);
        return service.get(data);
    }
}
