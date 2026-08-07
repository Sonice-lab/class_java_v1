package com.oop1;

public class WarriorMainTest {

    //코드 실행의 진입점(메인 함수) - JVM - Stack(메모리)
    public static void main(String[] args) {
        // new - 키워드, Warrior() <- 생성자 호출
        //객체를 생성하지 않았는데 실행할 경우, 가리키는 객체가 없기 때문에 오류가 발생
        Warrior w1 = new Warrior();//w1 인스턴스
        //해당하는 객체에 접근해서 값넣기
        //참조 변수 호출하기(참조변수.)

        w1.name = "티모";
        w1.height = 10.5;
        w1.health = 100;
        w1.attackPower = 70;
        w1.defensePower = 30;

        //w1 참조 변수에 접근해서 값을 할당해보자.
        //객체의 접근은 . 연산자로 할 수 있다.

        System.out.println("w1 주소 값: " + w1); //heap메모리의 위치(주소값)
        System.out.println("w1 name: " + w1.name);
        System.out.println("w1 height: " + w1.height);
        System.out.println("w1 health: " + w1.health);
        System.out.println("w1 attackPower: " + w1.attackPower);
        System.out.println("w1 defensePower: " + w1.defensePower);

        System.out.println("-------------------------------------------------");

        //Warrior 타입에 객체를 생성해서 해당하는 상태 값을 입력하고 화면에 출력하세요.
        Warrior w2 = new Warrior(); // row2 객체 생성

        w2.name = "스티키";
        w2.health = 50;
        w2.attackPower = 90;
        w2.defensePower = 5;
        w2.height = 5.5;

        System.out.println("w2 주소값: " + w2);
        System.out.println("w2 name: " + w2.name);
        System.out.println("w2 health: " + w2.height);
        System.out.println("w2 attackPower: " + w2.attackPower);
        System.out.println("w2 defensePower: " + w2.defensePower);
        System.out.println("w2 height: " + w2.height);

    }//end of main

}// end of class

//Warrior w1; //Warrior 변수 선언
