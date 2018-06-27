package com.yfbx.protocol.protocol.hj212;

import android.text.TextUtils;

import com.yfbx.protocol.protocol.hj212.code.HJ212ExeRtn;
import com.yfbx.protocol.protocol.hj212.code.HJ212QnRtn;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:Edward
 * Date:2018/6/15
 * Description:数据区
 */

public class HJ212CP {

    public String SystemTime;
    public HJ212QnRtn QnRtn;//请求回应代码
    public HJ212ExeRtn ExeRtn;//执行结果回应代码
    public String RtdInterval;//实时采样数据上报间隔
    public String MinInterval;//分钟数据上报间隔
    public String RestartTime;//数采仪开机时间
    public String PolId;//污染因子的编码
    public String BeginTime;//开始时间
    public String EndTime;//截止时间
    public String DataTime;//数据时间信息
    public String NewPW;//新密码
    public String OverTime;//超时时间
    public String ReCount;//重发次数
    public String VaseNo;//采样瓶编号
    public String CstartTime;//设备采样起始时间
    public String Ctime;//采样周期
    public String Stime;//出样时间
    public String InfoId;//现场端信息编码

    public List<HJ212Data> datas = new ArrayList<>();

    public static HJ212CP parse(String cpString) {
        HJ212CP cp = new HJ212CP();
        String[] subs = cpString.split(";");
        for (String s : subs) {
            if (s.contains("-")) {
                cp.datas.add(HJ212Data.parse(s));
            } else if (s.contains("SystemTime")) {
                cp.SystemTime = s.substring(11, s.length());
            } else if (s.contains("QnRtn")) {
                cp.QnRtn = HJ212QnRtn.getEnum(s.substring(6, s.length()));
            } else if (s.contains("ExeRtn")) {
                cp.ExeRtn = HJ212ExeRtn.getEnum(s.substring(7, s.length()));
            } else if (s.contains("RtdInterval")) {
                cp.RtdInterval = s.substring(12, s.length());
            } else if (s.contains("MinInterval")) {
                cp.MinInterval = s.substring(12, s.length());
            } else if (s.contains("RestartTime")) {
                cp.RestartTime = s.substring(12, s.length());
            } else if (s.contains("PolId")) {
                cp.PolId = s.substring(6, s.length());
            } else if (s.contains("BeginTime")) {
                cp.BeginTime = s.substring(10, s.length());
            } else if (s.contains("EndTime")) {
                cp.EndTime = s.substring(8, s.length());
            } else if (s.contains("DataTime")) {
                cp.DataTime = s.substring(9, s.length());
            } else if (s.contains("NewPW")) {
                cp.NewPW = s.substring(6, s.length());
            } else if (s.contains("OverTime")) {
                cp.OverTime = s.substring(9, s.length());
            } else if (s.contains("ReCount")) {
                cp.ReCount = s.substring(8, s.length());
            } else if (s.contains("VaseNo")) {
                cp.VaseNo = s.substring(7, s.length());
            } else if (s.contains("CstartTime")) {
                cp.CstartTime = s.substring(11, s.length());
            } else if (s.contains("Ctime")) {
                cp.Ctime = s.substring(6, s.length());
            } else if (s.contains("Stime")) {
                cp.Stime = s.substring(6, s.length());
            } else if (s.contains("InfoId")) {
                cp.InfoId = s.substring(7, s.length());
            }
        }
        return cp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(SystemTime)) {
            sb.append("SystemTime=").append(SystemTime).append(";");
        }
        if (QnRtn != null) {
            sb.append("QnRtn=").append(QnRtn.getCode()).append(";");
        }
        if (ExeRtn != null) {
            sb.append("ExeRtn=").append(ExeRtn.getCode()).append(";");
        }
        if (!TextUtils.isEmpty(RtdInterval)) {
            sb.append("RtdInterval=").append(RtdInterval).append(";");
        }
        if (!TextUtils.isEmpty(MinInterval)) {
            sb.append("MinInterval=").append(MinInterval).append(";");
        }
        if (!TextUtils.isEmpty(RestartTime)) {
            sb.append("RestartTime=").append(RestartTime).append(";");
        }
        if (!TextUtils.isEmpty(PolId)) {
            sb.append("PolId=").append(PolId).append(";");
        }
        if (!TextUtils.isEmpty(BeginTime)) {
            sb.append("BeginTime=").append(BeginTime).append(";");
        }
        if (!TextUtils.isEmpty(EndTime)) {
            sb.append("EndTime=").append(EndTime).append(";");
        }
        if (!TextUtils.isEmpty(DataTime)) {
            sb.append("DataTime=").append(DataTime).append(";");
        }
        if (!TextUtils.isEmpty(NewPW)) {
            sb.append("NewPW=").append(NewPW).append(";");
        }
        if (!TextUtils.isEmpty(OverTime)) {
            sb.append("OverTime=").append(OverTime).append(";");
        }
        if (!TextUtils.isEmpty(ReCount)) {
            sb.append("ReCount=").append(ReCount).append(";");
        }
        if (!TextUtils.isEmpty(VaseNo)) {
            sb.append("VaseNo=").append(VaseNo).append(";");
        }
        if (!TextUtils.isEmpty(CstartTime)) {
            sb.append("CstartTime=").append(CstartTime).append(";");
        }
        if (!TextUtils.isEmpty(Ctime)) {
            sb.append("Ctime=").append(Ctime).append(";");
        }
        if (!TextUtils.isEmpty(Stime)) {
            sb.append("Stime=").append(Stime).append(";");
        }
        if (!TextUtils.isEmpty(InfoId)) {
            sb.append("InfoId=").append(InfoId).append(";");
        }
        if (!datas.isEmpty()) {
            for (HJ212Data d : datas) {
                String ds = d.toString();
                if (!TextUtils.isEmpty(ds)) {
                    sb.append(ds).append(";");
                }
            }
        }
        if (sb.length() > 0) {
            return sb.substring(0, sb.length() - 1);
        }
        return "";
    }

}
