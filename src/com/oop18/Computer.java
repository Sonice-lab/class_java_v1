package com.oop18;

public abstract class Computer {

    public abstract void display();
    public abstract void typing();

    public void turnOn() {
        System.out.println("시스템의 전원을 켭니다.");
    }

    public void turnOff() {
        System.out.println("시스템의 전원을 끕니다.");
    }
}
