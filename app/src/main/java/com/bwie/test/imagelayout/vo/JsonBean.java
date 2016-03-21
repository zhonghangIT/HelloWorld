package com.bwie.test.imagelayout.vo;

import java.util.List;

/**
 * Created by yy123 on 2016/3/10.
 */
public class JsonBean {
    private List<Info> info;

    public JsonBean() {
    }

    public JsonBean(List<Info> info) {

        this.info = info;
    }

    @Override
    public String toString() {
        return "JsonBean{" +
                "info=" + info +
                '}';
    }

    public List<Info> getInfo() {
        return info;
    }

    public void setInfo(List<Info> info) {
        this.info = info;
    }
}
