package com.yfbx.protocol.hj212;

import android.text.TextUtils;

import com.yfbx.protocol.hj212.code.HJ212ExeRtn;
import com.yfbx.protocol.hj212.code.HJ212Flag;
import com.yfbx.protocol.hj212.code.HJ212QnRtn;
import com.yfbx.protocol.utils.CrcUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//    /**
//     * 从数据段中解析出数据
//     */
//    public static List<Map<String, String>> getData(String result) {
//        String[] data = result.split(";");
//        List<Map<String, String>> list = new ArrayList<>();
//        for (String ret : data) {
//            Map<String, String> map = new HashMap<>();
//            String[] gene = ret.split(",");
//            for (String s : gene) {
//                String[] value = s.split("=");
//                map.put(value[0], value[1]);
//            }
//            list.add(map);
//        }
//        return list;
//    }


//    public static HJ212CP getCP(String cpString) {
//        HJ212CP cp = new HJ212CP();
//        String[] subs = cpString.split(";");
//        for (String s : subs) {
//            if (s.contains("-")) {
//                getCPData(cp, s);
//            } else if (s.contains("SystemTime")) {
//                cp.SystemTime = s.substring(11, s.length());
//            } else if (s.contains("QnRtn")) {
//                cp.QnRtn = HJ212QnRtn.getEnum(s.substring(6, s.length()));
//            } else if (s.contains("ExeRtn")) {
//                cp.ExeRtn = HJ212ExeRtn.getEnum(s.substring(7, s.length()));
//            } else if (s.contains("RtdInterval")) {
//                cp.RtdInterval = s.substring(12, s.length());
//            } else if (s.contains("MinInterval")) {
//                cp.MinInterval = s.substring(12, s.length());
//            } else if (s.contains("RestartTime")) {
//                cp.RestartTime = s.substring(12, s.length());
//            } else if (s.contains("PolId")) {
//                cp.PolId = s.substring(6, s.length());
//            } else if (s.contains("BeginTime")) {
//                cp.BeginTime = s.substring(10, s.length());
//            } else if (s.contains("EndTime")) {
//                cp.EndTime = s.substring(8, s.length());
//            } else if (s.contains("DataTime")) {
//                cp.DataTime = s.substring(9, s.length());
//            } else if (s.contains("NewPW")) {
//                cp.NewPW = s.substring(6, s.length());
//            } else if (s.contains("OverTime")) {
//                cp.OverTime = s.substring(9, s.length());
//            } else if (s.contains("ReCount")) {
//                cp.ReCount = s.substring(8, s.length());
//            } else if (s.contains("VaseNo")) {
//                cp.VaseNo = s.substring(7, s.length());
//            } else if (s.contains("CstartTime")) {
//                cp.CstartTime = s.substring(11, s.length());
//            } else if (s.contains("Ctime")) {
//                cp.Ctime = s.substring(6, s.length());
//            } else if (s.contains("Stime")) {
//                cp.Stime = s.substring(6, s.length());
//            } else if (s.contains("InfoId")) {
//                cp.InfoId = s.substring(7, s.length());
//            }
//        }
//        return cp;
//    }
//
//    private static void getCPData(HJ212CP data, String datas) {
//        String[] subs = datas.split(",");
//        for (String s : subs) {
//            if (s.contains("SampleTime")) {
//                data.xxx_SampleTime = s.substring(s.indexOf("=") + 1, s.length());
//                if (TextUtils.isEmpty(data.xxx)) {
//                    data.xxx = s.substring(0, s.indexOf("-"));
//                }
//            }
//            if (s.contains("-ID")) {
//                data.xxx_ID = s.substring(s.indexOf("=") + 1, s.length());
//                if (TextUtils.isEmpty(data.xxx)) {
//                    data.xxx = s.substring(0, s.indexOf("-"));
//                }
//            } else if (s.contains("-Rtd")) {
//                data.xxx_Rtd = s.substring(s.indexOf("=") + 1, s.length());
//                if (TextUtils.isEmpty(data.xxx)) {
//                    data.xxx = s.substring(0, s.indexOf("-"));
//                }
//            } else if (s.contains("-fsRtd")) {
//                data.xxx_fsRtd = s.substring(s.indexOf("=") + 1, s.length());
//                if (TextUtils.isEmpty(data.xxx)) {
//                    data.xxx = s.substring(0, s.indexOf("-"));
//                }
//            } else if (s.contains("-Min")) {
//                data.xxx_Min = s.substring(s.indexOf("=") + 1, s.length());
//                if (TextUtils.isEmpty(data.xxx)) {
//                    data.xxx = s.substring(0, s.indexOf("-"));
//                }
//            } else if (s.contains("-Avg")) {
//                data.xxx_Avg = s.substring(s.indexOf("=") + 1, s.length());
//                if (TextUtils.isEmpty(data.xxx)) {
//                    data.xxx = s.substring(0, s.indexOf("-"));
//                }
//            } else if (s.contains("-Max")) {
//                data.xxx_Max = s.substring(s.indexOf("=") + 1, s.length());
//                if (TextUtils.isEmpty(data.xxx)) {
//                    data.xxx = s.substring(0, s.indexOf("-"));
//                }
//            } else if (s.contains("ZsRtd")) {
//                data.xxx_ZsRtd = s.substring(s.indexOf("=") + 1, s.length());
//                if (TextUtils.isEmpty(data.xxx)) {
//                    data.xxx = s.substring(0, s.indexOf("-"));
//                }
//            } else if (s.contains("ZsMin")) {
//                data.xxx_ZsMin = s.substring(s.indexOf("=") + 1, s.length());
//                if (TextUtils.isEmpty(data.xxx)) {
//                    data.xxx = s.substring(0, s.indexOf("-"));
//                }
//            } else if (s.contains("ZsAvg")) {
//                data.xxx_ZsAvg = s.substring(s.indexOf("=") + 1, s.length());
//                if (TextUtils.isEmpty(data.xxx)) {
//                    data.xxx = s.substring(0, s.indexOf("-"));
//                }
//            } else if (s.contains("ZsMax")) {
//                data.xxx_ZsMax = s.substring(s.indexOf("=") + 1, s.length());
//                if (TextUtils.isEmpty(data.xxx)) {
//                    data.xxx = s.substring(0, s.indexOf("-"));
//                }
//            } else if (s.contains("-Flag")) {
//                data.xxx_Flag = HJ212Flag.getEnum(s.substring(s.indexOf("=") + 1, s.length()));
//                if (TextUtils.isEmpty(data.xxx)) {
//                    data.xxx = s.substring(0, s.indexOf("-"));
//                }
//            } else if (s.contains("EFlag")) {
//                data.xxx_EFlag = s.substring(s.indexOf("=") + 1, s.length());
//                if (TextUtils.isEmpty(data.xxx)) {
//                    data.xxx = s.substring(0, s.indexOf("-"));
//                }
//            } else if (s.contains("Cou")) {
//                data.xxx_Cou = s.substring(s.indexOf("=") + 1, s.length());
//                if (TextUtils.isEmpty(data.xxx)) {
//                    data.xxx = s.substring(0, s.indexOf("-"));
//                }
//            } else if (s.contains("Tol")) {
//                data.xxx_Tol = s.substring(s.indexOf("=") + 1, s.length());
//                if (TextUtils.isEmpty(data.xxx)) {
//                    data.xxx = s.substring(0, s.indexOf("-"));
//                }
//            } else if (s.contains("-RS")) {
//                data.SBxxx_RS = s.substring(s.indexOf("=") + 1, s.length());
//                if (TextUtils.isEmpty(data.xxx)) {
//                    data.xxx = s.substring(0, s.indexOf("-"));
//                }
//            } else if (s.contains("-RT")) {
//                data.SBxxx_RT = s.substring(s.indexOf("=") + 1, s.length());
//                if (TextUtils.isEmpty(data.xxx)) {
//                    data.xxx = s.substring(0, s.indexOf("-"));
//                }
//            } else if (s.contains("-Data")) {
//                data.xxx_Data = s.substring(s.indexOf("=") + 1, s.length());
//                if (TextUtils.isEmpty(data.xxx)) {
//                    data.xxx = s.substring(0, s.indexOf("-"));
//                }
//            } else if (s.contains("-DayData")) {
//                data.xxx_DayData = s.substring(s.indexOf("=") + 1, s.length());
//                if (TextUtils.isEmpty(data.xxx)) {
//                    data.xxx = s.substring(0, s.indexOf("-"));
//                }
//            } else if (s.contains("-NightData")) {
//                data.xxx_NightData = s.substring(s.indexOf("=") + 1, s.length());
//                if (TextUtils.isEmpty(data.xxx)) {
//                    data.xxx = s.substring(0, s.indexOf("-"));
//                }
//            } else if (s.contains("Info")) {
//                data.xxx_Info = s.substring(s.indexOf("=") + 1, s.length());
//                if (TextUtils.isEmpty(data.xxx)) {
//                    data.xxx = s.substring(0, s.indexOf("-"));
//                }
//            } else if (s.contains("SN")) {
//                data.xxx_SN = s.substring(s.indexOf("=") + 1, s.length());
//                if (TextUtils.isEmpty(data.xxx)) {
//                    data.xxx = s.substring(0, s.indexOf("-"));
//                }
//            }
//        }
//    }


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
