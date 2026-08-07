package com.oop20;
//SmartPhone은 RemoteControl과 Chargeable을 바라보고 있다. --> 다형성
public class SmartPhone implements RemoteControl, Chargeable {

    private int volume;

    @Override
    public void turnOn() {
        System.out.println("스마트폰 화면을 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("스마트폰 화면을 끕니다.");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("스마트폰 볼륨을" + this.volume + "으로 조정합니다.");
    }

    @Override
    public void charge() {
        System.out.println("스마트폰을 충전합니다.");
    }
}
