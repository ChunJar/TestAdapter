package com.example.cj.testadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private ArrayAdapter adapter;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);
        list = new ArrayList<String>();
        for (int i = 0; i < 40; i++) {
            list.add("数据" + i);
        }

        //adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, list);
        adapter = ArrayAdapter.createFromResource(this, R.array.list_array, R.layout.support_simple_spinner_dropdown_item);
        //adapter = new ArrayAdapter<String>(this, R.layout.array_adapter_item, list);
        lv.setAdapter(adapter);
        //给lv的item设置点击事件
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //parent:表示适配器设置到的adapterView对象，这里表示的是ListView
            //view：适配器item对应的view
            //position：索引位置
            //id：在ListView中的item对应的id
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "点击的是索引:" + position + ",id:" + id, Toast.LENGTH_SHORT).show();
            }
        });
        //实现item长按删除效果
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                list.remove(position);
                //adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.array_adapter_item, list);
                //lv.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

    }
}
