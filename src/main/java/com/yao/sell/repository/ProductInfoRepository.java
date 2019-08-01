package com.yao.sell.repository;

import com.yao.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * <p>
 * <p> 商品主表数据库接口
 * Copyright: Copyright (C) 2019 YaoZhengPei, Inc. All rights reserved. <p>
 * Company: 小刘美甲店<p>
 *
 * @author YaoZhengPei
 * @since 2019/7/28 18:16
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    /**
     * 根据状态查询商品
     *
     * @param productStatus 商品状态
     * @param pageable      分页
     * @return
     */
    Page<ProductInfo> findByProductStatus(Integer productStatus, Pageable pageable);
}
