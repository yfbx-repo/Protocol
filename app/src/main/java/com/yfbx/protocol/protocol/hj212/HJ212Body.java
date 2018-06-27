package com.yfbx.protocol.protocol.hj212;

import android.text.TextUtils;

import java.text.SimpleDateFormat;

/**
 * Author:Edward
 * Date:2018/6/14
 * Description:数据段
 */

public class HJ212Body {

    private String QN;//请求编码,精确到毫秒的时间戳:QN=YYYYMMDDhhmmsszzz
    private String ST;//系统编码
    private String CN;//命令编码
    private String PW;//访问密码，6位密码
    private String MN;//设备唯一标识,MN 由 24 个 0-9，A-F 的字符组成
    private String Flag;//标志位，这个标志位包含标准版本号、是否拆分包、数据是否应答
    private String PNUM;//指示本次通讯中总共包含的包数
    private String PNO;//指示当前数据包的包号
    private String CP;//&&数据区&& eg. HJ212CP=&&DataTime=20160824003817000;B01-Rtd=36.91;011-Rtd=231.0,011-Flag=N;060-Rtd=1.803,060-Flag=N&&


    public HJ212Body() {
    }

    public HJ212Body(String ST, String CN, String PW, String MN, String CP) {
        this.QN = getTimeMillis();
        this.ST = ST;
        this.CN = CN;
        this.PW = PW;
        this.MN = MN;
        this.Flag = "5";
        this.CP = CP;
    }

    /**
     * 取数据时，发送的命令CP大多为空
     */
    public HJ212Body(String ST, String CN, String PW, String MN) {
        this.QN = getTimeMillis();
        this.ST = ST;
        this.CN = CN;
        this.PW = PW;
        this.MN = MN;
        this.Flag = "5";
        setCP("");
    }


    private String getTimeMillis() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(System.currentTimeMillis());
    }

    public String getQN() {
        return QN;
    }

    public void setQN(String QN) {
        this.QN = QN;
    }

    public String getST() {
        return ST;
    }

    public void setST(String ST) {
        this.ST = ST;
    }

    public String getCN() {
        return CN;
    }

    public void setCN(String CN) {
        this.CN = CN;
    }

    public String getPW() {
        return PW;
    }

    public void setPW(String PW) {
        this.PW = PW;
    }

    public String getMN() {
        return MN;
    }

    public void setMN(String MN) {
        this.MN = MN;
    }

    public String getFlag() {
        return Flag;
    }

    public void setFlag(String flag) {
        Flag = flag;
    }

    public String getPNUM() {
        return PNUM;
    }

    public void setPNUM(String PNUM) {
        this.PNUM = PNUM;
    }

    public String getPNO() {
        return PNO;
    }

    public void setPNO(String PNO) {
        this.PNO = PNO;
    }

    public String getCP() {
        return CP.replaceAll("&", "").trim();
    }

    public void setCP(String CP) {
        this.CP = "&&" + CP + "&&";
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("QN=").append(QN).append(";");
        builder.append("ST=").append(ST).append(";");
        builder.append("CN=").append(CN).append(";");
        builder.append("PW=").append(PW).append(";");
        builder.append("MN=").append(MN).append(";");
        builder.append("Flag=").append(Flag).append(";");
        if (!TextUtils.isEmpty(PNUM)) {
            builder.append("PNUM=").append(PNUM).append(";");
        }
        if (!TextUtils.isEmpty(PNO)) {
            builder.append("PNO=").append(PNO).append(";");
        }
        builder.append("HJ212CP=").append(CP);
        return builder.toString();
    }
}
