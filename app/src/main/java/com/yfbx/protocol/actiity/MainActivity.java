package com.yfbx.protocol.actiity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.yfbx.protocol.R;
import com.yfbx.protocol.bean.DeviceInstallInfo;
import com.yfbx.protocol.protocol.Protocol;
import com.yfbx.protocol.protocol.SerialManager;
import com.yfbx.protocol.protocol.hj212.HJ212CP;
import com.yfbx.protocol.protocol.hj212.HJ212Data;
import com.yfbx.protocol.protocol.modbus882.Command;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "协议测试";
    DeviceInstallInfo device;
    EditText editText;
    TextView retTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit_txt);
        retTxt = findViewById(R.id.ret_txt);
        attachDevice();

        findViewById(R.id.send_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                execute(editText.getText().toString());
            }
        });
    }

    /**
     * 设备信息
     */
    private void attachDevice() {
        device = new DeviceInstallInfo();
        device.setComNum("/dev/ttyS4");
        device.setBaudRate(9600);
    }

    /**
     * 执行请求
     */
    public void execute(final String msg) {

        new Thread() {

            @Override
            public void run() {
                try {
                    test(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }


    private void test(String msg) throws IOException, InterruptedException {
        SerialManager serialPort = new SerialManager(device);
        serialPort.sendCommand(msg.getBytes());
        String result = serialPort.readString();
        setText(result);
        serialPort.close();
    }

    private void setText(final String ret) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                retTxt.append(ret);
                retTxt.append("\n");
            }
        });
    }

    /**
     * 取水污染实时数据
     */
    private void testHJ212() {
        HJ212CP result = Protocol.hj212(device, "32", "2011", "123456", "");
        List<HJ212Data> datas = result.datas;
        for (HJ212Data data : datas) {
            String xxx_rtd = data.xxx_Rtd;
        }
    }

    /**
     * 882协议测试
     */
    private void test882() {
        int[] ints = Protocol.read882(device, Command.AD_READ, 1, 8);
    }
}
