package com.jarwell.learnandroidsysteminfo;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class AllAppListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<PMAppInfo> dataList;
    private MyRVAdapter mAdapter;
    private int Flag;
    private static final int[] ATTRS = new int[]{android.R.attr.listDivider};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_app_list);
        Intent intent=getIntent();
        Flag=intent.getIntExtra("Flag",99);
        initView();

        mAdapter=new MyRVAdapter(getApplicationContext(),dataList);
        mRecyclerView.setAdapter(mAdapter);

        //设置布局样式
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        //设置动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //设置监听
        mAdapter.setOnItemListener(new MyRVAdapter.OnItemListener() {
            @Override
            public void onClickListener(View view, int pos) {
                Toast.makeText(AllAppListActivity.this, "你点击了"+dataList.get(pos).getAppLabel(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClickListener(View view, int pos) {
                new AlertDialog.Builder(AllAppListActivity.this)
                        .setTitle("应用信息")
                        .setMessage(dataList.get(pos).getAppLabel()+"\n"+dataList.get(pos).getPkgName())
                        .create()
                        .show();
            }
        });
    }
    private void initView() {
        dataList=Utils.getAppInfo(AllAppListActivity.this,Flag);
        mRecyclerView=(RecyclerView)findViewById(R.id.id_recycleview);
    }
}
