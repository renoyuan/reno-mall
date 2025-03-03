package com.reno.mall.security.component;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;


/**
 * DynamicSecurityService
 * 动态权限相关业务接口
 * @author renoYuan
 * @email renoyuan@fox.mall
 * @github https://github.com/renoyuan
 * @date 2025/2/27
 */
public interface DynamicSecurityService {
    /**
     * 加载资源ANT通配符和资源对应MAP
     */
    Map<String, ConfigAttribute> loadDataSource();
}