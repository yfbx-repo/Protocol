package com.yfbx.protocol.protocol;

import com.yfbx.modbus882.M882;
import com.yfbx.protocol.protocol.params.Device;
import com.yfbx.protocol.protocol.params.P882;
import com.yfbx.protocol.protocol.params.Params;
import com.yfbx.protocol.serial.SerialManager;

import java.util.List;

/**
 * Author:Edward
 * Date:2018/8/17
 * Description:
 */

public class Mod882 implements Protocol {


    @Override
    public List<String> getData(Params params) {
        Device device = params.getDevice();
        P882 p = params.getP882();

        M882 m882 = new M882();
        byte[] pack = m882.pack(p.code, p.address, p.start, p.count);
        SerialManager serial = SerialManager.getInstance();
        serial.open(device.dev, device.baudRate, device.parity, device.dataBits, device.stopBit);
        serial.write(pack);

        byte[] read = serial.read();
        serial.close();
        return m882.parse(read);
    }
}
