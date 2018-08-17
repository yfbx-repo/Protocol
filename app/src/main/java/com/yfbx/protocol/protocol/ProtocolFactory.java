package com.yfbx.protocol.protocol;

/**
 * Author:Edward
 * Date:2018/8/17
 * Description:
 */

public class ProtocolFactory {


    public static final int HJ212 = 0;
    public static final int MODBUS_882 = 1;


    public static Protocol get(int protocol) {
        switch (protocol) {
            case HJ212:
                return new Hj212();
            case MODBUS_882:
                return new Mod882();
            default:
                return new Hj212();
        }
    }
}
