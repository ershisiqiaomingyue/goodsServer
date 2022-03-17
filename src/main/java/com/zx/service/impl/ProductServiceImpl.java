package com.zx.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zx.config.ResponseResult;
import com.zx.entity.GoodsListResult;
import com.zx.entity.Product;
import com.zx.mapper.ProductMapper;
import com.zx.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 作者
 * @since 2022-03-12
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {


    @Resource
    private ProductMapper productMapper;

    @Override
    public Product getBigImg() {
        QueryWrapper<Product> wrapper = new QueryWrapper();
        wrapper.eq("category_id", 1);
        Product img = productMapper.selectOne(wrapper);
        return img;
    }

    @Override
    public ResponseResult getList(Integer id) {
        QueryWrapper<Product> wrapper = new QueryWrapper();
        wrapper.eq("category_id", id);
        List<Product> list = productMapper.selectList(wrapper);
        return new ResponseResult(200, "成功", list);
    }

    @Override
    public ResponseResult getDetails(Integer productID) {
        QueryWrapper<Product> wrapper = new QueryWrapper();
        wrapper.eq("product_id", productID);
        Product result = productMapper.selectOne(wrapper);
        return new ResponseResult(200, "成功", result);
    }

    @Override
    public ResponseResult getAllGoods(String data){
        HashMap map = JSON.parseObject(data, HashMap.class);
        /*
        1、判断是否有关键字
        2、判断是否需要分页
        3、判断是否需要排序
         */

        int categoryId = 0;
        //获取关键字
        String keyword = (String)map.get("keyword");
        //获取当前页码
        Integer currentPage = (Integer) map.get("currentPage");
        //获取一页需要多少数据
        Integer pageSize = (Integer)map.get("pageSize");
        //获取需要查询的商品名字
        String product_name = (String) map.get("productName");
        System.out.println("当前页码为："+currentPage);
        System.out.println("每页数据为："+pageSize);
        if(map.get("categoryID") != null){
            String id =  map.get("categoryID").toString();
            categoryId = Integer.parseInt(id);
        }
        String order = (String)map.get("order");

        int pageNow =  currentPage;
        int size =  pageSize;
        System.out.println(pageNow+"/"+size);
        //这里我们做一个初始化页面定义，防止空指针错误
        pageNow = pageNow <= 0 ? 1 : pageNow;
        size = size <= 0 ? 10 : size;

        int start = ( pageNow - 1) * size;
        Integer total = productMapper.total(keyword,categoryId);

        GoodsListResult goodsListResult = new GoodsListResult();
        goodsListResult.setTotal(total);
        if (order == null || order == ""){
            List list = productMapper.allGoods(categoryId, "ASC", start, size, keyword);
            goodsListResult.setGoodsList(list);
            return new ResponseResult(goodsListResult);
        }
        List result = productMapper.allGoods(categoryId, order, start, size, keyword);
        goodsListResult.setGoodsList(result);
        return new ResponseResult(goodsListResult);
    }


}
