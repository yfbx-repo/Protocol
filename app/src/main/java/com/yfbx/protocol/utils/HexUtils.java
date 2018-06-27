package com.yfbx.protocol.utils;

/**
 * @author :Reginer in  2018/3/28 9:19.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class HexUtils {

    private static String hexStr = "0123456789ABCDEF";
    private static String[] binaryArray =
            {"0000", "0001", "0010", "0011",
                    "0100", "0101", "0110", "0111",
                    "1000", "1001", "1010", "1011",
                    "1100", "1101", "1110", "1111"};

    /**
     * 转换为二进制字符串
     */
    public static String bytesToBinaryStr(byte[] bArray) {
        String outStr = "";
        int pos = 0;
        for (byte b : bArray) {
            //高四位
            pos = (b & 0xF0) >> 4;
            outStr += binaryArray[pos];
            //低四位
            pos = b & 0x0F;
            outStr += binaryArray[pos];
        }
        return outStr;
    }

    /**
     * 十六进制字符串转换为二进制字符串
     * eg.0013-->00010011
     */
    public static String hexStrToBinaryStr(String hex) {
        return bytesToBinaryStr(hexToByte(hex));
    }

    /**
     * 十六进制转换为二进制字节数组
     */
    public static byte[] hexToByte(String hexString) {
        //hexString的长度对2取整，作为bytes的长度
        int len = hexString.length() / 2;
        byte[] bytes = new byte[len];
        byte high = 0;//字节高四位
        byte low = 0;//字节低四位
        for (int i = 0; i < len; i++) {
            //右移四位得到高位
            high = (byte) ((hexStr.indexOf(hexString.charAt(2 * i))) << 4);
            low = (byte) hexStr.indexOf(hexString.charAt(2 * i + 1));
            bytes[i] = (byte) (high | low);//高地位做或运算
        }
        return bytes;
    }

    /**
     * 二进制数组转换为十六进制字符串
     */
    public static String byteToHex(byte[] bytes, int len) {

        String result = "";
        String hex = "";
        for (int i = 0; i < len; i++) {
            //字节高4位
            hex = String.valueOf(hexStr.charAt((bytes[i] & 0xF0) >> 4));
            //字节低4位
            hex += String.valueOf(hexStr.charAt(bytes[i] & 0x0F));
            result += hex;  //+" "
        }
        return result;
    }

    /**
     * int 转byte[]
     */
    public static byte[] intToByte(int intValue) {
        return new byte[]{
                (byte) ((intValue >> 24) & 0xFF),
                (byte) ((intValue >> 16) & 0xFF),
                (byte) ((intValue >> 8) & 0xFF),
                (byte) (intValue & 0xFF)
        };
    }
}
