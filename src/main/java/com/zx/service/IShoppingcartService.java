package com.zx.service;

import com.zx.config.ResponseResult;
import com.zx.entity.Shoppingcart;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 作者
 * @since 2022-03-14
 */
public interface IShoppingcartService extends IService<Shoppingcart> {
    //添加购物车
    int addShoppingCart(String data);

    //返回购物车信息
    ResponseResult shoppingCartInfo(String data);

    //更新购物车数据
    ResponseResult updateShoppingCart(String data);

    //删除购物车的商品
    ResponseResult deleteShoppingCart(String data);

    //更新购物车的选择
    ResponseResult updateCheck(String data);

    //更新购物车的全选
    ResponseResult updateAllCheck(String data);
}
