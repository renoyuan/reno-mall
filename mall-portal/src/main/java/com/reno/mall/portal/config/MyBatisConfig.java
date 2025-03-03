package com.reno.mall.portal.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatisConfig
 * MyBatis相关配置
 * @author renoYuan
 * @email renoyuan@fox.mall
 * @github https://github.com/renoyuan
 * @date 2025/3/3
 */

@Configuration
@EnableTransactionManagement
@MapperScan({"com.reno.mall.mapper","com.reno.mall.portal.dao"})
public class MyBatisConfig {
}