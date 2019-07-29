package com.yao.sell.dto;

import lombok.Data;

/**
 * <p> 统一返回接口Dto
 * <p>
 * Copyright: Copyright (C) 2019 YaoZhengPei, Inc. All rights reserved. <p>
 * Company: 小刘美甲店<p>
 *
 * @author YaoZhengPei
 * @since 2019/7/28 22:59
 */
@Data
public class ResultDto<T> {

    private Integer status;

    private String message;

    private T data;

    public ResultDto() {
    }
}
