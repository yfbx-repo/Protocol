package com.yfbx.protocol.protocol.hj212.code;

/**
 * Author:Edward
 * Date:2018/6/22
 * Description:
 */

public enum HJ212QnRtn {

    _1("准备执行请求"),
    _2("请求被拒绝"),
    _3("PW 错误"),
    _4("MN 错误"),
    _5("ST 错误"),
    _6("Flag 错误"),
    _7("QN 错误"),
    _8("CN 错误"),
    _9("CRC 校验错误"),
    _100("未知错误");


    private String code;
    private String msg;

    HJ212QnRtn(String msg) {
        this.code = name().substring(1);
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static HJ212QnRtn getEnum(String code) {
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
            case "7":
                return _7;
            case "8":
                return _8;
            case "9":
                return _9;
            case "100":
                return _100;
        }
        return null;
    }
}
