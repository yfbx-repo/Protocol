package com.yfbx.hj212;

import com.yfbx.hj212.hj212.HJ212Body;

/**
 * Author:Edward
 * Date:2018/8/16
 * Description:
 */

class Parser {

    private static final String TAG = "HJ212";
    private String pack;

    Parser(String pack) {
        this.pack = pack;
    }

    /**
     * 从返回报文中解析出数据段
     */
    HJ212Body getBody() {
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
                data.setFlag(Integer.parseInt(s.substring(6)));
            }
            if (s.startsWith("PNUM")) {
                data.setPNUM(s.substring(6));
            }
            if (s.startsWith("PNO")) {
                data.setPNO(s.substring(5));
            }
            if (s.startsWith("CP")) {
                data.setCP(s.substring(4));
            }
        }
        return data;
    }


    /**
     * 校验
     */
    private void checkPack() {

    }
}
