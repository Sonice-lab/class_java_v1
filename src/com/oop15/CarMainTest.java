package com.oop15;

public class CarMainTest {

    public static void main(String[] args) {
        Car car = new Car("BMW");
        car.start();
        System.out.println("------------------");
        car.stop();

        //밖에서는 Engine 객체의 접근할 방법이 없다.
        //Car와 Engine의 관계를 합성 관계라고 말할 수 있다.

    }//end of main
}//end of class

