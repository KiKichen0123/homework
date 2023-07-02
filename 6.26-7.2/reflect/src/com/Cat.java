package com;

/**
 * 该程序的说明如下：
 */
public class Cat {
    private String name = "咪咪";
    public int age = 2;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public void cry(){
        System.out.println(name + "喵喵叫.....");
    }
}
