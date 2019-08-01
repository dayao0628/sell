package com.yao.sell.service.impl;

import com.yao.sell.dataobject.ProductInfo;
import com.yao.sell.dto.ResultDto;
import com.yao.sell.enums.ProductInfoStatusEnum;
import com.yao.sell.enums.ResultStatusEnum;
import com.yao.sell.service.ProductInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoService service;

    @Test
    public void findAll() throws Exception {
        ResultDto<Page<ProductInfo>> all = service.findAll(0);
        List<ProductInfo> content = all.getData().getContent();
        for (ProductInfo productInfo : content) {
            System.out.println(productInfo);
        }
        Assert.assertNotNull(content);
    }

    @Test
    public void findByProductStatus() throws Exception {
        ResultDto<Page<ProductInfo>> byProductStatus = service.findByProductStatus(ProductInfoStatusEnum.SELL_ENABLE.getProductStatus(), 0);
        List<ProductInfo> content = byProductStatus.getData().getContent();
        for (ProductInfo productInfo : content) {
            System.out.println(productInfo);
        }
        Assert.assertNotNull(content);
    }

    @Test
    @Transactional(rollbackOn = Exception.class)
    @Rollback(false)
    public void save() throws Exception {
        ProductInfo product = new ProductInfo();
        product.setProductId("63eb8a0a-58ce-47e1-bc04-f7faa532201c");
        product.setProductStock(2001);
        product.setProductStatus(ProductInfoStatusEnum.SELL_ENABLE.getProductStatus());
        product.setProductIcon("http://127.0.0.1/img/bbb.jpg");
        product.setProductPrice(new BigDecimal(14.8));
        product.setProductName("test11");
        product.setCategoryType(1);
        product.setProductDescription("test22");
        ResultDto<ProductInfo> save = service.save(product, null);
        Assert.assertNotNull(save.getData().getProductId());
    }

    @Test
    public void delete() throws Exception {
        service.delete("63eb8a0a-58ce-47e1-bc04-f7faa532201c");
    }

    @Test
    public void updateProductStock() throws Exception {
    }

    @Test
    public void findById() throws Exception {
        String productId = "63eb8a0a-58ce-47e1-bc04-f7faa532201c";
        ResultDto<ProductInfo> byId = service.findById(productId);
        Assert.assertEquals(byId.getStatus(), ResultStatusEnum.SUCCESS.getStatus());
    }
}