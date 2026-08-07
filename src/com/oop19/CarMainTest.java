package com.oop19;
//실행의 흐름을 만들때 템플릿 메서드를 설계할 수 있다.
public class CarMainTest {
    public static void main(String[] args) {

        Car car1 = new AICar();
        Car car2 = new ManualCar();

        car1.run();//실행의 흐름이 정해져있음
        System.out.println("------------------------------------");
        car2.run();//실행의 흐음이 정해져있음

    }//end of main
}//end of class
