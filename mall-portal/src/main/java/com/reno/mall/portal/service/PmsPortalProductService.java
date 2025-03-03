package com.reno.mall.portal.service;

import com.reno.mall.model.PmsProduct;
import com.reno.mall.portal.domain.PmsPortalProductDetail;
import com.reno.mall.portal.domain.PmsProductCategoryNode;

import java.util.List;

/**
 * PmsPortalProductService
 * 前台商品管理Service
 * @author renoYuan
 * @email renoyuan@fox.mall
 * @github https://github.com/renoyuan
 * @date 2025/3/3
 */

public interface PmsPortalProductService {
    /**
     * 综合搜索商品
     */
    List<PmsProduct> search(String keyword, Long brandId, Long productCategoryId, Integer pageNum, Integer pageSize, Integer sort);

    /**
     * 以树形结构获取所有商品分类
     */
    List<PmsProductCategoryNode> categoryTreeList();

    /**
     * 获取前台商品详情
     */
    PmsPortalProductDetail detail(Long id);
}