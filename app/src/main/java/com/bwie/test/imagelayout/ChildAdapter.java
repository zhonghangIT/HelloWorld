package com.bwie.test.imagelayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;

import com.bwie.test.imagelayout.utils.ImageLoad;
import com.bwie.test.imagelayout.vo.Images;

import java.util.List;

import static com.bwie.test.imagelayout.R.id.child_cb;

/**
 * Created by yy123 on 2016/3/10.
 */
public  class ChildAdapter extends BaseAdapter {
    private Context context;
    private List<Images> newsList ;

    public ChildAdapter(Context context, List<Images> newsList) {
        this.context = context;
        this.newsList = newsList;

    }


    public int getCount() {
        return newsList.size();
    }


    public Object getItem(int position) {
        return null;
    }


    public long getItemId(int position) {
        return 0;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        ViewH v = null;
        if(convertView == null ){
            v = new ViewH();
            //加载布局
            convertView = LayoutInflater.from(context).inflate(R.layout.child_item,null);
            //找控件

            v.imageView = (ImageView) convertView.findViewById(R.id.child_img);
            v.cb = (CheckBox) convertView.findViewById(child_cb);
            //存标记
            convertView.setTag(v);

        }else{
            v = (ViewH) convertView.getTag();
        }
        //赋值
        v.cb.setChecked(newsList.get(position).isCheck());
        v.cb.setOnCheckedChangeListener(new MyClick(position));
        new ImageLoad().showImageByThread(newsList.get(position).getImage(),v.imageView);
        this.notifyDataSetChanged();//刷新适配器

        return convertView;
    }
    class MyClick implements OnCheckedChangeListener{
        private int poition;
        public MyClick(int poition) {
            super();
            this.poition = poition;
        }
        public void onCheckedChanged(CompoundButton buttonView,
                                     boolean isChecked) {

            newsList.get(poition).setIsCheck(isChecked);
        }
    };
    static class ViewH{
        ImageView imageView;

        CheckBox cb;
    }
}