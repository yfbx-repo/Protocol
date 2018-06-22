package com.yfbx.protocol.serial;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Author:Edward
 * Date:2018/6/22
 * Description:
 */

public class SerialManager {

    private SerialPort serialPort;
    private boolean isOpne;

    public SerialManager() {
        serialPort = new SerialPort();
    }

    public void open(String dev, int brd) {
        try {
            serialPort.openSerial(dev, brd);
            isOpne = true;
        } catch (IOException e) {
            e.printStackTrace();
            isOpne = false;
        }
    }


    public int write(String data) {
        return serialPort.writeSerialString(serialPort.getFd(), data, data.length());
    }

    public String read(int len) {
        try {
            return serialPort.readSerialString(serialPort.getFd(), len);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void close() {
        if (serialPort != null) {
            serialPort.closeSerial(serialPort.getFd());
        }
    }
}
