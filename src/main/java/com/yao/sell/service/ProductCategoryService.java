package com.yao.sell.service;

import com.yao.sell.dataobject.ProductCategory;
import com.yao.sell.dto.ResultDto;
import org.springframework.validation.BindingResult;

import java.util.List;

/**
 * <p> 商品类目业务接口
 * <p>
 * Copyright: Copyright (C) 2019 YaoZhengPei, Inc. All rights reserved. <p>
 * Company: 小刘美甲店<p>
 *
 * @author YaoZhengPei
 * @since 2019/7/28 23:02
 */
public interface ProductCategoryService {

    /**
     * 查询全部商品类目数据
     *
     * @return 返回全部商品类目
     * @throws Exception Exception
     */
    ResultDto<List<ProductCategory>> findAll() throws Exception;

    /**
     * 新增或更新商品类目信息
     *
     * @param productCategory 商品类目参数
     * @param br              验证结果
     * @return 返回新增或更新结果
     * @throws Exception Exception
     */
    ResultDto<ProductCategory> save(ProductCategory productCategory, BindingResult br) throws Exception;

    /**
     * 根据商品类目主键删除记录
     *
     * @param categoryId 商品类目主键
     * @throws Exception Exception
     */
    void delete(Integer categoryId) throws Exception;

    /**
     * 根据商品类目类型查询结果
     *
     * @param categoryTypeList 商品类目类型
     * @return 商品类目数据
     * @throws Exception Exception
     */
    ResultDto<List<ProductCategory>> findAllByCategoryTypes(List<Integer> categoryTypeList) throws Exception;

    /**
     * 根据主键查找
     *
     * @param categoryId 主键ID
     * @return 对应的结果
     * @throws Exception
     */
    ProductCategory findById(Integer categoryId) throws Exception;
}
