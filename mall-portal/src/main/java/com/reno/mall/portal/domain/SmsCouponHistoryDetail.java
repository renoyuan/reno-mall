package com.reno.mall.portal.domain;

import com.reno.mall.model.SmsCoupon;
import com.reno.mall.model.SmsCouponHistory;
import com.reno.mall.model.SmsCouponProductCategoryRelation;
import com.reno.mall.model.SmsCouponProductRelation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
/**
 * SmsCouponHistoryDetail
 * 优惠券领取历史详情（包括优惠券信息和关联关系）
 * @author renoYuan
 * @email renoyuan@fox.mall
 * @github https://github.com/renoyuan
 * @date 2025/3/3
 */

@Getter
@Setter
public class SmsCouponHistoryDetail extends SmsCouponHistory {
    @ApiModelProperty("相关优惠券信息")
    private SmsCoupon coupon;
    @ApiModelProperty("优惠券关联商品")
    private List<SmsCouponProductRelation> productRelationList;
    @ApiModelProperty("优惠券关联商品分类")
    private List<SmsCouponProductCategoryRelation> categoryRelationList;
}