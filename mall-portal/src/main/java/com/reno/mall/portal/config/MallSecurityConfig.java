package com.reno.mall.portal.config;

import com.reno.mall.portal.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
/**
 * MallSecurityConfig
 * mall-security模块相关配置
 * @author renoYuan
 * @email renoyuan@fox.mall
 * @github https://github.com/renoyuan
 * @date 2025/3/3
 */

@Configuration
public class MallSecurityConfig {

 @Autowired
 private UmsMemberService memberService;

 @Bean
 public UserDetailsService userDetailsService() {
  //获取登录用户信息
  return username -> memberService.loadUserByUsername(username);
 }
}