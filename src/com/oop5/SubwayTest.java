package com.oop5;

//객체를 사용하고 실행해보는 테스트 측 코드
public class SubwayTest {
    public static void main(String[] args) {
        //1. 객체를 불러오자.
        Subway line1 = new Subway(1);

        //2. 1호선에 사람을 태워보자.
        line1.take(1500);

        //3. 화면에 띄워보자.
        line1.showInfo();
    }
}


