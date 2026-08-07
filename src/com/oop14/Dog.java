package com.oop14;

public class Dog extends Animal {
    //어노테이션(주석 + 힌트)
    @Override
    void eat() {
        super.eat();
        System.out.println("강아지가 밥을 먹습니다.");
    }

}
