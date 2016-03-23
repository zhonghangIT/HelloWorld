package com.uniquedu.mytextview;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private TextView mTextView;
    private Switch mSwitch;
    private CheckBox mCheckBox;
    private ToggleButton mToggleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.button);
        mTextView = (TextView) findViewById(R.id.textview);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result=readFromAssets();
                Gson gson=new Gson();
                Clazz clazz=gson.fromJson(result,Clazz.class);
                Log.d("myTag",""+clazz.getClazzName()+clazz.getStudents().get(0).getName());
            }
        });
        mSwitch= (Switch) findViewById(R.id.switch1);
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
    }

    private String readFromAssets() {
        StringBuffer response = new StringBuffer();
        AssetManager manager = getAssets();
        try {
            InputStream in = manager.open("json.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = reader.readLine();
            while (line != null) {
                response.append(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.toString();
    }
}
