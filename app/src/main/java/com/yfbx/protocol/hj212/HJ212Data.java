package com.yfbx.protocol.hj212;

import android.text.TextUtils;

import com.yfbx.protocol.hj212.code.HJ212Flag;

/**
 * Author:Edward
 * Date:2018/6/22
 * Description:
 */

public class HJ212Data {

    public String xxx_SampleTime;//污染物采样时间
    public String xxx_ID;//siteId,区分重复因子，多个监测仪共用一个数采仪
    public String xxx_Rtd;//实时采样数据
    public String xxx_fsRtd;//辐射实时采样数据
    public String xxx_Min;//污染物指定时间内最小值
    public String xxx_Avg;//污染物指定时间内平均值
    public String xxx_Max;//污染物指定时间内最大值
    public String xxx_ZsRtd;//污染物实时采样折算数据
    public String xxx_ZsMin;//污染物指定时间内最小折算值
    public String xxx_ZsAvg;//污染物指定时间内平均折算值
    public String xxx_ZsMax;//污染物指定时间内最大折算值
    public HJ212Flag xxx_Flag;//监测仪器数据标记
    public String xxx_EFlag;//监测仪器扩充数据标记
    public String xxx_Cou;//排放量
    public String xxx_Tol;//累计值
    public String SBxxx_RS;//污染治理设施运行状态的实时采样值
    public String SBxxx_RT;//污染治理设施一日内的运行时间
    public String xxx_Data;//噪声监测时间段内数据
    public String xxx_DayData;//噪声昼间数据
    public String xxx_NightData;//噪声夜间数据
    public String xxx_Info;//现场端信息
    public String xxx_SN;//在线监控（监测）仪器仪表编码
    public String xxx;


