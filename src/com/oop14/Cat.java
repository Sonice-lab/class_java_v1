package com.oop14;

//클래스간의 공통점이 보인다면 상속을 사용한다.
public class Cat extends Animal {
    //어노테이션(주석 + 힌트)
    @Override
    void eat() {
        System.out.println("고양이가 밥을 먹습니다.");
    }
}
