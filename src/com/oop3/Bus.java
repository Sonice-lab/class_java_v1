package com.oop3;

public class Bus {
    //버스 클래스 설계
    //속성과 행위 설계
    //BusMainTest1(객체를 2개 이상 생성하고 결과 출력해보기)
    //버스의 멤버 변수
    //1. 속성을 생각해보자.
    //어른 어린이
    //버스 번호
    //탑승 수(현재)
    //최대 탑승 수
    //정거장(현재 정거장 위치)
    //결제 방법(카드, 현금)
    //현재 수익금
    //2. 행위를 생각해보자.
    // 카드를 찍게 하다.
    // 현금을 내게 하다.
    //승객을 태우다.
    //승객을 내려주다.
    //전진, 후진, 좌회전, 우회전

    String adultName;
    String childName;

    void card(){
        System.out.println(adultName + "(이)가 버스비를 카드로 계산합니다.");
    }

    void cash(){
        System.out.println(childName + "(이)가 버스비를 현금으로 계산합니다.");
    }
}//end of class
