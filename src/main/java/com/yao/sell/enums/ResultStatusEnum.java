package com.yao.sell.enums;

/**
 * <p> 返回接口状态类型枚举类
 * <p>
 * Copyright: Copyright (C) 2019 YaoZhengPei, Inc. All rights reserved. <p>
 * Company: 小刘美甲店<p>
 *
 * @author YaoZhengPei
 * @since 2019/7/28 23:12
 */
public enum ResultStatusEnum {

    /**
     * 结果成功
     */
    SUCCESS(2000, "success"),

    /**
     * 结果失败
     */
    ERROR(2001, "error");

    private Integer status;

    private String message;

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ResultStatusEnum(Integer status, String message) {
        this.status = status;
        this.message = message;
    }}
