package com.yao.sell.repository;

import com.yao.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <p>
 * <p> 商品类目数据库接口
 * Copyright: Copyright (C) 2019 YaoZhengPei, Inc. All rights reserved. <p>
 * Company: 小刘美甲店<p>
 *
 * @author YaoZhengPei
 * @since 2019/7/14 16:09
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    /**
     * 根据类目类型查找符合的结果
     *
     * @param categoryTypeList 类目类型
     * @return 符合的结果
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
