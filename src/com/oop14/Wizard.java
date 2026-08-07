package com.oop14;

public class Wizard extends Hero {
    public Wizard(String name, int hp){
        //부모 클래스 사용자 정의 생성자가 있다면, 반드시 부모 생성자를 호출해야 사용할 수 있다.
        super(name, hp);
//        super.name;
//        super.hp;
    }
    void freezing(){
        System.out.println("freezing 공격을 합니다.");
    }
}

