package com.zx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author 作者
 * @since 2022-03-12
 */
@ApiModel(value = "Product对象", description = "")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "product_id", type = IdType.AUTO)
    private Integer productId;

    @ApiModelProperty("商品名字")
    private String productName;

    @ApiModelProperty("种类id，1：手机大图，2：手机，3：家电大图，4：家电，5：电器大图，6：电器")
    private Integer categoryId;

    @ApiModelProperty("产品头")
    private String productTitle;

    @ApiModelProperty("产品的详细信息")
    private String productInfo;

    @ApiModelProperty("产品图片")
    private String productPicture;

    @ApiModelProperty("产品原价格")
    private BigDecimal productPrice;

    @ApiModelProperty("产品售卖价格")
    private BigDecimal productSellingPrice;

    @ApiModelProperty("产品剩余数量")
    private Integer productNum;

    @ApiModelProperty("商品售卖的数量")
    private Integer productSales;


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public String getProductPicture() {
        return productPicture;
    }

    public void setProductPicture(String productPicture) {
        this.productPicture = productPicture;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal getProductSellingPrice() {
        return productSellingPrice;
    }

    public void setProductSellingPrice(BigDecimal productSellingPrice) {
        this.productSellingPrice = productSellingPrice;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public Integer getProductSales() {
        return productSales;
    }

    public void setProductSales(Integer productSales) {
        this.productSales = productSales;
    }

    @Override
    public String toString() {
        return "Product{" +
        "productId=" + productId +
        ", productName=" + productName +
        ", categoryId=" + categoryId +
        ", productTitle=" + productTitle +
        ", productInfo=" + productInfo +
        ", productPicture=" + productPicture +
        ", productPrice=" + productPrice +
        ", productSellingPrice=" + productSellingPrice +
        ", productNum=" + productNum +
        ", productSales=" + productSales +
        "}";
    }
}
