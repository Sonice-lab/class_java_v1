package com.oop4;

public class MainTest2 {
    //Bus class의 사용자 정의 생성자 2개를 이용해서 객체를 메모리에 직접 올려보자.
    public static void main(String[] args) {
        Bus bus1 = new Bus(101);
        Bus bus2 = new Bus(111, 0 );
    //생성자가 2개 이상 존재한다면, 생성자 오버로딩이라고 함
        bus1.showInfo();
        bus2.showInfo();
    }
}


