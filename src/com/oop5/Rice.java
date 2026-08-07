package com.oop5;

public class Rice {
    String menu;
    int amount; //남은 양

    public Rice(String m, int a){
        menu = m;
        amount = a;
    }

    //1. 밥을 먹는다.(먹는 동시에 양이 줄어든다.), 밥을 스푼으로 뜬다.
    // 먹은 만큼 줄어든다.성공하면 true 반환, 실패하면 false 반환 리턴 값 설계
    boolean reduce(int eatAmount){
        if(amount >= eatAmount){
            amount = amount - eatAmount;
            return true;
        }else{
            return false;
        }
    }

    //showInfo
    void showInfo(){
        System.out.println("메뉴: " + menu);
        System.out.println("메뉴: " + amount + "g" );
    }
}


