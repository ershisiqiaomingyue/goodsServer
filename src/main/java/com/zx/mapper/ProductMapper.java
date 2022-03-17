package com.zx.mapper;

import com.zx.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 作者
 * @since 2022-03-12
 */

public interface ProductMapper extends BaseMapper<Product> {
    //获取所有商品
    List allGoods(Integer categoryId,String order,Integer currentPage,Integer pageSize,String keyword);

    //获取商品数
    Integer total(String keyword,Integer categoryId);
}
