package com.yfbx.protocol.serial;

import com.deemons.serialportlib.SerialPort;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * Author: Edward
 * Date: 2018/7/11
 * Description:
 */


public class SerialManager {

    private static final String TAG = "Serial";
    private InputStream inputStream;
    private OutputStream outputStream;
    private boolean isOpen;

    private volatile static SerialManager instance;


    private SerialManager() {
    }

    public static SerialManager getInstance() {
        if (instance == null) {
            synchronized (SerialManager.class) {
                if (instance == null) {
                    instance = new SerialManager();
                }
            }
        }
        return instance;
    }

    public void open(String device, int baudRate) {
        try {
            SerialPort serialPort = new SerialPort(new File(device), baudRate, 0, 8, 1, 0);
            inputStream = serialPort.getInputStream();
            outputStream = serialPort.getOutputStream();
            isOpen = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void open(String device, int baudRate, int parity, int dataBits, int stopBit) {
        try {
            SerialPort serialPort = new SerialPort(new File(device), baudRate, parity, dataBits, stopBit, 0);
            inputStream = serialPort.getInputStream();
            outputStream = serialPort.getOutputStream();
            isOpen = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public byte[] read() {
        byte[] buffer = new byte[512];
        try {
            int available = inputStream.available();
            if (available == 0) {
                return null;
            }
            int len = inputStream.read(buffer);
            return Arrays.copyOf(buffer, len);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void write(byte[] data) {
        try {
            outputStream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            outputStream.close();
            inputStream.close();
            isOpen = false;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isOpen() {
        return isOpen;
    }
}
