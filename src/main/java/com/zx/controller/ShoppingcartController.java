package com.zx.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zx.config.ResponseResult;
import com.zx.entity.Shoppingcart;
import com.zx.mapper.ShoppingcartMapper;
import com.zx.service.IShoppingcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 作者
 * @since 2022-03-14
 */
@RestController
@RequestMapping("/shoppingCart")
public class ShoppingcartController {

    @Resource
    private IShoppingcartService service;

    @Resource
    private ShoppingcartMapper mapper;

    //添加购物车
    @PostMapping("/add")
    ResponseResult addShoppingCart(@RequestBody String data){
        Shoppingcart shoppingcart = JSON.parseObject(data, Shoppingcart.class);
        int code = service.addShoppingCart(data);
        //如果为200或201，返回该数据，否则返回空
        if (code==200 || code ==201){
            Shoppingcart product = mapper.getProduct(shoppingcart.getUserId(), shoppingcart.getProductId());
            ArrayList arr = new ArrayList();
            arr.add(product);
            return new ResponseResult<>(200,"添加购物车成功",arr);
        }
        return new ResponseResult<>(205,"添加购物车失败");
    }

    //获取购物车商品
    @PostMapping("/info")
    ResponseResult shoppingCartList(@RequestBody String data) {
        System.out.println(data);
        return service.shoppingCartInfo(data);

    }
    //更新购物车
    @PostMapping("/update")
    ResponseResult updateShoppingCart(@RequestBody String data){
        System.out.println(data);
        return service.updateShoppingCart(data);
    }

    //删除商品
    @PostMapping("/delete")
    ResponseResult deleteShoppingCart(@RequestBody String data) {
        System.out.println(data);
        return service.deleteShoppingCart(data);
    }

    //更新选择
    @PostMapping("/updateCheck")
    ResponseResult updateCheck(@RequestBody String data) {
        System.out.println(data);
        return service.updateCheck(data);
    }

    //更新全选
    @PostMapping("/updateAllCheck")
    ResponseResult updateAllCheck(@RequestBody String data){
        System.out.println(JSON.parse(data));
        return  service.updateAllCheck(data);
    }
}
