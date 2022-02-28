package com.code.wrong;

public class ParentClass {
    private int parentX;
    public ParentClass() {
        setX(100);
    }
    public void setX(int x) {
        parentX = x;
        System.out.println("ParentClass 被赋值为 " + x);
    }
}


