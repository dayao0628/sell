package com.yao.sell.repository;

import com.yao.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

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

}
