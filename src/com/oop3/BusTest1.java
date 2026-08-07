package com.oop3;

public class BusTest1 {
    public static void main(String[] args) {
        //1. 객체 생성
        Bus adult1 = new Bus();
        Bus child1 = new Bus();

        //2. 참조 변수를 사용해서 객체에 접근하고 값 할당
        adult1.adultName = "예지";
        child1.childName = "슬기";

        //3. 생성된 객체의 동작을 호출
        adult1.card();
        child1.cash();
    }//end of main
}//end of class

