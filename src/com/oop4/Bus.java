package com.oop4;

public class Bus {
    int busNumber;
    int money;

    //public Bus(){} <-- 기본 생성자

    //1. 사용자 정의 생성자
    public Bus(int n){
        busNumber = n;
    }
    // 2. 사용자 정의 생성자(복수로 만들 수 있음)
    public Bus(int n, int m ){
        busNumber = n;
        money = m;
    }

    public void showInfo(){
        System.out.println("----------상태창----------");
        System.out.println("버스번호: " + busNumber);
        System.out.println("수익금: " + money);
    }

    //생성자는 여러 개 만들 수 있음(생성자 오버로딩)
}
