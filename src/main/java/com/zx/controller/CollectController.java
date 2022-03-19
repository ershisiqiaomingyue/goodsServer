package com.zx.controller;

import com.alibaba.fastjson.JSON;
import com.zx.config.ResponseResult;
import com.zx.entity.Collect;
import com.zx.mapper.CollectMapper;
import com.zx.service.ICollectService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 作者
 * @since 2022-03-15
 */
@RestController
@RequestMapping("/collect")
public class CollectController {

    @Resource
    private CollectMapper mapper;

    @Resource
    private ICollectService service;

    //添加喜欢的商品
    @PostMapping("/add")
    ResponseResult add(@RequestBody String data){
        System.out.println(data);
        Collect collect = JSON.parseObject(data, Collect.class);
        //先查询是否已经有该商品
        int count = mapper.queryGoods(collect.getUserId(), collect.getProductId());
        if (count > 0){
            return new ResponseResult<>(205,"已经有该商品，添加失败");
        }
        service.save(collect);
        return new ResponseResult<>(200,"添加喜欢的商品成功");
    }

    //获取喜欢的商品
    @PostMapping("/get")
    ResponseResult get(@RequestBody String data){
        System.out.println("userid="+data);
        HashMap map = JSON.parseObject(data, HashMap.class);
        Integer user_id = (Integer)map.get("user_id");
        return service.get(user_id);
    }

    //删除喜欢的商品
    @PostMapping("/delete")
    ResponseResult delete(@RequestBody String data) {
        return service.delete(data);
    }

}
