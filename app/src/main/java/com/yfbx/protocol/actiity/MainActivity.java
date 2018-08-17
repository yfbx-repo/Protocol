package com.yfbx.protocol.actiity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.yfbx.hj212.hj212.HJ212CP;
import com.yfbx.protocol.R;
import com.yfbx.protocol.protocol.ProtocolFactory;
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
        Params params = new Params();
        // TODO: 2018/8/17 HJ212参数
        HJ212CP cp = ProtocolFactory.get(ProtocolFactory.HJ212).getData(params);
    }

    private void test882() {
        Params params = new Params();
        // TODO: 2018/8/17 882参数
        List<String> values = ProtocolFactory.get(ProtocolFactory.MODBUS_882).getData(params);
    }

}
