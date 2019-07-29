package com.yao.sell.handle;

import com.yao.sell.dto.ResultDto;
import com.yao.sell.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p> 异常捕获处理类
 * <p>
 * Copyright: Copyright (C) 2019 YaoZhengPei, Inc. All rights reserved. <p>
 * Company: 小刘美甲店<p>
 *
 * @author YaoZhengPei
 * @since 2019/7/29 20:53
 */
@ControllerAdvice
public class ExceptionHandle {

    /**
     * 异常统一抛出 返回结果信息
     *
     * @param e 异常信息
     * @return 返回结果
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultDto handle(Exception e) {
        return ResultUtil.error(e.getMessage());
    }
}
