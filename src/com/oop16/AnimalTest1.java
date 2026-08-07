package com.oop16;

public class AnimalTest1 {

    //코드 시작의 시작점
    public static void main(String[] args) {

        //1. 자기 자신(여기서는 Animal) 타입으로 바라보기
        Animal animal1 = new Animal();
        animal1.move();
        animal1.eating();
        System.out.println("----------------------");

        //2. 부모 타입으로 자식 객체(자기 자신) 바라보기(업캐스팅) --> 다형성을 의미
        //상속으로 이어진 관계는 하나의 객체가 다양한 타입으로 바라볼 수 있다. ---> 다형성
        //Animal animal2 = (Animal) new Human(); // 괄호가 없어도 자동 형변환 가능 --> 업캐스팅(괄호 생략 가능)
                                                //ClassCastException
        Animal animal2 = (Animal) new Tiger();
        animal2.move(); //재정의
        animal2.eating(); //재정의x  --> Animal의 eatting이 호출됨
        //4.1 다운캐스팅 작성해보기
        Tiger tiger = (Tiger) animal2; //컴파일러야 괜찮아! 강제 형변환할거야! --> Tiger의 메서드인 Hunting을 호출할 수 있다.
        tiger.hunting();

        System.out.println("----------------------");

        //2.1 부모 타입으로 자식 객체 바라보기(업캐스팅)
        Animal animal3 = new Human();
        animal3.move(); //재정의
        animal3.eating(); //재정의

        //3. 문제 확인
        //Human 객체에는 readBook()메서드가 호출 될까? >
        //animal3.readBook() <-- 에러 발생: 실제 객체 Human이 맞지만 컴파일 시점에 readBook()을 호출할 수 없음!
        //                               : 이유! 현재 부모타입으로 바라보고 있기 때문
        //핵심 - 컴파일 시점에는 타입만 바라보고, 런 타임 시점에는 실제 동작하는 객체에 행위가 실행되기 때문

        //4. 업캐스팅과 다운 캐스팅
        //업캐스팅 예시
        // Animal animal2 = (Animal) new Tiger(); // 괄호가 없어도 자동 형변환 가능 --> 업캐스팅(괄호 생략 가능)

    } //end of main
}// end of class
