package com.reno.mall.portal.service;

import com.reno.mall.portal.domain.AliPayParam;

import java.util.Map;
/**
 * AlipayService
 * 支付宝支付Service
 * @author renoYuan
 * @email renoyuan@fox.mall
 * @github https://github.com/renoyuan
 * @date 2025/3/3
 */

public interface AlipayService {
    /**
     * 根据提交参数生成电脑支付页面
     */
    String pay(AliPayParam aliPayParam);

    /**
     * 支付宝异步回调处理
     */
    String notify(Map<String, String> params);

    /**
     * 查询支付宝交易状态
     * @param outTradeNo 商户订单编号
     * @param tradeNo 支付宝交易编号
     * @return 支付宝交易状态
     */
    String query(String outTradeNo, String tradeNo);

    /**
     * 根据提交参数生成手机支付页面
     */
    String webPay(AliPayParam aliPayParam);
}
