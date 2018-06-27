package com.yfbx.protocol.protocol.hj212.code;

/**
 * Author:Edward
 * Date:2018/6/14
 * Description:系统编码 ST
 */

public enum ST {

    _21("地表水质量监测"),
    _22("空气质量监测"),
    _23("声环境质量监测"),
    _24("地下水质量监测"),
    _25("土壤质量监测"),
    _26("海水质量监测"),
    _27("挥发性有机物监测"),

    _31("大气环境污染源"),
    _32("地表水体环境污染源"),
    _33("地下水体环境污染源"),
    _34("海洋环境污染源"),
    _35("土壤环境污染源"),
    _36("声环境污染源"),
    _37("振动环境污染源"),
    _38("放射性环境污染源"),
    _39("工地扬尘污染源"),

    _41("电磁环境污染源"),

    _51("烟气排放过程监控"),
    _52("污水排放过程监控"),

    _91("系统交互");

    private String code;
    private String name;

    ST(String name) {
        this.code = name().substring(1);
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
