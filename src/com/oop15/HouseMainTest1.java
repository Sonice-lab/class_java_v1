package com.oop15;

public class HouseMainTest1 {
    public static void main(String[] args) {
        House house = new House("부산시 진구");
        house.showInfo();

        house = null;
        //CG의 대상은 House와 Room 둘다 제거의 대상이 된다.

    }//end of main
}//end of class
