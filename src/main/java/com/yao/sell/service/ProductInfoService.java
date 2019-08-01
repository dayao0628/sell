package com.yao.sell.service;

import com.yao.sell.dataobject.ProductInfo;
import com.yao.sell.dto.ResultDto;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;

/**
 * <p> 商品业务接口
 * <p>
 * Copyright: Copyright (C) 2019 YaoZhengPei, Inc. All rights reserved. <p>
 * Company: 小刘美甲店<p>
 *
 * @author YaoZhengPei
 * @since 2019/8/1 21:15
 */
public interface ProductInfoService {

    /**
     * 查询所有商品
     *
     * @param pageNum 当前页数
     * @return 商品分页集合
     * @throws Exception exception
     */
    ResultDto<Page<ProductInfo>> findAll(Integer pageNum) throws Exception;

    /**
     * 根据状态查询商品集合
     *
     * @param productStatus 商品状态
     * @param pageNum       当前页数
     * @return 商品分页集合
     * @throws Exception exception
     */
    ResultDto<Page<ProductInfo>> findByProductStatus(Integer productStatus, Integer pageNum) throws Exception;

    /**
     * 添加或修改商品信息
     *
     * @param productInfo 商品信息载体
     * @param br          绑定结果
     * @return 保存结果
     * @throws Exception exception
     */
    ResultDto<ProductInfo> save(ProductInfo productInfo, BindingResult br) throws Exception;

    /**
     * 删除信息
     *
     * @param productId 商品ID
     * @throws Exception exception
     */
    void delete(String productId) throws Exception;

    /**
     * 更新库存数量
     *
     * @param productId 商品ID
     * @param nums      库存增加或减少
     * @return TRUE 更新成功 false 更新失败
     * @throws Exception exception
     */
    boolean updateProductStock(String productId, Integer nums) throws Exception;

    /**
     * 根据主键查找商品信息
     *
     * @param productId 商品ID
     * @return 唯一的商品信息
     * @throws Exception exception
     */
    ResultDto<ProductInfo> findById(String productId) throws Exception;
}
