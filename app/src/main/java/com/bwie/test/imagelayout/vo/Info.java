package com.bwie.test.imagelayout.vo;

import java.util.List;

/**
 * Created by yy123 on 2016/3/10.
 */
public class Info {
    private String data;
    private List<Images> list;
    private String detail;

    public Info() {
    }

    public Info(String data, List<Images> list, String detail) {

        this.data = data;
        this.list = list;
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Info{" +
                "data='" + data + '\'' +
                ", list=" + list +
                ", detail='" + detail + '\'' +
                '}';
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Images> getList() {
        return list;
    }

    public void setList(List<Images> list) {
        this.list = list;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
