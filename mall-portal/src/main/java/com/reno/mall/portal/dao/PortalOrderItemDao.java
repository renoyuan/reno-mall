package com.reno.mall.portal.dao;

import com.reno.mall.model.OmsOrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * PortalOrderItemDao
 * 订单商品信息管理自定义Dao
 * @author renoYuan
 * @email renoyuan@fox.mall
 * @github https://github.com/renoyuan
 * @date 2025/3/3
 */

public interface PortalOrderItemDao {
    /**
     * 批量插入
     */
    int insertList(@Param("list") List<OmsOrderItem> list);
}