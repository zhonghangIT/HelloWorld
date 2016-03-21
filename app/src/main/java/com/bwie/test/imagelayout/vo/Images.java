package com.bwie.test.imagelayout.vo;

/**
 * Created by yy123 on 2016/3/10.
 */
public class Images {
    private String image;
    private boolean isCheck;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setIsCheck(boolean isCheck) {
        this.isCheck = isCheck;
    }

    @Override
    public String toString() {
        return "Images{" +
                "image='" + image + '\'' +
                ", isCheck=" + isCheck +
                '}';
    }

    public Images() {
    }
}
