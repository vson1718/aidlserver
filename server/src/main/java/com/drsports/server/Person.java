package com.drsports.server;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * @author vson
 * @date 2019-10-24.
 * Company:上海动博士企业发展有限公司
 * E-mail :13013099535@163.com
 * 项目描述:
 */
public class Person implements Parcelable {

    private String name;
    private int grade;


    public Person(String name, int grade) {
        this.grade = grade;
        this.name = name;
    }

    protected Person(Parcel in) {
        this.grade = in.readInt();
        this.name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(grade);
    }

    @Override
    public int describeContents() {
        return 0;
    }


    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}