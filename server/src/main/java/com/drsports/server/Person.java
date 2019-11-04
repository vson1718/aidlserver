package com.drsports.server;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * @author vson
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
        dest.writeInt(grade);
        dest.writeString(name);
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
