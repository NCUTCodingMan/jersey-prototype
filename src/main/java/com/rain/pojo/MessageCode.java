package com.rain.pojo;

/**
 * 描述请求返回的状态
 * @author rain
 * created on 2018/4/22
 */
public class MessageCode {
    public String code;
    public String message;

    public MessageCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}