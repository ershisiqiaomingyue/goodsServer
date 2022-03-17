package com.zx.service;

import com.zx.config.ResponseResult;
import com.zx.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 作者
 * @since 2022-03-12
 */
public interface IProductService extends IService<Product> {

    //获取手机的1张大图
    Product getBigImg();

    //主页获取商品列表
    ResponseResult getList(Integer id);

    //获取商品详细信息
    ResponseResult getDetails(Integer productID);

    //获取所有商品
    ResponseResult getAllGoods(String data);
}
