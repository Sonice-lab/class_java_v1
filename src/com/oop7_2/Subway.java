package com.oop7_2;

public class Subway {
    int line;
    int money;

    public Subway(int l, int m){
        line = l;
        money = m;
    }

    // 1호선에 사람을 태우다.
    public void take(int fee){
        money += fee;
    }
}
