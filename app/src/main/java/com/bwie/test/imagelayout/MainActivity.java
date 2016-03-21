package com.bwie.test.imagelayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.test.imagelayout.vo.Images;
import com.bwie.test.imagelayout.vo.Info;
import com.bwie.test.imagelayout.vo.JsonBean;
import com.google.gson.Gson;
import com.squareup.okhttp.Request;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //定义变量
    private TextView maindel;
    public TextView mainok;
    private ListView mainlv;
    private JsonBean jsonBean = new JsonBean();
    private List<Images> imagesList = new ArrayList<Images>();
    private List<Info> beanList = new ArrayList<Info>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        getDatas();
        maindel.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击了删除按钮", Toast.LENGTH_SHORT).show();
                ArrayList setlist = new ArrayList();
                //删除

                for (int i = 0; i < imagesList.size(); i++) {
                    if (imagesList.get(i).isCheck()) {
                        setlist.add(imagesList.get(i));
                    }
                }
                Log.i("TAG删除：", "要删除的集合大小：" + setlist.size());
                imagesList.removeAll(setlist);
                setlist.clear();
                //刷新适配器
                FtAdapter.childAdapter.notifyDataSetChanged();
            }
        });
    }
    public void getDatas(){
        String url="http://169.254.64.206:8080/shixun//servlet/ShiXunDemo";
        HttpManager.getAsynIO(url, new HttpManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                Log.i("TAG","网络请求失败");
            }

            @Override
            public void onResponse(String response) {
                Log.i("TAG","网络请求成功:数据为i+"+response);
                Gson g = new Gson();
                jsonBean  = g.fromJson(response, JsonBean.class);
                beanList = jsonBean.getInfo();
//                for (int a = 0;a<beanList.size();a++){
//                    imagesList = beanList.get(a).getList();
//                }
                imagesList = beanList.get(0).getList();//?????
                FtAdapter adapter = new FtAdapter(MainActivity.this,beanList);
                mainlv.setAdapter(adapter);
                mainlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ChildAdapter.ViewH viewH  = (ChildAdapter.ViewH) view.getTag();
                        viewH.cb.toggle();//改变checkbox的状态
                    }
                });
            }
        });
    }
    private void initialize() {
        maindel = (TextView) findViewById(R.id.main_del);
        mainok = (TextView) findViewById(R.id.main_ok);
        mainlv = (ListView) findViewById(R.id.main_lv);
    }
}