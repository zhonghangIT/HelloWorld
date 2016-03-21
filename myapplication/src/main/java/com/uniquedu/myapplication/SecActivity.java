package com.uniquedu.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ZhongHang on 2016/3/16.
 */
public class SecActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("运行到SecActivity的onStart方法");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("运行到SecActivity的onResume方法");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("运行到SecActivity的onRestart方法");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("运行到SecActivity的onPause方法");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("运行到SecActivity的onStop方法");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("运行到SecActivity的onDestroy方法");
    }
}
