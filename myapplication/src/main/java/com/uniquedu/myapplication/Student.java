package com.uniquedu.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by ZhongHang on 2016/3/19.
 */
public class Student implements Parcelable {
    private String name;
    private String sex;
    private String age;
    private int num;

    public Student(String name, String sex, String age,int num) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.num=num;
    }

    protected Student(Parcel in) {
        name = in.readString();
        sex = in.readString();
        age = in.readString();
        num=in.readInt();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(sex);
        dest.writeString(age);
        dest.writeInt(num);
    }
}
