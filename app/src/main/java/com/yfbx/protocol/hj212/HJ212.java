package com.yfbx.protocol.hj212;

import com.yfbx.protocol.bean.DeviceInstallInfo;
import com.yfbx.protocol.serial.SerialManager;

/**
 * Author:Edward
 * Date:2018/6/14
 * Description:
 */

public class HJ212 {

    private DeviceInstallInfo device;
    private String command;

    private HJ212(DeviceInstallInfo device) {
        this.device = device;
    }

    public static HJ212 device(DeviceInstallInfo device) {
        return new HJ212(device);
    }

    public HJ212 body(String ST, String CN, String PW, String CP) {
        HJ212Body body = new HJ212Body(ST, CN, PW, device.getMnNum(), CP);
        command = HJ212Pack.pack(body);
        return this;
    }


    public HJ212CP request() {
        try {
            return execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private HJ212CP execute() throws Exception {
        SerialManager serialPort = new SerialManager();
        serialPort.open(device.getComNum(), device.getBaudRate());
        //发送命令
        serialPort.write(command);

        //在线仪返回
        String ret = serialPort.read(1024);
        HJ212Body body = HJ212Pack.getBody(ret);
        return HJ212CP.parse(body.getCP());
    }
}
