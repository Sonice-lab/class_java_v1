package com.oop7_2;

public class Student {
    private String name;
    private int money;

    public Student(String n, int m) {//객체를 생성하는 동시에 초기화
        name = n;
        money = m;
    }

    //1. 버스를 타다.
    public void takeBus(Bus bus){
        //버스 요금과 현재 내 잔액 여부 확인 > 추후 구현
        if(money < bus.pay){
            System.out.println("버스를 탑승 못합니다.");
        }else{
            money -= bus.pay;
            bus.take(bus.pay);
        }
//        money -= 1000;
//        bus.take(1_000);
//        System.out.println("버스를 탔습니다.");
    }

    //2. 지하철을 타다.

    //3. 밥을 먹다.

    //4. 내 정보 표시
    public void showInfo(){
        System.out.println("이름: " + name);
        System.out.println("소지금: " + money);
    }


//    public void eat(Rice e) {
//
//    }
//
//    public void takeBus(Bus bus) {
//        money -= 1000;
//        bus.take(1000);
//    }
//
//    public void showInfo() {
//        System.out.println("----------상태창----------");
//        System.out.println("이름: " + name);
//        System.out.println("소지금: " + money);
//    }
//
//    public void takeSubway(Subway sb) {
//        money -= 1_500;
//        sb.take(1500);
//    }
}//end of class
