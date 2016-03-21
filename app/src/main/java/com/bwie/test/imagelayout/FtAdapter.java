package com.bwie.test.imagelayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.bwie.test.imagelayout.vo.Images;
import com.bwie.test.imagelayout.vo.Info;

import java.util.List;

/**
 * Created by yy123 on 2016/3/10.
 */
public class FtAdapter extends BaseAdapter {
    //定义变量
    private Context context;
    private List<Info> beansList ;
    public static  ChildAdapter childAdapter;
    private List<Images> list;
    public FtAdapter(Context context, List<Info> beansList) {
        this.context = context;
        this.beansList = beansList;
    }

    public int getCount() {
        return beansList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder v = null;
        //优化
        if(convertView == null ){
            v = new ViewHolder();
            //加载布局
            convertView = LayoutInflater.from(context).inflate(R.layout.father_item,null);
            v.timer = (TextView) convertView.findViewById(R.id.father_timer);
            v.gridView = (GridView) convertView.findViewById(R.id.father_gridView);
            //存储标记
            convertView.setTag(v);
        }else{
            v = (ViewHolder) convertView.getTag();
        }
        //赋值
        v.timer.setText(beansList.get(position).getData());
         list = beansList.get(position).getList();
        for (int i = 0 ;i<list.size();i++){
            Images iv = new Images();
            iv.setIsCheck(false);
        }
        childAdapter = new ChildAdapter(context,list);
        v.gridView.setAdapter(childAdapter);
        v.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ChildAdapter.ViewH viewH = (ChildAdapter.ViewH) view.getTag();
                viewH.cb.toggle();//改变checkbox的状态
            }
        });
        childAdapter.notifyDataSetChanged();
        return convertView;
    }
    class ViewHolder{
        TextView timer;
        GridView gridView;
    }
}
