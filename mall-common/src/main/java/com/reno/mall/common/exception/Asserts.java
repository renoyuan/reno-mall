package com.reno.mall.common.exception;

import com.reno.mall.common.api.IErrorCode;

/**
 * Asserts
 *
 * @author renoYuan
 * @email renoyuan@fox.mall
 * @github https://github.com/renoyuan
 * @date 2025/2/25
 */

public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}