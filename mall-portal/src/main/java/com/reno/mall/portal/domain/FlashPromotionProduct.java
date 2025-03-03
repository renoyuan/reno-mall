package com.reno.mall.portal.domain;

import com.reno.mall.model.PmsProduct;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * FlashPromotionProduct
 * 秒杀信息和商品对象封装
 * @author renoYuan
 * @email renoyuan@fox.mall
 * @github https://github.com/renoyuan
 * @date 2025/3/3
 */

@Getter
@Setter
public class FlashPromotionProduct extends PmsProduct{
    @ApiModelProperty("秒杀价格")
    private BigDecimal flashPromotionPrice;
    @ApiModelProperty("用于秒杀到数量")
    private Integer flashPromotionCount;
    @ApiModelProperty("秒杀限购数量")
    private Integer flashPromotionLimit;
}