package com.zx.mapper;

import com.zx.entity.Goodsorder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 作者
 * @since 2022-03-16
 */

public interface GoodsorderMapper extends BaseMapper<Goodsorder> {

    //添加订单
    Boolean add(Integer user_id, Integer product_id,
                Integer product_num, String product_picture,
                String product_name, BigDecimal product_price);

    //获取订单id
    Long[] queryOrderId(Integer user_id);

    //订单查询
    List<Goodsorder> queryOrder(Integer user_id);
}
