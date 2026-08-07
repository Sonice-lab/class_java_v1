package com.oop7;

public class Bus {
    int busNumber;
    int money;

    public Bus (int b, int m){
        busNumber = b;
        money = m;
    }

    //사람을 태우다.
    public void take(int fee){
        money += fee;
    }
}// end of class


