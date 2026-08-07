package com.oop14;

public class Hero {

    protected String name;
    protected int hp;

    //사용자 정의 생성자
    public Hero(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public void attack() {
        System.out.println("Hero가 공격합니다.");
    }


}//end of class


