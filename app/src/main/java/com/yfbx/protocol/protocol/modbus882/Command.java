package com.yfbx.protocol.protocol.modbus882;

/**
 * Author:Edward
 * Date:2018/6/25
 * Description:
 */

public interface Command {

    String SWITCH_READ = "02";//开关量读取

    String REGISTER_READ = "03";//读控制寄存器

    String AD_READ = "04";//读模拟量AD值

    String SWITCH_OUTPUT = "05";//开关量输出

    String REGISTER_WRITE = "06";//写控制寄存器

}
