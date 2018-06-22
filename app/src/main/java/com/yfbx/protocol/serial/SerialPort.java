
package com.yfbx.protocol.serial;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Author:Edward
 * Date:2018/6/22
 * Description:
 */
@SuppressWarnings("JniMissingFunction")
public class SerialPort {

    private int fdx = -1;
    private int writeLen;

    public SerialPort() {
        // openport_easy(dev,brd);
    }

    public void openSerial(String dev, int brd) throws SecurityException, IOException {
        fdx = openport_easy(dev, brd);
        if (fdx < 0) {
            throw new IOException();
        }
    }

    public void openSerial(String device, int baudrate, int databit, int stopbit, int crc) throws SecurityException, IOException {
        fdx = openport(device, baudrate, databit, stopbit, crc);
        if (fdx < 0) {
            throw new IOException();
        }
    }

    public int getFd() {
        return fdx;
    }

    public int writeSerialByte(int fd, byte[] str) {
        writeLen = writeport(fd, str);
        return writeLen;
    }

    public int writeSerialString(int fd, String str, int len) {
        writeLen = writestring(fd, str, len);
        return writeLen;
    }

    public byte[] readSerial(int fd, int len)
            throws UnsupportedEncodingException {
        byte[] tmp;
        tmp = readport(fd, len, 50);
        if (tmp == null) {
            return null;
        }
        /*
         * for(byte x : tmp) { Log.w("xxxx", String.format("0x%x", x)); }
		 */
        return tmp;
    }

    public String readSerialString(int fd, int len)
            throws UnsupportedEncodingException {
        byte[] tmp;
        tmp = readport(fd, len, 50);
        if (tmp == null) {
            return null;
        }
        String str;
        if (isUTF8(tmp)) {
            str = new String(tmp, "utf8");
        } else {
            str = new String(tmp, "gbk");
        }
        return str;
    }

    public void closeSerial(int fd) {
        closeport(fd);
    }

    private boolean isUTF8(byte[] sx) {
        for (int i = 0; i < sx.length; ) {
            if (sx[i] < 0) {
                if ((sx[i] >>> 5) == 0x7FFFFFE) {
                    if (((i + 1) < sx.length)
                            && ((sx[i + 1] >>> 6) == 0x3FFFFFE)) {
                        i = i + 2;
                    } else {
                        return false;
                    }
                } else if ((sx[i] >>> 4) == 0xFFFFFFE) {
                    if (((i + 2) < sx.length)
                            && ((sx[i + 1] >>> 6) == 0x3FFFFFE)
                            && ((sx[i + 2] >>> 6) == 0x3FFFFFE)) {
                        i = i + 3;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                i++;
            }
        }
        return true;
    }

    private native int openport_easy(String port, int brd);

    private native int openport(String port, int brd, int bit, int stop, int crc);

    private native void closeport(int fd);

    private native byte[] readport(int fd, int count, int delay);

    private native int writeport(int fd, byte[] buf);

    public native static int writestring(int fd, String wb, int len);

    static {
        System.loadLibrary("serial_port");
    }

}
