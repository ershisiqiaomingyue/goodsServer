package com.zx.service.impl;

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
}
