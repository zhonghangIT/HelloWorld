package com.uniquedu.mytextview;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.Spannable;
import android.text.Spanned;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.button);
        mTextView = (TextView) findViewById(R.id.textview);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击按钮后更改文本内容
//                mTextView.setText("更改后的内容");
                //更改字体颜色
//                mTextView.setTextColor(Color.argb(0xff,0x00,0xff,0x00));
//                mTextView.setTextSize(20);//此处传入值为像素值
                mTextView.setAutoLinkMask(Linkify.ALL);
                mTextView.setText("我是一段文本 18612313241，大家有什么不会的可以上网搜索http://www.baidu.com 有是有搜素可以使用");
                mTextView.setCompoundDrawablesWithIntrinsicBounds
                        (R.mipmap.header, R.mipmap.ic_launcher, R.mipmap.header, R.mipmap.ic_launcher);

            }

        });
    }

}
