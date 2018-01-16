package com.example.a30093.memo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tv;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv = (TextView) findViewById(R.id.textView2);
        et = (EditText) findViewById(R.id.editText);

        Intent it = getIntent();
        String s = it.getStringExtra("Cont");

        tv.setText(s.substring(0, 2));    //去除0个后读两个

        if(s.length() > 3) et.setText(s.substring(3));
        //因为直接将序号连带内容接受 备忘数据去除前三个字符 再输入到编辑组件中
    }

    public void onCancel(View v) {
        setResult(RESULT_CANCELED);
        //要返回但是因为不止一种返回方式 需要让MainActivity做区分 从而进行不同的处理 需要标明该返回身份的resultCode
        finish();
    }

    public void onSave(View v) {
        Intent it = new Intent();
        it.putExtra("Cont", tv.getText() + " " + et.getText());
        setResult(RESULT_OK, it);
        finish();
    }
}
