package com.zx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zx.entity.Collect;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CollectMapper extends BaseMapper<Collect> {

    //查询是否已经有该商品
    int queryGoods(Integer user_id,Integer product_id);
}
