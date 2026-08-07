package com.oop19;

//템플릿 메서드 - 디자인 패턴 살펴보기
public abstract class Car {//클래스 앞에 final을 선언할 경우 상속불가!

    //final private String NAME; --> 변수에 final을 쓰면 상수가 된다.

    private void startCar(){
        System.out.println("시동을 켭니다.");
    }

    private void turnOff(){
        System.out.println("시동을 끕니다.");
    }

    protected abstract void drive();
    protected abstract void stop();

    //핵심: 이 메서드를 템플릿 메서드로 설계하겠다!
    //실행의 흐름이 미리 정의되어있다. > 미리 호출하게끔 설계 - 반드시 final 키워드를 선언해준다.
        final public void run(){ // --> 메서드에 final 정의하면 재정의 불가! 오버라이드 불가!
        startCar(); //1. 시동 걸기
        drive();//2. 운전하기
        stop();//3. 정지하기
        turnOff(); //4. 시동끄기
    }
}
