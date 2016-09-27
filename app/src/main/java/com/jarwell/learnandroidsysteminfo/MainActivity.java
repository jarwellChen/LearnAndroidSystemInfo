package com.jarwell.learnandroidsysteminfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static com.jarwell.learnandroidsysteminfo.Utils.ALL_APP;
import static com.jarwell.learnandroidsysteminfo.Utils.SDCARD_APP;
import static com.jarwell.learnandroidsysteminfo.Utils.SYSTEM_APP;
import static com.jarwell.learnandroidsysteminfo.Utils.THIRD_APP;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void btnAllApp(View view){
        Intent intent=new Intent(MainActivity.this,AllAppListActivity.class);
        intent.putExtra("Flag",ALL_APP);
        startActivity(intent);
    }
    public void btnSysApp(View view){
        Intent intent=new Intent(MainActivity.this,AllAppListActivity.class);
        intent.putExtra("Flag",SYSTEM_APP);
        startActivity(intent);
    }
    public void btn3ptApp(View view){
        Intent intent=new Intent(MainActivity.this,AllAppListActivity.class);
        intent.putExtra("Flag",THIRD_APP);
        startActivity(intent);
    }
    public void btnSdcardApp(View view){
        Intent intent=new Intent(MainActivity.this,AllAppListActivity.class);
        intent.putExtra("Flag",SDCARD_APP);
        startActivity(intent);
    }
}
