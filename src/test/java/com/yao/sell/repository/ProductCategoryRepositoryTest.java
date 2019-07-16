package com.yao.sell.repository;

import com.yao.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

/**
 * <p>测试商品类目测试类
 * <p>
 * Copyright: Copyright (C) 2019 YaoZhengPei, Inc. All rights reserved. <p>
 * Company: 小刘美甲店<p>
 *
 * @author YaoZhengPei
 * @since 2019/7/14 16:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findAllTest() {
        List<ProductCategory> all = repository.findAll();
        System.out.println(all.size());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryType(99);
        productCategory.setCategoryName("test lombok");
        ProductCategory save = repository.save(productCategory);
        Assert.assertNotNull(save);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void deleteAllTest() {
        repository.deleteAll();
    }


}
