package com.yfbx.protocol.protocol;

import com.yfbx.protocol.bean.DeviceInstallInfo;
import com.yfbx.protocol.protocol.hj212.HJ212;
import com.yfbx.protocol.protocol.hj212.HJ212Body;
import com.yfbx.protocol.protocol.hj212.HJ212CP;
import com.yfbx.protocol.protocol.modbus882.Modbus882;

/**
 * Author:Edward
 * Date:2018/6/25
 * Description:
 */

public class Protocol {

    public static HJ212CP hj212(DeviceInstallInfo device, String ST, String CN, String PW, String CP) {
        HJ212Body body = new HJ212Body(ST, CN, PW, device.getMnNum(), CP);
        return HJ212.execute(device, body);
    }


    public static int[] read882(DeviceInstallInfo device, String command, int start, int value) {
        return Modbus882.sendCommand(device, command, start, value);
    }
}
