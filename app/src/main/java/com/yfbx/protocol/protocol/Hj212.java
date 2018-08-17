package com.yfbx.protocol.protocol;

import com.yfbx.hj212.HJ212;
import com.yfbx.hj212.hj212.HJ212CP;
import com.yfbx.protocol.protocol.params.Device;
import com.yfbx.protocol.protocol.params.P212;
import com.yfbx.protocol.protocol.params.Params;
import com.yfbx.protocol.serial.SerialManager;

/**
 * Author:Edward
 * Date:2018/8/17
 * Description:
 */

public class Hj212 implements Protocol {


    @Override
    public HJ212CP getData(Params params) {
        Device device = params.getDevice();
        P212 p = params.getP212();

        HJ212 hj212 = new HJ212();
        byte[] pack = hj212.pack(p.ST, p.CN, p.PW, p.MN, p.Flag, p.CP);
        SerialManager serial = SerialManager.getInstance();
        serial.open(device.dev, device.baudRate);
        serial.write(pack);

        byte[] read = serial.read();
        serial.close();
        return hj212.parse(read);
    }
}
