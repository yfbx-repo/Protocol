package com.yfbx.protocol.utils;

import java.math.BigInteger;

/**
 * Author:Edward
 * Date:2018/6/22
 * Description:
 */

public class CrcUtils {


    /**
     * CRC校验
     */
    public static String getCrc16(byte[] data) {
        int i, j, crcReg, check;
        crcReg = 0xFFFF;
        for (i = 0; i < data.length; i++) {
            crcReg = (crcReg >>> 8) ^ i8Tou8(data[i]);
            for (j = 0; j < 8; j++) {
                check = crcReg & 0x0001;
                crcReg >>>= 1;
                if (check == 0x0001) {
                    crcReg ^= 0xA001;
                }
            }
        }
        return new BigInteger(1, HexUtils.intToByteArray(crcReg)).toString(16).toUpperCase();
    }

    private static int i8Tou8(byte in) {
        return (in < 0 ? ((int) in + 0x100) : in);
    }
}
