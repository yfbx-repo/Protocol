package com.yfbx.protocol.protocol.hj212;

import com.yfbx.protocol.bean.DeviceInstallInfo;
import com.yfbx.protocol.protocol.SerialManager;

/**
 * Author:Edward
 * Date:2018/6/14
 * Description:
 */

public class HJ212 {

    public static HJ212CP execute(DeviceInstallInfo device, HJ212Body body) {
        SerialManager serial = new SerialManager(device);
        try {
            //发送命令
            serial.sendCommand(body.toString().getBytes());
            //在线仪返回
            String receive = serial.readString();
            HJ212Body result = HJ212Pack.getBody(receive);
            serial.close();
            return HJ212CP.parse(result.getCP());
        } catch (Exception e) {
            e.printStackTrace();
            serial.close();
        }
        return null;
    }
}
