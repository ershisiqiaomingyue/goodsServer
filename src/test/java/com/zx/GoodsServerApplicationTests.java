package com.zx;

import com.zx.entity.User;
import com.zx.mapper.GoodsorderMapper;
import com.zx.mapper.ProductMapper;
import com.zx.service.ICollectService;
import com.zx.service.IProductService;
import com.zx.service.IUserService;
import com.zx.utils.md5Utils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class GoodsServerApplicationTests {

    @Autowired
    private IUserService service;
    @Resource
    private ProductMapper mapper;
    @Autowired
    private IProductService service1;
    @Autowired
    private ICollectService service2;

    @Resource
    private GoodsorderMapper mapper2;
    @Test
    void contextLoads() {
        User user = service.login("admin", "123456");
        System.out.println(user);
    }
    @Test
    void md5(){
        System.out.println(md5Utils.MD5("admin123456"));
    }

    @Test
    void test1(){
        List goods = mapper.allGoods(null, "desc", 1, 10, "小米");
        System.out.println(goods);
    }



    //添加购物车测试
    /*@Test
    void test3(){
        //System.out.println(mapper1.addShoppingCart(1, 1, 1));
        Shoppingcart shoppingcart = new Shoppingcart(1,1,1);
        System.out.println(service2.save(shoppingcart));
    }*/

    //查询喜欢的商品
    @Test
    void test4(){
        System.out.println(service2.get(1));
    }

    //订单查询
    @Test
    void test5(){
        System.out.println(mapper2.queryOrder(1));
    }
}
