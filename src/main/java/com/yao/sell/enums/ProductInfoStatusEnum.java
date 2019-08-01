package com.yao.sell.enums;

import lombok.Getter;

/**
 * <p> 商品状态枚举类
 * <p>
 * Copyright: Copyright (C) 2019 YaoZhengPei, Inc. All rights reserved. <p>
 * Company: 小刘美甲店<p>
 *
 * @author YaoZhengPei
 * @since 2019/8/1 21:21
 */
@Getter
public enum ProductInfoStatusEnum {

    /**
     * 上架
     */
    SELL_ENABLE(0),

    /**
     * 下架
     */
    SELL_DISABLE(1);

    private Integer productStatus;

    ProductInfoStatusEnum(Integer productStatus) {
        this.productStatus = productStatus;
    }
}
