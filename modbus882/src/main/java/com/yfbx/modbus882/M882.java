package com.yfbx.modbus882;


import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:Edward
 * Date:2018/6/25
 * Description:
 */

public class M882 {

    private static final String TAG = "ModBus-882";

    /**
     * 功能码
     */
    public static final String SWITCH_READ = "02";//开关量读取
    public static final String REGISTER_READ = "03";//读控制寄存器
    public static final String AD_READ = "04";//读模拟量AD值
    public static final String SWITCH_OUTPUT = "05";//开关量输出
    public static final String REGISTER_WRITE = "06";//写控制寄存器

    /**
     * 组装报文
     *
     * @param code    功能码
     * @param address 地址码(十六进制)
     * @param start   起始位置/输出地址
     * @param count   寄存器数量/输出值
     * @return 报文
     */
    public byte[] pack(String code, String address, int start, int count) {
        String cmd = address + code + Util.toHexString(start) + Util.toHexString(count);
        cmd = cmd + Util.getCrcCode(Util.hexToByte(cmd));
        Log.i(TAG, "发出报文: " + cmd);
        return Util.hexToByte(cmd);
    }

    /**
     * 解析返回的报文
     * 读数据时才解析返回报文，写数据时未考虑
     */
    public List<String> parse(byte[] data) {
        if (data == null) {
            Log.i(TAG, "未接收到返回报文");
            return null;
        }

        String response = Util.byteToHex(data, data.length);
        Log.i(TAG, "返回报文: " + response);

        String crcCode;
        String result;
        String values;
        try {
            //CRC校验码
            crcCode = response.substring(response.length() - 4);
            //数据段
            result = response.substring(0, response.length() - 4);
            //返回值
            values = result.substring(6);
        } catch (Exception e) {
            Log.i(TAG, "非正常报文");
            return null;
        }

        //校验
        if (!Util.getCrcCode(Util.hexToByte(result)).equals(crcCode)) {
            Log.i(TAG, "CRC校验未通过");
            return null;
        }

        //result:
        //开关量：15 02  02 13 14
        //模拟量：15 04  02 aabb ddee
        //寄存器：15 03  02 0016 0015

        //values:
        //开关量：13 14
        //模拟量：aabb ddee
        //寄存器：0016 0015

        String code = result.substring(2, 4);
        int gap = code.equals(SWITCH_READ) ? 2 : 4;
        int len = values.length();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            String value = values.substring(0, gap);
            list.add(String.valueOf(Long.parseLong(value, 16)));
            values = values.substring(gap);
        }
        return list;
    }


}
