package com.zx.entity;

import lombok.Getter;

/**
 * 接口实体类
 */
@Getter
public enum Code {
    SUCCESS(200,"成功"),
    FAILED(400, "失败"),
    ERROR(401, "发生错误");

    private final Integer code;
    private final String msg;

    Code(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
