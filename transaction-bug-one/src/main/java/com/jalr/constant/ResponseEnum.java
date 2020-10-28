package com.jalr.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: zhanwenliang [routerhex@qq.com]
 * @description: 响应状态码枚举
 * @date: 2020-10-23 11:48
 */
@Getter
@AllArgsConstructor
public enum ResponseEnum {

    SUCCESS(0, "Execute successfully!"),
    FAIL(-1, "Execute failed!");

    private final Integer code;
    private final String description;

}
