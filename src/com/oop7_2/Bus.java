package com.oop7_2;

public class Bus {
    private int busNumber;
    int pay;

    public Bus (int n, int m){
        busNumber = n;
        pay = m;
    }

    //사람을 태울까?/말까?
    public boolean take(int money){
        if(pay < money){
            System.out.println("요금 부족, 탑승 금지");
            return false;
        }else{
            System.out.println("탑승 완료");
            return true;
        }
    }
}// end of class
