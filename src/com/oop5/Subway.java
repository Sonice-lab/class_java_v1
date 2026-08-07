package com.oop5;

public class Subway {
    int lineNumber; //1,2호선
    int count;
    int money;
    //1. 생성자
    public Subway(int line) {
        lineNumber = line;
    }
    //2. 승객을 태운다.(태우는 동시에 지하철 요금을 받는다.)
    void take(int pay) {
        money += pay;
        count++;
    }
    //3. 정보 보기
    void showInfo() {
        System.out.println("현재" + lineNumber + "호선");
        System.out.println("현재 승객수: " + count);
        System.out.println("현재 수익금: " + money);
    }
}


