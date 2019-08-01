package com.yao.sell.repository;

import com.yao.sell.dataobject.ProductInfo;
import com.yao.sell.enums.ProductInfoStatusEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * <p> 商品Repository层测试类
 * <p>
 * Copyright: Copyright (C) 2019 YaoZhengPei, Inc. All rights reserved. <p>
 * Company: 小刘美甲店<p>
 *
 * @author YaoZhengPei
 * @since 2019/7/28 22:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void findAllTest() {
        List<ProductInfo> all = repository.findAll();
        System.out.println(all);
    }

    @Test
    public void findByProductStatusTest() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<ProductInfo> pages = repository.findByProductStatus(ProductInfoStatusEnum.SELL_ENABLE.getProductStatus(), pageRequest);
        List<ProductInfo> content = pages.getContent();
        System.out.println(content);
    }


}