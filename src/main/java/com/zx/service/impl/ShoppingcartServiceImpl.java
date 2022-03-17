package com.zx.service.impl;

import com.alibaba.fastjson.JSON;
import com.zx.config.ResponseResult;
import com.zx.entity.Shoppingcart;
import com.zx.mapper.ShoppingcartMapper;
import com.zx.service.IShoppingcartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 作者
 * @since 2022-03-14
 */
@Service
public class ShoppingcartServiceImpl extends ServiceImpl<ShoppingcartMapper, Shoppingcart> implements IShoppingcartService {
    @Resource
    private ShoppingcartMapper mapper;

    //添加购物车
    @Override
    public int addShoppingCart(String data) {
        Shoppingcart info = JSON.parseObject(data, Shoppingcart.class);
        System.out.println(info);
        Integer productId = info.getProductId();
        Integer userId = info.getUserId();
        int count = mapper.count(userId, productId);
        //大于0，执行更新操作
        if (count > 0){
            Boolean result = mapper.updateInfo(info.getUserId(), info.getProductId(), info.getTotalNum());
            if (result) return 201;
            else return  205;
        }
        //等于0，执行插入
        if (count == 0){
            mapper.insert(info);
            return 200;
        }
        //错误
        return 206;
    }

    //获取购物车信息
    @Override
    public ResponseResult shoppingCartInfo(String data) {
        HashMap map = JSON.parseObject(data, HashMap.class);
        Integer user_id = (Integer)map.get("user_id");
        if(user_id==null){
            return new ResponseResult(205, "未登录");
        }
        else{
            return new ResponseResult(mapper.shoppingCartList(user_id));
        }

    }

    //更新购物车
    @Override
    public ResponseResult updateShoppingCart(String data) {
        Shoppingcart info = JSON.parseObject(data, Shoppingcart.class);
        Boolean result = mapper.updateShoppingCart(info.getUserId(), info.getProductId(), info.getTotalNum(), info.getIsChecked());
        if (result) return new ResponseResult(200,"更新成功");
        else return  new ResponseResult(205,"更新失败");
    }

    //删除购物车的商品
    @Override
    public ResponseResult deleteShoppingCart(String data) {
        Shoppingcart info = JSON.parseObject(data, Shoppingcart.class);
        Boolean result = mapper.deleteShoppingCart(info.getUserId(), info.getProductId());
        if(result) return new ResponseResult(200,"删除成功");
        else return  new ResponseResult(205,"删除失败");
    }

    //更新单选
    @Override
    public ResponseResult updateCheck(String data) {
        Shoppingcart info = JSON.parseObject(data, Shoppingcart.class);
        Boolean result = mapper.updateCheck(info.getUserId(), info.getProductId(), info.getIsChecked());
        if(result) return new ResponseResult(200,"更新成功");
        else return  new ResponseResult(205,"更新失败");
    }

    //更新多选
    @Override
    public ResponseResult updateAllCheck(String data) {
        Shoppingcart info = JSON.parseObject(data, Shoppingcart.class);
        System.out.println(info);
        Integer user_id = info.getUserId();
        //只是转换为int类型而已！
        Boolean need = info.getIsChecked();
        if (need) {
            Boolean result = mapper.updateAllCheck(user_id, true);
            if(result) return new ResponseResult<>(200, "修改全选成功");
            else return new ResponseResult(205, "修改全选失败");
        }
        if (!need) {
            Boolean result = mapper.updateAllCheck(user_id, false);
            if(result) return new ResponseResult<>(200, "修改全选成功");
            else return new ResponseResult(205, "修改全选失败");
        }
        return null;
    }
}
