package com.yao.sell.service.impl;

import com.yao.sell.dataobject.ProductCategory;
import com.yao.sell.dto.ResultDto;
import com.yao.sell.exceptions.PrimaryKeyNotFountException;
import com.yao.sell.repository.ProductCategoryRepository;
import com.yao.sell.service.ProductCategoryService;
import com.yao.sell.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;

import javax.transaction.Transactional;
import java.util.*;

/**
 * <p> 商品类目接口实现类
 * <p>
 * Copyright: Copyright (C) 2019 YaoZhengPei, Inc. All rights reserved. <p>
 * Company: 小刘美甲店<p>
 *
 * @author YaoZhengPei
 * @since 2019/7/28 23:27
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public ResultDto<List<ProductCategory>> findAll() throws Exception {
        return ResultUtil.success(productCategoryRepository.findAll());
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ResultDto<ProductCategory> save(ProductCategory productCategory, BindingResult br) throws Exception {
        ResultDto result = ResultUtil.validate(br);
        if (result != null) {
            return result;
        }

        if (productCategory.getCategoryId() == null) {
            productCategory.setCreateTime(new Date());
            productCategory.setUpdateTime(new Date());
        } else {

            ProductCategory oldBean = findById(productCategory.getCategoryId());
            productCategory.setCategoryId(oldBean.getCategoryId());
            productCategory.setCreateTime(oldBean.getCreateTime());
            productCategory.setUpdateTime(new Date());
        }
        productCategory = productCategoryRepository.save(productCategory);

        return ResultUtil.success(productCategory);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void delete(Integer categoryId) throws Exception {
        ProductCategory productCategory = findById(categoryId);
        productCategoryRepository.delete(productCategory);
    }

    @Override
    public ProductCategory findById(Integer categoryId) throws Exception {
        Optional<ProductCategory> optional = productCategoryRepository.findById(categoryId);
        if (optional != null && optional.isPresent()) {
            return optional.get();
        }
        throw new PrimaryKeyNotFountException();
    }

    @Override
    public ResultDto<List<ProductCategory>> findAllByCategoryTypes(List<Integer> categoryTypeList) throws Exception {
        if (CollectionUtils.isEmpty(categoryTypeList)) {
            ResultUtil.error("商品类目类型不能为空.");
        }
        return ResultUtil.success(productCategoryRepository.findByCategoryTypeIn(categoryTypeList));
    }
}
