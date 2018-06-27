package com.yfbx.protocol;

import com.yfbx.protocol.utils.HexUtils;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        byte[] bytes = HexUtils.hexToByte("13");
        String s = HexUtils.bytes2BinaryStr(bytes);
        System.out.println(s);

    }
}