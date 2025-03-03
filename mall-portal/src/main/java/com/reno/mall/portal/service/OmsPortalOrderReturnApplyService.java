package com.reno.mall.portal.service;

import com.reno.mall.portal.domain.OmsOrderReturnApplyParam;
/**
 * OmsPortalOrderReturnApplyService
 * 前台订单退货管理Service
 * @author renoYuan
 * @email renoyuan@fox.mall
 * @github https://github.com/renoyuan
 * @date 2025/3/3
 */

public interface OmsPortalOrderReturnApplyService {
    /**
     * 提交申请
     */
    int create(OmsOrderReturnApplyParam returnApply);
}