package com.reno.mall.security.config;


import com.reno.mall.common.config.BaseRedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * @author renoYuan
 * @email renoyuan@fox.mall
 * @github https://github.com/renoyuan
 * @date 2025/2/27
 */

@EnableCaching
@Configuration
public class RedisConfig extends BaseRedisConfig {

}