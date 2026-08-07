package com.oop18;
//추상적인 개념이 필요할 때 추상 메서드를 이용한다.
public class Person extends Human{
    //오류 해결,  Person을 일반 구현 클래스로 만들어주세요.

    @Override
    public void hunt() {
        System.out.println("사람이 도끼로 사냥을 합니다.");
    }

    public static void main(String[] args) {
        Animal animal = new Person(); //다형성 human타입, animal타입으로 바라볼 수 있는 person
        animal.hunt();
    }
}

