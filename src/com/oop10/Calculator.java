package com.oop10;

import java.util.Random;

public class Calculator {
    //static 메소드와 일반 인스턴스 메소드를 상황별로 언제 쓰는지를 고민해보자.

    //static 메소드(객체 생성 없이 클래스 이름, 메소드 이름() 사용 가능)
    //객체마다 결과가 달라질 이유가 없으므로, static 함수가 적합
    public static int add(int n1, int n2) {
        return n1 + n2;
    }
    // 일반 인스턴스 메소드
    //★객체를 생성해야 사용 가능 - 사실 static 메소드 함수로 만드는 것을 권장
    public int multiply(int n1, int n2){
        return n1 * n2;
    }
    //사실 우리는 이미 static을 사용하고 있었습니다!
    public static void main(String[] args){
        System.out.println("여기에서 별도로 main 함수 실행 가능");
        //클래스 이름.메서드 이름();
        //객체 생성 없이도 사용 가능
        //가능한 이유는 static 메모리 영역에 위치하기 때문
        Calculator.add(10, 10);

        //자바 표준 API 사용해보기 > static 메서드
        double ran = Math.random(); //1. 클래스이름.메소드라서 static 메소드이다.
                                   // 굳이 객체 생성이 필요 없음을 의미
                                    //random: 무작위
        System.out.println("ran: " + ran);
        //자바 표준 API - Random 사용해보기
        Random random = new Random();

        int ranInt = random.nextInt();//(-21억부터 21억까지)
        System.out.println("ranInt: " + ranInt);

        int lottoNumber1 = random.nextInt(45) + 1; //0~45까지 난수값 하나 발생시켜
        int lottoNumber2 = random.nextInt(2); //0~1까지 난수값 하나 발생시켜
        System.out.println(lottoNumber1);

    }//end of main
}//end of class
