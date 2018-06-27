package com.yfbx.protocol.protocol.hj212;

import com.yfbx.protocol.utils.CrcUtils;

/**
 * Author:Edward
 * Date:2018/6/22
 * Description:
 */

public class HJ212Pack {

    /**
     * 将数据段封装成通信包
     */
    public static String pack(HJ212Body HJ212Body) {
        String body = HJ212Body.toString();
        return "##" + getLength(body) + body + CrcUtils.getCrc16(body.getBytes()) + "\r\n";
    }

    /**
     * 从通信包中解析出数据段
     */
    public static HJ212Body getBody(String pack) {
        //数据段长度
        int len = Integer.parseInt(pack.substring(3, 7));
        String body = pack.substring(7, len);

        String[] split = body.split(";");
        HJ212Body data = new HJ212Body();
        for (String s : split) {
            if (s.startsWith("QN")) {
                data.setQN(s.substring(4));
            }
            if (s.startsWith("ST")) {
                data.setST(s.substring(4));
            }
            if (s.startsWith("CN")) {
                data.setCN(s.substring(4));
            }
            if (s.startsWith("PW")) {
                data.setPW(s.substring(4));
            }
            if (s.startsWith("MN")) {
                data.setMN(s.substring(4));
            }
            if (s.startsWith("Flag")) {
                data.setFlag(s.substring(6));
            }
            if (s.startsWith("PNUM")) {
                data.setPNUM(s.substring(6));
            }
            if (s.startsWith("PNO")) {
                data.setPNO(s.substring(5));
            }
            if (s.startsWith("HJ212CP")) {
                data.setCP(s.substring(4));
            }
        }
        return data;
    }

    /**
     * 数据段长度
     * 数据段的 ASCII 字符数，例如：长 255，则写为“0255”
     */
    private static String getLength(String body) {
        StringBuilder len = new StringBuilder(String.valueOf(body.length()));
        while (len.length() < 4) {
            len.insert(0, "0");
        }
        return len.toString();
    }
}