    public static HJ212Data parse(String datas) {
        HJ212Data data = new HJ212Data();
        String[] subs = datas.split(",");
        for (String s : subs) {
            if (s.contains("SampleTime")) {
                data.xxx_SampleTime = s.substring(s.indexOf("=") + 1, s.length());
                if (TextUtils.isEmpty(data.xxx)) {
                    data.xxx = s.substring(0, s.indexOf("-"));
                }
            }
            if (s.contains("-ID")) {
                data.xxx_ID = s.substring(s.indexOf("=") + 1, s.length());
                if (TextUtils.isEmpty(data.xxx)) {
                    data.xxx = s.substring(0, s.indexOf("-"));
                }
            } else if (s.contains("-Rtd")) {
                data.xxx_Rtd = s.substring(s.indexOf("=") + 1, s.length());
                if (TextUtils.isEmpty(data.xxx)) {
                    data.xxx = s.substring(0, s.indexOf("-"));
                }
            } else if (s.contains("-fsRtd")) {
                data.xxx_fsRtd = s.substring(s.indexOf("=") + 1, s.length());
                if (TextUtils.isEmpty(data.xxx)) {
                    data.xxx = s.substring(0, s.indexOf("-"));
                }
            } else if (s.contains("-Min")) {
                data.xxx_Min = s.substring(s.indexOf("=") + 1, s.length());
                if (TextUtils.isEmpty(data.xxx)) {
                    data.xxx = s.substring(0, s.indexOf("-"));
                }
            } else if (s.contains("-Avg")) {
                data.xxx_Avg = s.substring(s.indexOf("=") + 1, s.length());
                if (TextUtils.isEmpty(data.xxx)) {
                    data.xxx = s.substring(0, s.indexOf("-"));
                }
            } else if (s.contains("-Max")) {
                data.xxx_Max = s.substring(s.indexOf("=") + 1, s.length());
                if (TextUtils.isEmpty(data.xxx)) {
                    data.xxx = s.substring(0, s.indexOf("-"));
                }
            } else if (s.contains("ZsRtd")) {
                data.xxx_ZsRtd = s.substring(s.indexOf("=") + 1, s.length());
                if (TextUtils.isEmpty(data.xxx)) {
                    data.xxx = s.substring(0, s.indexOf("-"));
                }
            } else if (s.contains("ZsMin")) {
                data.xxx_ZsMin = s.substring(s.indexOf("=") + 1, s.length());
                if (TextUtils.isEmpty(data.xxx)) {
                    data.xxx = s.substring(0, s.indexOf("-"));
                }
            } else if (s.contains("ZsAvg")) {
                data.xxx_ZsAvg = s.substring(s.indexOf("=") + 1, s.length());
                if (TextUtils.isEmpty(data.xxx)) {
                    data.xxx = s.substring(0, s.indexOf("-"));
                }
            } else if (s.contains("ZsMax")) {
                data.xxx_ZsMax = s.substring(s.indexOf("=") + 1, s.length());
                if (TextUtils.isEmpty(data.xxx)) {
                    data.xxx = s.substring(0, s.indexOf("-"));
                }
            } else if (s.contains("-Flag")) {
                data.xxx_Flag = HJ212Flag.getEnum(s.substring(s.indexOf("=") + 1, s.length()));
                if (TextUtils.isEmpty(data.xxx)) {
                    data.xxx = s.substring(0, s.indexOf("-"));
                }
            } else if (s.contains("EFlag")) {
                data.xxx_EFlag = s.substring(s.indexOf("=") + 1, s.length());
                if (TextUtils.isEmpty(data.xxx)) {
                    data.xxx = s.substring(0, s.indexOf("-"));
                }
            } else if (s.contains("Cou")) {
                data.xxx_Cou = s.substring(s.indexOf("=") + 1, s.length());
                if (TextUtils.isEmpty(data.xxx)) {
                    data.xxx = s.substring(0, s.indexOf("-"));
                }
            } else if (s.contains("Tol")) {
                data.xxx_Tol = s.substring(s.indexOf("=") + 1, s.length());
                if (TextUtils.isEmpty(data.xxx)) {
                    data.xxx = s.substring(0, s.indexOf("-"));
                }
            } else if (s.contains("-RS")) {
                data.SBxxx_RS = s.substring(s.indexOf("=") + 1, s.length());
                if (TextUtils.isEmpty(data.xxx)) {
                    data.xxx = s.substring(0, s.indexOf("-"));
                }
            } else if (s.contains("-RT")) {
                data.SBxxx_RT = s.substring(s.indexOf("=") + 1, s.length());
                if (TextUtils.isEmpty(data.xxx)) {
                    data.xxx = s.substring(0, s.indexOf("-"));
                }
            } else if (s.contains("-Data")) {
                data.xxx_Data = s.substring(s.indexOf("=") + 1, s.length());
                if (TextUtils.isEmpty(data.xxx)) {
                    data.xxx = s.substring(0, s.indexOf("-"));
                }
            } else if (s.contains("-DayData")) {
                data.xxx_DayData = s.substring(s.indexOf("=") + 1, s.length());
                if (TextUtils.isEmpty(data.xxx)) {
                    data.xxx = s.substring(0, s.indexOf("-"));
                }
            } else if (s.contains("-NightData")) {
                data.xxx_NightData = s.substring(s.indexOf("=") + 1, s.length());
                if (TextUtils.isEmpty(data.xxx)) {
                    data.xxx = s.substring(0, s.indexOf("-"));
                }
            } else if (s.contains("Info")) {
                data.xxx_Info = s.substring(s.indexOf("=") + 1, s.length());
                if (TextUtils.isEmpty(data.xxx)) {
                    data.xxx = s.substring(0, s.indexOf("-"));
                }
            } else if (s.contains("SN")) {
                data.xxx_SN = s.substring(s.indexOf("=") + 1, s.length());
                if (TextUtils.isEmpty(data.xxx)) {
                    data.xxx = s.substring(0, s.indexOf("-"));
                }
            }
        }
        return data;
    }
}
