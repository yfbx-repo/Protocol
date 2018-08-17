package com.yfbx.hj212;


import com.yfbx.hj212.hj212.HJ212Body;

/**
 * Author:Edward
 * Date:2018/6/22
 * Description:
 */

class Packer {

    private HJ212Body body;

    Packer(String ST, String CN, String PW, String MN, int Flag, String CP) {
        body = new HJ212Body(ST, CN, PW, MN, Flag, CP);
    }

    String pack() {
        String bodyStr = body.toString();
        return "##" + getLength(bodyStr) + bodyStr + Utils.getCrc16(bodyStr.getBytes()) + "\r\n";
    }


    /**
     * 数据段长度
     * 数据段的 ASCII 字符数，例如：长 255，则写为“0255”
     */
    private String getLength(String body) {
        StringBuilder len = new StringBuilder(String.valueOf(body.length()));
        while (len.length() < 4) {
            len.insert(0, "0");
        }
        return len.toString();
    }
}
