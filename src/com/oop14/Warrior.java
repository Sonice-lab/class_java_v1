package com.oop14;

public class Warrior extends Hero {//super 불러오기
    public Warrior(String name, int hp){
        //부모 클래스 사용자 정의 생성자가 있다면, 반드시 부모 생성자를 호출해야 사용할 수 있다.
        super(name, hp);
//        super.name;
//        super.hp;
    }
    void comboAttack(){
        System.out.println("콤보 공격을 합니다.");
    }
}


