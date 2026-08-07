package com.oop18;

public class DeskTop extends Computer {

    @Override
    public void display() {
        System.out.println("DeskTop의 화면에 출력합니다.");
    }

    @Override
    public void typing() {
        System.out.println("DeskTop 키보드로 타이핑하세요.");
    }


    public static void main(String[] args) {
        Computer computer = new DeskTop();
        computer.turnOn();
        computer.turnOff();
    }
}
