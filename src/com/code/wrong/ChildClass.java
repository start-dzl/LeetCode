package com.code.wrong;

public class ChildClass extends ParentClass{
    private int childX = 1;
    public ChildClass(
    ) {
        System.out.println("ChildX 被赋值为 " + this.childX);
    }
    @Override
    public void setX(int x) {
        super.setX(x);
        this.childX = x;
        System.out.println("ChildX 被赋值为 " + this.childX);
    }
    public void printX() {
        System.out.println("ChildX = " + childX);
    }


}
