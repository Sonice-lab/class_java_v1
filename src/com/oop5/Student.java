package com.oop5;

public class Student {
    String name;
    int money;
    //★추후 구현해보기 [int energy; <-- 에너지가 +1 상승했습니다.]
    public Student(){}
    public Student(String n){
        name = n;
    }
    public Student(String n, int m){
        name = n;
        money = m;
    }
    //메서드 1. 학생이 버스를 탑니다.(동시에 버스비를 받는다.)
    void takeBus(Bus bus){//본인이 만든 버스 클래스도 인수로 넣을 수 있음
        //자기의 일을 직접 스스로 해결함
        bus.take(1000);
        money -= 1000;   //money = money - 1000;
    }
    //메서드 2. 학생이 지하철을 탄다.
    void takeSubway(Subway subway){
        subway.take(500);
        money -= 500;
    }
    //메서드 3. 학생이 밥을 먹는다.(남은 양이 없으면 밥을 못먹었습니다.)
    void eatRice(Rice rice){
        //rice.reduce(100); --> true or false
        if(rice.reduce(100)){
            System.out.println(name + "님" + rice.menu + "을 먹었습니다.");
        }else{
            System.out.println("밥을 다 먹었더나 양이 부족해서 먹질 못했습니다.");
        }
    }
    //정보창을 보여주는 기능
    void showInfo(){
        System.out.println(name + " 님의 현재 남은 금액: " + money);
    }
}
