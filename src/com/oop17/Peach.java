package com.oop17;

public class Peach extends Fruit {

    public Peach(){
        name = "복숭아";
        price = 8000;
    }
    //sale()을 재정의하지 않았음
    //부모의 기본 동작인 "할인 대상이 아닙니다"가 실행된다.
}
