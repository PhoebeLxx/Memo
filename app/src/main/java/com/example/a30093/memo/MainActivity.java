package com.example.a30093.memo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{
    String[] aMemo = {
            "1. Edit content",
            "2. Long press to remove the content", "3. ", "4. ", "5. ", "6. "};
    ListView lv;
    ArrayAdapter<String> aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.ListView);
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, aMemo);

        lv.setAdapter(aa);      //设置istView的内容

        lv.setOnItemClickListener(this);
        lv.setOnItemLongClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> av, View view, int pos, long id) {
        Intent it = new Intent(this, SecondActivity.class);

        //it.putExtra("Num", pos + 1);
        it.putExtra("Cont", aMemo[pos]);
        startActivityForResult(it, pos);        //pos -> requestCode
    }

    public void onActivityResult(int requestCode, int resultCode, Intent it) {
        if (resultCode == RESULT_OK) {
            aMemo[requestCode] = it.getStringExtra("Cont");
            aa.notifyDataSetChanged();
        }
    }
    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long id) {
        aMemo[pos] = (pos + 1) + ".";
        aa.notifyDataSetChanged();
        return true;
    }
}
