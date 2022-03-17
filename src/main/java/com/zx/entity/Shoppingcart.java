package com.zx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
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
 * @since 2022-03-14
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "Shoppingcart对象", description = "")
public class Shoppingcart implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("产品id")
    private Integer productId;

    @ApiModelProperty("产品数量")
    private Integer totalNum;

    @ApiModelProperty("商品图片")
    private String productPicture;

    @ApiModelProperty("商品名字")
    private String productName;

    @ApiModelProperty("商品价格")
    private BigDecimal productPrice;

    @ApiModelProperty("是否选择")
    private Boolean isChecked;

}
