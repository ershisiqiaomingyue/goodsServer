package com.zx.config;

import com.zx.entity.Code;
import lombok.Getter;

@Getter
public class ResponseResult<T>{
    Integer code;
    String msg;
    T data;

    public ResponseResult(T data) {
         this(Code.SUCCESS,data);
    }

    public ResponseResult(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(Integer code,String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseResult(Code rc, T data) {
        this.code = rc.getCode();
        this.msg = rc.getMsg();
        this.data = data;
    }
}
