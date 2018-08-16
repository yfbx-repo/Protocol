package com.yfbx.protocol.actiity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.yfbx.hj212.HJ212;
import com.yfbx.hj212.code.CN;
import com.yfbx.hj212.code.ST;
import com.yfbx.hj212.hj212.HJ212CP;
import com.yfbx.modbus882.M882;
import com.yfbx.protocol.R;
import com.yfbx.protocol.SerialManager;

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


    private void test882() {
        M882 m882 = new M882();
        byte[] pack = m882.pack(M882.AD_READ, "15", 1, 8);
        SerialManager serial = SerialManager.getInstance();
        serial.open("/dev/ttyS4", 9600);
        serial.write(pack);

        byte[] read = serial.read();
        List<String> data = m882.parse(read);
    }

    private void testHJ212() {
        HJ212CP cp = new HJ212CP();
        HJ212 hj212 = new HJ212();
        byte[] pack = hj212.pack(ST._32.getCode(), CN._2011.getCode(), "", "", 5, cp);
        SerialManager serial = SerialManager.getInstance();
        serial.open("/dev/ttyS4", 9600);
        serial.write(pack);

        byte[] read = serial.read();
        HJ212CP parse = hj212.parse(read);
    }


}
