package com.reno.mall.common.api;


/**
 * IErrorCode
 * API返回码接口
 * @author renoYuan
 * @email renoyuan@fox.mall
 * @github https://github.com/renoyuan
 * @date 2025/2/25
 */

public interface IErrorCode {
    /**
     * 返回码
     */
    long getCode();

    /**
     * 返回信息
     */
    String getMessage();
}