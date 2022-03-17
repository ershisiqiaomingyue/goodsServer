package com.zx.mapper;

import com.zx.entity.Shoppingcart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 作者
 * @since 2022-03-14
 */

public interface ShoppingcartMapper extends BaseMapper<Shoppingcart> {

    //查询购物车是否有该商品
    int count(Integer user_id,Integer product_id);

    //购物车如果有，则更新数据
    Boolean updateInfo(Integer user_id,Integer product_id,Integer total_num);

    //获取购物车数据的
    Shoppingcart getProduct(Integer user_id,Integer product_id);

    //返回购物车数据
    List shoppingCartList(Integer user_id);

    //更新购物车数据
    Boolean updateShoppingCart(Integer user_id,Integer product_id,Integer total_num,Boolean is_checked);

    //删除购物车数据
    Boolean deleteShoppingCart(Integer user_id, Integer product_id);

    //更新选择
    Boolean updateCheck(Integer user_id,Integer product_id,Boolean is_checked);

    //更新全选
    Boolean updateAllCheck(Integer user_id,Boolean is_checked);

}
