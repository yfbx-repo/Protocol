package com.yfbx.protocol.actiity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.yfbx.protocol.R;
import com.yfbx.protocol.bean.DeviceInstallInfo;
import com.yfbx.protocol.hj212.HJ212;
import com.yfbx.protocol.hj212.HJ212CP;
import com.yfbx.protocol.hj212.code.CN;
import com.yfbx.protocol.hj212.code.ST;
import com.yfbx.protocol.serial.SerialManager;
import com.yfbx.protocol.utils.HexUtils;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    EditText editText;
    TextView retTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit_txt);
        retTxt = findViewById(R.id.ret_txt);


        findViewById(R.id.send_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                execute(editText.getText().toString());
            }
        });
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
        msg = HexUtils.stringToHex(msg);
        SerialManager serialPort = new SerialManager();
        serialPort.open("/dev/ttyS4", 9600);
        int i = serialPort.write(msg);
        Log.i("写入长度", "test: " + i);

        String ret = serialPort.read(1024);
        if (ret != null) {
            setText(ret);
            Log.i("返回结果", "test: " + ret);
        } else {
            Log.i("返回结果", "返回结果为空");
        }
        serialPort.close();
    }

    private void setText(final String ret) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                retTxt.append(ret);
                retTxt.append("\r\n");
            }
        });
    }

    /**
     * 取水污染实时数据
     */
    private void getData(DeviceInstallInfo device) {
        HJ212CP result = HJ212.device(device).body(ST._32.getCode(), CN._2011.getCode(), "", "").request();
    }
}
