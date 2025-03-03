package com.reno.mall.portal.domain;

import com.reno.mall.model.PmsProduct;
import com.reno.mall.model.PmsProductFullReduction;
import com.reno.mall.model.PmsProductLadder;
import com.reno.mall.model.PmsSkuStock;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
/**
 * PromotionProduct
 * 促销商品信息，包括sku、打折优惠、满减优惠
 * @author renoYuan
 * @email renoyuan@fox.mall
 * @github https://github.com/renoyuan
 * @date 2025/3/3
 */

@Getter
@Setter
public class PromotionProduct extends PmsProduct {
    //商品库存信息
    private List<PmsSkuStock> skuStockList;
    //商品打折信息
    private List<PmsProductLadder> productLadderList;
    //商品满减信息
    private List<PmsProductFullReduction> productFullReductionList;
}