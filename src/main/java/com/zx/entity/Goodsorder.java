package com.zx.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author 作者
 * @since 2022-03-16
 */
@ApiModel(value = "Goodsorder对象", description = "")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Goodsorder implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单号")
    private Long orderId;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("产品id")
    private Integer productId;

    @ApiModelProperty("购买商品数量")
    private Integer productNum;

    @ApiModelProperty("商品图片")
    private String productPicture;

    @ApiModelProperty("商品名字")
    private String productName;

    @ApiModelProperty("商品价格")
    private BigDecimal productPrice;

    @ApiModelProperty("订单时间")
    private LocalDateTime orderTime;


}
