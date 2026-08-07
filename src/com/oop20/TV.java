package com.oop20;

//implemants - 구현한다.
//기능 중심의 설계, interface 구현해야하는 기능의 강제성을 가진다.
public class TV implements RemoteControl {

    private int volume;

    @Override
    public void turnOn() {
        System.out.println("TV 전원을 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("TV 전원을 끕니다.");
    }

    @Override
    public void setVolume(int volume) {
        if(volume > MAX_VOLUME){
            this.volume = MAX_VOLUME;
        } else{
            this.volume = volume;
        }
        System.out.println("TV 볼륨을 " + this.volume + "으로 설정합니다.");
    }
}
