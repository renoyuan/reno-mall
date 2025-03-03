package com.reno.mall.security.annotation;


import java.lang.annotation.*;

/**
 * CacheException
 * 自定义缓存异常注解，有该注解的缓存方法会抛出异常
 * @author renoYuan
 * @email renoyuan@fox.mall
 * @github https://github.com/renoyuan
 * @date 2025/2/27
 */

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheException {
}