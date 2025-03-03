package com.reno.mall.portal.service;

import com.reno.mall.model.OmsCartItem;
import com.reno.mall.portal.domain.CartPromotionItem;

import java.util.List;
/**
 * OmsPromotionService
 * 促销管理Service
 * @author renoYuan
 * @email renoyuan@fox.mall
 * @github https://github.com/renoyuan
 * @date 2025/3/3
 */

public interface OmsPromotionService {
    /**
     * 计算购物车中的促销活动信息
     * @param cartItemList 购物车
     */
    List<CartPromotionItem> calcCartPromotion(List<OmsCartItem> cartItemList);
}