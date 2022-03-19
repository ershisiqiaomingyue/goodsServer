package com.zx.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zx.config.ResponseResult;
import com.zx.entity.Collect;
import com.zx.mapper.CollectMapper;
import com.zx.service.ICollectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 作者
 * @since 2022-03-15
 */
@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements ICollectService {

    @Resource
    private CollectMapper mapper;
    @Override
    public ResponseResult get(Integer user_id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id",user_id);
        List<Collect> list = mapper.selectList(wrapper);
        return new ResponseResult(list);
    }

    @Override
    public ResponseResult delete(String data) {
        Collect collect = JSON.parseObject(data, Collect.class);
        Boolean result = mapper.deleteGoods(collect.getUserId(), collect.getProductId());
        if (result) return new ResponseResult<>(200, "删除成功");
        else return new ResponseResult(205, "删除失败");
    }
}
