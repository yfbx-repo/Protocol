package com.yfbx.hj212.hj212;

import android.text.TextUtils;

import com.yfbx.hj212.code.HJ212Flag;


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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(xxx_SampleTime)) {
            sb.append(xxx).append("-SampleTime=").append(xxx_SampleTime).append(",");
        }
        if (!TextUtils.isEmpty(xxx_Rtd)) {
            sb.append(xxx).append("-Rtd=").append(xxx_Rtd).append(",");
        }
        if (!TextUtils.isEmpty(xxx_fsRtd)) {
            sb.append(xxx).append("-fsRtd=").append(xxx_fsRtd).append(",");
        }
        if (!TextUtils.isEmpty(xxx_ID)) {
            sb.append(xxx).append("-ID=").append(xxx_ID).append(",");
        }
        if (!TextUtils.isEmpty(xxx_Min)) {
            sb.append(xxx).append("-Min=").append(xxx_Min).append(",");
        }
        if (!TextUtils.isEmpty(xxx_Avg)) {
            sb.append(xxx).append("-Avg=").append(xxx_Avg).append(",");
        }
        if (!TextUtils.isEmpty(xxx_Max)) {
            sb.append(xxx).append("-Max=").append(xxx_Max).append(",");
        }
        if (!TextUtils.isEmpty(xxx_ZsRtd)) {
            sb.append(xxx).append("-ZsRtd=").append(xxx_ZsRtd).append(",");
        }
        if (!TextUtils.isEmpty(xxx_ZsMin)) {
            sb.append(xxx).append("-ZsMin=").append(xxx_ZsMin).append(",");
        }
        if (!TextUtils.isEmpty(xxx_ZsAvg)) {
            sb.append(xxx).append("-ZsAvg=").append(xxx_ZsAvg).append(",");
        }
        if (!TextUtils.isEmpty(xxx_ZsMax)) {
            sb.append(xxx).append("-ZsMax=").append(xxx_ZsMax).append(",");
        }
        if (xxx_Flag != null) {
            sb.append(xxx).append("-Flag=").append(xxx_Flag.toString()).append(",");
        }
        if (!TextUtils.isEmpty(xxx_EFlag)) {
            sb.append(xxx).append("-EFlag=").append(xxx_EFlag).append(",");
        }
        if (!TextUtils.isEmpty(xxx_Cou)) {
            sb.append(xxx).append("-Cou=").append(xxx_Cou).append(",");
        }
        if (!TextUtils.isEmpty(xxx_Tol)) {
            sb.append(xxx).append("-Tol=").append(xxx_Tol).append(",");
        }
        if (!TextUtils.isEmpty(SBxxx_RS)) {
            sb.append(xxx).append("-RS=").append(SBxxx_RS).append(",");
        }
        if (!TextUtils.isEmpty(SBxxx_RT)) {
            sb.append(xxx).append("-RT=").append(SBxxx_RT).append(",");
        }
        if (!TextUtils.isEmpty(xxx_Data)) {
            sb.append(xxx).append("-Data=").append(xxx_Data).append(",");
        }
        if (!TextUtils.isEmpty(xxx_DayData)) {
            sb.append(xxx).append("-DayData=").append(xxx_DayData).append(",");
        }
        if (!TextUtils.isEmpty(xxx_NightData)) {
            sb.append(xxx).append("-NightData=").append(xxx_NightData).append(",");
        }
        if (!TextUtils.isEmpty(xxx_Info)) {
            sb.append(xxx).append("-Info=").append(xxx_Info).append(",");
        }
        if (!TextUtils.isEmpty(xxx_SN)) {
            sb.append(xxx).append("-SN=").append(xxx_SN).append(",");
        }

        if (sb.length() > 0) {
            return sb.substring(0, sb.length() - 1);
        }
        return "";
    }
}
