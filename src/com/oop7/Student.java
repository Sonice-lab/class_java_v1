package com.oop7;

public class Student {
    String name;
    int money;

    public Student(String n, int m) {
        name = n;
        money = m;
    }

    public void eat(Rice e) {

    }

    public void takeBus(Bus bus) {
        money -= 1000;
        bus.take(1000);
    }

    public void showInfo() {
        System.out.println("----------상태창----------");
        System.out.println("이름: " + name);
        System.out.println("소지금: " + money);
    }

    public void takeSubway(Subway sb) {
        money -= 1_500;
        sb.take(1500);
    }
}//end of class


