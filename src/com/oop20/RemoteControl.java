package com.oop20;

//키워드가 클래스가 아닌 interface
public interface RemoteControl {
    //1. 인터페이스 안에 선언된 필드는 자동으로 public static final이 붙는다. 즉, 상수가 된다.
    //int MAX_VOLUME = 10; // 여기 코드는 생략되어있음

    //static 변수란? - 모든 객체들이 공유할 수 있는 변수
    public static final int MAX_VOLUME = 10;

    //2. 인터페이스 안에 선언되는 메서드는 8버전 자바, 8버전 default 제외하고 전부 추상메서드로 설계되어야 한다.
    void turnOn();//자동으로 public abstract가 붙는다.
    public abstract void turnOff(); //이러게 써도 무방함
    void setVolume(int volume);

    //3. 인터페이스는 상속과 달리 여러 개를 가지고 올 수 있다.
}
