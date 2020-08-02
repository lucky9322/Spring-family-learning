package com.lucky.spring.model;

import java.io.Serializable;

/**
 * Created by zhangdd on 2020/7/10
 */
public class T implements Serializable{
    private int id;
    private int a;
    private int b;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "T{" +
                "id=" + id +
                ", a=" + a +
                ", b=" + b +
                '}';
    }
}
