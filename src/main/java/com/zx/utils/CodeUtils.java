package com.zx.utils;


import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.sql.SQLException;
import java.util.Collections;

public class CodeUtils {


    public static void main(String[] args) throws SQLException{
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/goods?useSSL=false&useUnicode=true&serverTimezone=GMT&2B8&characterEncoding=utf-8", "root", "123456")
                .globalConfig(builder -> {
                    builder.enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("C:\\Users\\Administrator\\Desktop\\后台\\goods-server\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.zx") // 设置父包名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "C:\\Users\\Administrator\\Desktop\\后台\\goods-server\\src\\main\\resources\\mapper\\xml")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("goodsorder").addExclude(); // 设置需要生成的表名// 设置过滤表前缀
                })
                .execute();
    }
}
