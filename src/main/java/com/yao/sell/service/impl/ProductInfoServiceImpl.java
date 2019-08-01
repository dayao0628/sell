package com.yao.sell.service.impl;

import com.yao.sell.dataobject.ProductInfo;
import com.yao.sell.dto.ResultDto;
import com.yao.sell.enums.PageSizeEnum;
import com.yao.sell.exceptions.PrimaryKeyNotFountException;
import com.yao.sell.repository.ProductInfoRepository;
import com.yao.sell.service.ProductInfoService;
import com.yao.sell.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

/**
 * <p> 商品业务接口实现类
 * <p>
 * Copyright: Copyright (C) 2019 YaoZhengPei, Inc. All rights reserved. <p>
 * Company: 小刘美甲店<p>
 *
 * @author YaoZhengPei
 * @since 2019/8/1 22:48
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public ResultDto<Page<ProductInfo>> findAll(Integer pageNum) throws Exception {
        return ResultUtil.success(productInfoRepository.findAll(PageRequest.of(pageNum, PageSizeEnum.TEN.getSize())));
    }

    @Override
    public ResultDto<Page<ProductInfo>> findByProductStatus(Integer productStatus, Integer pageNum) throws Exception {
        return ResultUtil.success(productInfoRepository.findByProductStatus(productStatus, PageRequest.of(pageNum, PageSizeEnum.TEN.getSize())));
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ResultDto<ProductInfo> save(ProductInfo productInfo, BindingResult br) throws Exception {
        ResultDto result = ResultUtil.validate(br);
        if (result != null) {
            return result;
        }
        if (StringUtils.isEmpty(productInfo.getProductId())) {
            productInfo.setProductId(UUID.randomUUID().toString());
            productInfo.setCreateTime(new Date());
            productInfo.setUpdateTime(new Date());
        } else {
            ResultDto<ProductInfo> productInfoResult = findById(productInfo.getProductId());
            ProductInfo oldProductBean = productInfoResult.getData();
            productInfo.setProductId(oldProductBean.getProductId());
            productInfo.setCreateTime(oldProductBean.getCreateTime());
            productInfo.setUpdateTime(new Date());
        }
        return ResultUtil.success(productInfoRepository.save(productInfo));
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void delete(String productId) throws Exception {
        productInfoRepository.deleteById(productId);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public boolean updateProductStock(String productId, Integer nums) throws Exception {
        return false;
    }

    @Override
    public ResultDto<ProductInfo> findById(String productId) throws Exception {
        Optional<ProductInfo> optional = productInfoRepository.findById(productId);
        if (optional != null && optional.isPresent()) {
            return ResultUtil.success(optional.get());
        }
        throw new PrimaryKeyNotFountException();
    }
}
