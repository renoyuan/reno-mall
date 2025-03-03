package com.reno.mall.portal.service;

import com.reno.mall.common.api.CommonPage;
import com.reno.mall.model.PmsBrand;
import com.reno.mall.model.PmsProduct;

import java.util.List;
/**
 * PmsPortalBrandService
 * 前台品牌管理Service
 * @author renoYuan
 * @email renoyuan@fox.mall
 * @github https://github.com/renoyuan
 * @date 2025/3/3
 */

public interface PmsPortalBrandService {
    /**
     * 分页获取推荐品牌
     */
    List<PmsBrand> recommendList(Integer pageNum, Integer pageSize);

    /**
     * 获取品牌详情
     */
    PmsBrand detail(Long brandId);

    /**
     * 分页获取品牌关联商品
     */
    CommonPage<PmsProduct> productList(Long brandId, Integer pageNum, Integer pageSize);
}