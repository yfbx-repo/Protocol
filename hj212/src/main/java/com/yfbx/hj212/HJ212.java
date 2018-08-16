package com.yfbx.hj212;


import android.util.Log;

import com.yfbx.hj212.hj212.HJ212Body;
import com.yfbx.hj212.hj212.HJ212CP;

/**
 * Author:Edward
 * Date:2018/6/14
 * Description:
 */

public class HJ212 {

    private static final String TAG = "HJ212";


    public byte[] pack(String ST, String CN, String PW, String MN, int Flag, HJ212CP cp) {
        Packer packer = new Packer(ST, CN, PW, MN, Flag);
        packer.setCP(cp);
        String pack = packer.pack();
        Log.i(TAG, "发送报文:" + pack);
        return pack.getBytes();
    }


    public HJ212CP parse(byte[] data) {
        String pack = new String(data);
        Log.i(TAG, "返回报文：" + pack);
        Parser parser = new Parser(pack);
        HJ212Body body = parser.getBody();
        return HJ212CP.parse(body.getCP());
    }
}
