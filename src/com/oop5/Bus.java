package com.oop5;

public class Bus {
    int busNumber;
    int count; //0으로 초기화됨
    int money; //0으로 초기화됨
    //★예시 1: double d; //0.0으로 초기화됨
    //★예시 2: boolean f; //false로 초기화됨

    //멤버 변수를 생성자를 통해서 초기화하지 않는다면 생성자가 호출된 후에 자동으로 기본값을 가진다.
    public Bus(int number){
        busNumber = number; //필요한 부분만 초기화
    }
    //사람을 태우다.
    void take(int pay){
        money += pay; //money = money + pay;
        count++;
    }
    //현재 버스의 상태를 보여주는 메서드
    void showInfo(){
        System.out.println("버스 번호: " + busNumber);
        System.out.println("현재 승객 수: " + count);
        System.out.println("현재 수익 금액: " + money);
    }
}


