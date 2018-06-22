package com.yfbx.protocol.utils;

/**
 * @author :Reginer in  2018/3/28 9:19.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class HexUtils {
    /**
     * String转byte[]
     *
     * @param src 待转换字符
     * @return 转换后byte[]
     */
    public static byte[] hexString2Bytes(String src) {
        byte[] ret = new byte[src.length() / 2];
        byte[] tmp = src.getBytes();
        for (int i = 0; i < src.length() / 2; i++) {
            ret[i] = uniteBytes(tmp[i * 2], tmp[i * 2 + 1]);
        }
        return ret;
    }

    /**
     * 将两个ASCII字符合成一个字节； 如："EF"--> 0xEF
     *
     * @param src0 byte
     * @param src1 byte
     * @return byte
     */
    private static byte uniteBytes(byte src0, byte src1) {
        try {
            byte b0 = Byte.decode("0x" + new String(new byte[]{src0}));
            b0 = (byte) (b0 << 4);
            byte b1 = Byte.decode("0x" + new String(new byte[]{src1}));
            return (byte) (b0 ^ b1);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * byte数组转换成String
     *
     * @param src 数组
     * @return string
     */
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (byte aSrc : src) {
            int v = aSrc >= 0 ? aSrc : aSrc + 256;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv).append("");
        }
        return stringBuilder.toString().toUpperCase();
    }

    /**
     * int 转byte[]
     *
     * @param intValue int
     * @return byte[]
     */
    public static byte[] intToByteArray(int intValue) {
        return new byte[]{
                (byte) ((intValue >> 24) & 0xFF),
                (byte) ((intValue >> 16) & 0xFF),
                (byte) ((intValue >> 8) & 0xFF),
                (byte) (intValue & 0xFF)
        };
    }


    public static String stringToHex(String str) {
        char[] chars = str.toCharArray();
        StringBuffer hex = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            hex.append(Integer.toHexString((int) chars[i]));
        }
        return hex.toString();
    }
}
