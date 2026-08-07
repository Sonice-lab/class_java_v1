package com.oop18;

public abstract class Animal {//여기에 abstract 처리를 해주어야 문제가 되지 않음!
    // 추상 클래스란?(abstract class)
    //class 앞에 abstract 키워드가 있거나 또는 하나 이상의 추상 메서드를 가지는 클래스
    //어떨 때 쓰는 걸까? - 가구는 객체로 나타낼 수 없다.

    String name;
    public void move(){
        System.out.println("이동합니다.");
    }
    //추상 메서드 -> 메서드 선언부만 존재하는 녀석 + abstract
    public abstract void hunt();
    //추상 메서드가 단 하나라도 존재한다면 그 클래스는 추상 클래스여야 한다. - 강제성

    public static void main(String[] args) {

        //추상 클래스는 직접적으로 객체로 생성할 수 없다.
        //Animal animal = new Animal(); 제약사항 --> 직접 new 키워드를 사용할 수 없음!
    }
}
