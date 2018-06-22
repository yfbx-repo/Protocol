package com.yfbx.protocol.bean;

/**
 * 设备安装信息
 * Created by 张明_ on 2018/3/23.
 * Email 741183142@qq.com
 */
public class DeviceInstallInfo {
    //PK
    private Long id;

    //FK2 点位ID
    private long pointId;
    //FK1 设备归属信息ID
    private long deviceBelongInfoId;
    //安装位置
    private String instalLocation;
    //监控类型 字典项  如果是数采仪，那么监控类型就是字典表里的 default 类型；如果是在线仪（现场设备），那么监控类型就是一开始采集能力配置里面选择的监控类型
    private String monitorType;
    //MN号
    private String mnNum;
    //COM口
    private String comNum;
    //485地址
    private String communicateAddress;
    //波特率
    private Integer baudRate;
    //起始位
    private Integer startBit;
    //停止位
    private Integer endBit;
    //校验位
    private Integer checkBit;

    public DeviceInstallInfo() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getPointId() {
        return this.pointId;
    }

    public void setPointId(long pointId) {
        this.pointId = pointId;
    }

    public long getDeviceBelongInfoId() {
        return this.deviceBelongInfoId;
    }

    public void setDeviceBelongInfoId(long deviceBelongInfoId) {
        this.deviceBelongInfoId = deviceBelongInfoId;
    }

    public String getInstalLocation() {
        return this.instalLocation;
    }

    public void setInstalLocation(String instalLocation) {
        this.instalLocation = instalLocation;
    }

    public String getMonitorType() {
        return this.monitorType;
    }

    public void setMonitorType(String monitorType) {
        this.monitorType = monitorType;
    }

    public String getMnNum() {
        return this.mnNum;
    }

    public void setMnNum(String mnNum) {
        this.mnNum = mnNum;
    }

    public String getComNum() {
        return this.comNum;
    }

    public void setComNum(String comNum) {
        this.comNum = comNum;
    }

    public String getCommunicateAddress() {
        return this.communicateAddress;
    }

    public void setCommunicateAddress(String communicateAddress) {
        this.communicateAddress = communicateAddress;
    }

    public Integer getBaudRate() {
        return this.baudRate;
    }

    public void setBaudRate(Integer baudRate) {
        this.baudRate = baudRate;
    }

    public Integer getStartBit() {
        return this.startBit;
    }

    public void setStartBit(Integer startBit) {
        this.startBit = startBit;
    }

    public Integer getEndBit() {
        return this.endBit;
    }

    public void setEndBit(Integer endBit) {
        this.endBit = endBit;
    }

    public Integer getCheckBit() {
        return this.checkBit;
    }

    public void setCheckBit(Integer checkBit) {
        this.checkBit = checkBit;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceInstallInfo that = (DeviceInstallInfo) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
