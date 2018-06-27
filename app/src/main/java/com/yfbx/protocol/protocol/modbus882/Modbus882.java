package com.yfbx.protocol.protocol.modbus882;

import com.yfbx.protocol.bean.DeviceInstallInfo;
import com.yfbx.protocol.protocol.SerialManager;
import com.yfbx.protocol.utils.HexUtils;

/**
 * Author:Edward
 * Date:2018/6/25
 * Description:
 */

public class Modbus882 {

    private SerialManager serial;

    public Modbus882(DeviceInstallInfo device) {
        this.serial = new SerialManager(device);
    }

    /**
     * 发送命令并读取返回
     */
    public static int[] sendCommand(DeviceInstallInfo device, String commandCode, int start, int value) {
        SerialManager serial = new SerialManager(device);
        String command = commandCode + toHexString(start) + toHexString(value);
        serial.sendCommand(HexUtils.hexToByte(command));

        String response = serial.readHex();

        String count = String.valueOf(value);//无论value是十进制还是十六进制，都会转换为十进制
        int[] ret = new int[Integer.valueOf(count)];

        switch (commandCode) {
            case Command.SWITCH_READ:
                String bin = HexUtils.hexStrToBinaryStr(response.substring(4));//二进制字符串00010011
                StringBuilder builder = new StringBuilder(bin);
                builder.reverse();//倒序
                for (int i = 0; i < builder.length(); i++) {
                    ret[i] = builder.charAt(i);
                }
                break;
            case Command.SWITCH_OUTPUT:
                break;
            case Command.REGISTER_READ:
                response = response.substring(2);
                for (int i = 0; i < ret.length; i++) {
                    response = response.substring(2);
                    ret[i] = Integer.parseInt(response.substring(0, 4), 16);
                }
                break;
            case Command.REGISTER_WRITE:
                break;
            case Command.AD_READ:
                for (int i = 0; i < ret.length; i++) {
                    response = response.substring(4);
                    ret[i] = Integer.parseInt(response.substring(0, 4), 16);
                }
                break;
        }
        return ret;
    }


    /**
     * 开关量读取
     *
     * @param start 起始地址,2字节，0x0000-0xFFFF
     * @param value 开关量控制路数,2字节，1-2000(0x0001-0x07D0)
     */
    public int[] readSwitch(int start, int value) {
        //发送报文: 02 0001 0008
        String command = Command.SWITCH_READ + toHexString(start) + toHexString(value);
        serial.sendCommand(HexUtils.hexToByte(command));

        //回送报文: 02  01  13
        //0x13   0001 0011（这样表示的第一路，第二路和第五路开关量输入为高）
        String response = serial.readHex();

        String bin = HexUtils.hexStrToBinaryStr(response.substring(4));//二进制字符串00010011
        StringBuilder builder = new StringBuilder(bin);
        builder.reverse();//倒序
        int[] result = new int[builder.length()];
        for (int i = 0; i < builder.length(); i++) {
            result[i] = builder.charAt(i);
        }
        //返回结果{1,1,0,0,1,0,0,0} 第一路，第二路和第五路开关量输入为高
        return result;
    }

    /**
     * 开关量输出
     *
     * @param start 输出地址(0x0000-0xFFFF)
     * @param value 输出值
     */
    public void writeSwitch(int start, int value) {
        String command = Command.SWITCH_OUTPUT + toHexString(start) + toHexString(value);
        serial.sendCommand(HexUtils.hexToByte(command));
    }


    /**
     * 模拟量读取
     *
     * @param start 起始地址(0x0000-0xFFFF)
     * @param value 寄存器数量1-125(0x0001-0x007D)
     */
    public int[] readAD(int start, int value) {
        //发送报文：04 0001 0002
        String command = Command.AD_READ + toHexString(start) + toHexString(value);
        serial.sendCommand(HexUtils.hexToByte(command));

        //回送报文：04 04  AABB  DDEE  (AD1=0xAABB  AD2=0xDDEE)
        String response = serial.readHex();
        String count = String.valueOf(value);//无论value是十进制还是十六进制，都会转换为十进制
        int[] ret = new int[Integer.valueOf(count)];
        for (int i = 0; i < ret.length; i++) {
            response = response.substring(4);
            ret[i] = hexToInt(response.substring(0, 4));
        }
        return ret;
    }


    /**
     * 读控制寄存器
     *
     * @param start 起始地址(0x0000-0xFFFF)
     * @param value 寄存器数量1-125(0x0001-0x007D)
     */
    public int[] readRegister(int start, int value) {
        //发送报文: 03 0001 0001
        String command = Command.REGISTER_READ + toHexString(start) + toHexString(value);
        serial.sendCommand(HexUtils.hexToByte(command));

        //回送报文:03 01 0016 (0x01为地址，0x0016为寄存器的值)
        String response = serial.readHex();
        response = response.substring(2);
        String count = String.valueOf(value);//无论value是十进制还是十六进制，都会转换为十进制
        int[] ret = new int[Integer.valueOf(count)];
        for (int i = 0; i < ret.length; i++) {
            response = response.substring(2);
            ret[i] = hexToInt(response.substring(0, 4));
        }
        return ret;
    }

    /**
     * 写控制寄存器
     *
     * @param start 起始地址(0x0000-0xFFFF)
     * @param value 寄存器值(0x0001-0xFFFF)
     */
    public void writeRegister(int start, int value) {
        String command = Command.REGISTER_WRITE + toHexString(start) + toHexString(value);
        serial.sendCommand(HexUtils.hexToByte(command));
    }


    /**
     * 转换为十六进制字符串(补足4位)
     * <p>
     * eg. x=8,return 0008;
     * eg. x=0x0008,return 0008
     *
     * @param x 十进制 或 十六进制 数字
     */
    private static String toHexString(int x) {
        StringBuilder builder = new StringBuilder(Integer.toHexString(x));
        while (builder.length() < 4) {
            builder.insert(0, "0");
        }
        return builder.toString();
    }

    /**
     * 十六进制转换为十进制
     */
    private int hexToInt(String hex) {
        return Integer.parseInt(hex, 16);
    }
}
