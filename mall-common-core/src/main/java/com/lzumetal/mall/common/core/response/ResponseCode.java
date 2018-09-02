package com.lzumetal.mall.common.core.response;

/**
 * 异常code
 */
public interface ResponseCode {

    String getCode();

    String getMsg();

    void setCode(String code);

    void setMsg(String msg);
}
