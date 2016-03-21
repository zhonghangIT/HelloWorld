package com.uniquedu.myapplication;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    private Button mButtonBack;
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        在此处设置全屏,必须在super方法后，在setContentView()前调用
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        //去掉状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        mButtonBack= (Button) findViewById(R.id.button);
        mTextView= (TextView) findViewById(R.id.textview);
        mButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   mTextView.setVisibility(View.GONE);
            }
        });
    }



    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("运行到MainActivity的onStart方法");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("运行到MainActivity的onResume方法");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("运行到MainActivity的onRestart方法");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("运行到MainActivity的onPause方法");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("运行到MainActivity的onStop方法");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("运行到MainActivity的onDestroy方法");
    }
}
