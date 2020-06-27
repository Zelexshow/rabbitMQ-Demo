package com.zelex.startdemo.sender;

import java.io.Serializable;
import java.util.Date;

public class Persion {
    private String name;
    private Date birthday;

    public Persion(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
