package com.jalr.constant;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhanwenliang [routerhex@qq.com]
 * @description 响应状态码枚举
 * @date 2020-10-23 11:44
 */
@Data
@AllArgsConstructor
public class ResponseObject<T> {

    private Integer code;
    private String msg;
    private T data;

    public static <T> ResponseObject<T> success(T data) {
        return new ResponseObject<>(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDescription(), data);
    }

    public static <T> ResponseObject<T> success() {
        return success(null);
    }

    public static <T> ResponseObject<T> fail(T data) {
        return new ResponseObject<>(ResponseEnum.FAIL.getCode(), ResponseEnum.FAIL.getDescription(), data);
    }

}
