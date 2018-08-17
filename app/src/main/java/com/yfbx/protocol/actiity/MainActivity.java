package com.yfbx.protocol.actiity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.yfbx.hj212.code.CN;
import com.yfbx.hj212.code.ST;
import com.yfbx.hj212.hj212.HJ212CP;
import com.yfbx.modbus882.M882;
import com.yfbx.protocol.R;
import com.yfbx.protocol.protocol.ProtocolFactory;
import com.yfbx.protocol.protocol.params.Device;
import com.yfbx.protocol.protocol.params.P212;
import com.yfbx.protocol.protocol.params.P882;
import com.yfbx.protocol.protocol.params.Params;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    EditText editText;
    TextView retTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit_txt);
        retTxt = findViewById(R.id.ret_txt);
    }


    private void test212() {
        //设备信息
        Device device = new Device();
        device.dev = "/dev/ttyS4";//设备串口地址
        device.baudRate = 9600;//波特率
        device.dataBits = 8;//数据位
        device.parity = 0;//校验位
        device.stopBit = 1;//停止位
        //参数
        P212 p = new P212();
        p.ST = ST._32.getCode();
        p.CN = CN._2011.getCode();
        p.PW = "123456";
        p.MN = "";
        p.Flag = 5;
        p.CP = new HJ212CP().toString();//设置CP具体参数

        Params params = new Params();
        params.setDevice(device);
        params.setP212(p);

        HJ212CP cp = ProtocolFactory.get(ProtocolFactory.HJ212).getData(params);
    }

    private void test882() {
        //设备信息
        Device device = new Device();
        device.dev = "/dev/ttyS4";//设备串口地址
        device.baudRate = 9600;//波特率
        device.dataBits = 8;//数据位
        device.parity = 0;//校验位
        device.stopBit = 1;//停止位
        //参数
        P882 p = new P882();
        p.address = "15";//地址码
        p.code = M882.AD_READ;//模拟量
        p.start = 1;//起始位置
        p.count = 8;//读8路模拟量

        Params params = new Params();
        params.setDevice(device);
        params.setP882(p);

        List<String> values = ProtocolFactory.get(ProtocolFactory.MODBUS_882).getData(params);
    }

}
