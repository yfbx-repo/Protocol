package com.yfbx.protocol.protocol;

import android.serialport.SerialPort;

import com.yfbx.protocol.bean.DeviceInstallInfo;
import com.yfbx.protocol.utils.HexUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Author:Edward
 * Date:2018/6/25
 * Description:
 */

public class SerialManager {

    private SerialPort serialPort;

    public SerialManager(DeviceInstallInfo device) {
        initSerialPort(device);
    }

    /**
     * 初始化串口
     */
    private void initSerialPort(DeviceInstallInfo device) {
        try {
            serialPort = new SerialPort(new File(device.getComNum()), device.getBaudRate(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 发送命令
     */
    public void sendCommand(byte[] command) {
        try {
            OutputStream outputStream = serialPort.getOutputStream();
            outputStream.write(command);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 接收返回数据(ASCII)
     */
    public String readString() {
        try {
            InputStream inputStream = serialPort.getInputStream();
            byte[] buffer = new byte[1024];
            int len = inputStream.read(buffer);
            inputStream.close();
            return new String(buffer, 0, len);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 接收返回数据(十六进制)
     */
    public String readHex() {
        try {
            InputStream inputStream = serialPort.getInputStream();
            byte[] buffer = new byte[1024];
            int len = inputStream.read(buffer);
            inputStream.close();
            return HexUtils.byteToHex(buffer, len);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 关闭串口
     */
    public void close() {
        if (serialPort != null) {
            serialPort.close();
            serialPort = null;
        }
    }
}
