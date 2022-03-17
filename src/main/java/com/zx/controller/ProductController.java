package com.zx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zx.config.ResponseResult;
import com.zx.entity.Product;
import com.zx.mapper.ProductMapper;
import com.zx.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 作者
 * @since 2022-03-12
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private IProductService productService;

    /**
     * 1:手机、2：电视、3：冰箱、4：扫拖、5：空气净化器、6：空调
     * @return
     */
    //手机列表
    @GetMapping("/phone")
    ResponseResult phoneList() {
        return productService.getList(1);
    }

    //家电的列表
    @GetMapping("/applianceList")
    ResponseResult applianceList() {
        return productService.getList(2);
    }

    //托扫的列表
    @GetMapping("/liveList")
    ResponseResult liveList() {
        return productService.getList(4);
    }


    //获取商品详细信息
    @GetMapping("/details/{productID}")
    ResponseResult getDetails(@PathVariable Integer productID) {
        return productService.getDetails(productID);
    }

    //获取所有的商品
    @PostMapping("/allGoods")
    ResponseResult allGoods(@RequestBody String data){
        System.out.println(data);
        return productService.getAllGoods(data);
    }
}
