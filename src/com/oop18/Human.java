package com.oop18;

//abstract를 붙이지 않았을 때 문법적 오류가 나는 이유
public abstract class Human extends Animal {
    //추상 클래스 정의
    //Animal에는 추상 메서드가 존재하고 있음
    // 부모의 모든 것을 받았기 때문에 추상 메서드를 가지는 형태가 됨 = Human
    //추상 메서드를 일반 구현 메서드로 재정의하면 추상 메서드가 Human에서는 사라지게 됨

//    //추상 메서드 -> 구현 메서드로 재정의
//    @Override
//    public void hunt() {
//        System.out.println("사람이 도끼로 사냥을 합니다.");
//    }

    public static void main(String[] args) {
        //Animal animal = new Human();
        //animal.hunt();
        //Animal 직접 new 하지 못자으모 강제성을 발휘할 수 있다.
        //누군가의 실수를 막을 수 있음
    }
}//end of class
