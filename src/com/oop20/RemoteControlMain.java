package com.oop20;

public class RemoteControlMain {

    public static void main(String[] args) {

        //인터페이스 타입으로 객체를 받을 수 있다.
        RemoteControl rc = new TV(); //부모 타입으로 받았다! -> 즉, 업캐스팅된 상태!
        rc.turnOn();
        rc.setVolume(15);
        rc.turnOff();

        System.out.println("-----------------------------");

        rc = new Audio();
        rc.turnOn();
        rc.setVolume(5);
        rc.turnOff();

    }//end of main
}//end of class
