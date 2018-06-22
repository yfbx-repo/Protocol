package com.yfbx.protocol.hj212.code;

/**
 * Author:Edward
 * Date:2018/6/22
 * Description:
 */

public enum HJ212ExeRtn {

    _1("执行成功"),
    _2("执行失败，但不知道原因"),
    _3("命令请求条件错误"),
    _4("通讯超时"),
    _5("系统繁忙不能执行"),
    _6("系统故障"),
    _100("没有数据");


    private String code;
    private String msg;

    HJ212ExeRtn(String msg) {
        this.code = name().substring(1);
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static HJ212ExeRtn getEnum(String code) {
        switch (code) {
            case "1":
                return _1;
            case "2":
                return _2;
            case "3":
                return _3;
            case "4":
                return _4;
            case "5":
                return _5;
            case "6":
                return _6;
            case "100":
                return _100;
        }
        return null;
    }
}
