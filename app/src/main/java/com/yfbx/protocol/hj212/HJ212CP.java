package com.yfbx.protocol.hj212;

import com.yfbx.protocol.hj212.code.HJ212ExeRtn;
import com.yfbx.protocol.hj212.code.HJ212QnRtn;

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

    private List<HJ212Data> datas = new ArrayList<>();

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

}
