package com.reno.mall.portal.domain;

import com.reno.mall.model.PmsProductCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * PmsProductCategoryNode
 * 包含子分类的商品分类
 * @author renoYuan
 * @email renoyuan@fox.mall
 * @github https://github.com/renoyuan
 * @date 2025/3/3
 */

@Getter
@Setter
public class PmsProductCategoryNode extends PmsProductCategory {
    @ApiModelProperty("子分类集合")
    private List<PmsProductCategoryNode> children;
}