package com.yfbx.protocol.protocol.hj212.code;

/**
 * Author:Edward
 * Date:2018/6/22
 * Description:
 */

public enum HJ212Flag {

    N("在线监控（监测）仪器仪表工作正常"),
    F("在线监控（监测）仪器仪表停运"),
    M("在线监控（监测）仪器仪表处于维护期间产生的数据"),
    S("手工输入的设定值"),
    D("在线监控（监测）仪器仪表故障"),
    C("在线监控（监测）仪器仪表处于校准状态"),
    T("在线监控（监测）仪器仪表采样数值超过测量上限"),
    B("在线监控（监测）仪器仪表与数采仪通讯异常");

    private String code;
    private String msg;

    HJ212Flag(String msg) {
        this.code = name().substring(1);
        this.msg = msg;
    }


    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static HJ212Flag getEnum(String code) {
        switch (code) {
            case "N":
                return N;
            case "F":
                return F;
            case "M":
                return M;
            case "S":
                return S;
            case "D":
                return D;
            case "C":
                return C;
            case "T":
                return T;
            case "B":
                return B;
        }
        return null;
    }
}
