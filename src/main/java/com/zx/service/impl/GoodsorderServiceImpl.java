package com.zx.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zx.config.ResponseResult;
import com.zx.entity.Goodsorder;
import com.zx.mapper.GoodsorderMapper;
import com.zx.mapper.ShoppingcartMapper;
import com.zx.service.IGoodsorderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 作者
 * @since 2022-03-16
 */
@Service
public class GoodsorderServiceImpl extends ServiceImpl<GoodsorderMapper, Goodsorder> implements IGoodsorderService {

    @Resource
    private GoodsorderMapper mapper;
    @Resource
    private ShoppingcartMapper shoppingcartMapper;

    @Override
    public ResponseResult add(JSONArray data) {
        System.out.println("data"+data);
        ArrayList<Goodsorder> list = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            //获取JSON数据
            JSONObject object = data.getJSONObject(i);
            Goodsorder order = new Goodsorder();
            order.setUserId(object.getObject("userId",int.class));
            order.setProductId(object.getObject("productId",int.class));
            order.setProductNum(object.getObject("totalNum",int.class));
            order.setProductPicture(object.getObject("productPicture",String.class));
            order.setProductName(object.getObject("productName",String.class));
            order.setProductPrice(object.getObject("productPrice", BigDecimal.class));
            System.out.println(order);
            list.add(order);
        }
        for (Goodsorder order : list) {
            mapper.add(order.getUserId(), order.getProductId(),
                    order.getProductNum(), order.getProductPicture(),
                    order.getProductName(), order.getProductPrice());
            //同时删除购物车的数据
            shoppingcartMapper.deleteShoppingCart(order.getUserId(),order.getProductId());
        }
        return new ResponseResult<>(200,"提交成功");
    }

    @Override
    public ResponseResult get(String data) {
        ArrayList result = new ArrayList();

        //将data转换为int类型
        HashMap map = JSON.parseObject(data, HashMap.class);
        Integer user_id = (Integer)map.get("user_id");
        //获取订单信息
        List<Goodsorder> order = mapper.queryOrder(user_id);
        //获取订单id
        Long[] idArr = mapper.queryOrderId(user_id);
        for (int i = 0;i < idArr.length;i++) {
            ArrayList arrayList = new ArrayList();
            Long id = idArr[i];
            for (int j = 0; j < order.size(); j++) {
                Goodsorder goodsorder = order.get(j);
                if (Objects.equals(id, goodsorder.getOrderId())){
                    arrayList.add(goodsorder);
                }
            }
            result.add(arrayList);
        }
        return  new ResponseResult(200,"查询订单成功",result);
    }
}
