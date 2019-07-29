package com.yao.sell.service.impl;

import com.yao.sell.dataobject.ProductCategory;
import com.yao.sell.dto.ResultDto;
import com.yao.sell.enums.ResultStatusEnum;
import com.yao.sell.service.ProductCategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryService service;

    @Test
    public void findAll() throws Exception {
        ResultDto<List<ProductCategory>> result = service.findAll();
        Assert.assertEquals(ResultStatusEnum.SUCCESS.getStatus(), result.getStatus());
    }

    @Test
    @Transactional
    @Rollback(false)
    public void save() throws Exception {
        ProductCategory bean = new ProductCategory();
        bean.setCategoryId(7);
        bean.setCategoryType(2);
        bean.setCategoryName("炖汤系列");
        bean.setUpdateTime(new Date());
        ResultDto<ProductCategory> result = service.save(bean, null);
        Assert.assertEquals(ResultStatusEnum.SUCCESS.getStatus(), result.getStatus());
    }

    @Test
    public void delete() throws Exception {
        service.delete(1);
    }

    @Test
    public void validate() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void findAllByCategoryTypes() throws Exception {
        List<Integer> categoryTypeList = new ArrayList<>();
        categoryTypeList.add(1);
        categoryTypeList.add(2);
        ResultDto<List<ProductCategory>> result = service.findAllByCategoryTypes(categoryTypeList);
        Assert.assertEquals(ResultStatusEnum.SUCCESS.getStatus(), result.getStatus());
    }
}