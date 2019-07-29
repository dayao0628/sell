package com.yao.sell.utils;

import com.yao.sell.dto.ResultDto;
import com.yao.sell.enums.ResultStatusEnum;

/**
 * <p> 返回接口帮助类
 * <p>
 * Copyright: Copyright (C) 2019 YaoZhengPei, Inc. All rights reserved. <p>
 * Company: 小刘美甲店<p>
 *
 * @author YaoZhengPei
 * @since 2019/7/28 23:18
 */
public class ResultUtil {

    /**
     * 返回成功的结果
     *
     * @param object
     * @return 成功的结果
     */
    public static ResultDto success(Object object) {
        ResultDto result = new ResultDto();
        result.setStatus(ResultStatusEnum.SUCCESS.getStatus());
        result.setMessage(ResultStatusEnum.SUCCESS.getMessage());
        result.setData(object);
        return result;
    }

    /**
     * 返回失败的结果
     *
     * @return 失败的结果
     */
    public static ResultDto error(String message) {
        ResultDto result = new ResultDto();
        result.setStatus(ResultStatusEnum.ERROR.getStatus());
        result.setMessage(message);
        return result;
    }
}
