package com.yao.sell.enums;

import lombok.Getter;

/**
 * <p> 每页显示条数
 * <p>
 * Copyright: Copyright (C) 2019 YaoZhengPei, Inc. All rights reserved. <p>
 * Company: 小刘美甲店<p>
 *
 * @author YaoZhengPei
 * @since 2019/8/1 22:28
 */
@Getter
public enum PageSizeEnum {

    /**
     * 显示10条
     */
    TEN(10);

    private Integer size;

    PageSizeEnum(Integer size) {
        this.size = size;
    }
}
