package com.oop14;

public class CMainTest {
    public static void main(String[] args) {
        C c = new C();

        //물려받기는 하지만 접근 제어 지시자에 따라서 접근을 할 수있거나 못할 수 있음
        //부모 클래스인 A클래스의 속성을 private 처리했을 때 오류가 발생
        //부모 클래스인 A클래스의 속성을 protected로 처리했을 때 오류가 발생하지 않는다.
        //protected 처리되었을 경우, 자식 클래스가 상속받았기 때문에 접근 가능
        c.age = 10;// A의 기능도 물려 받았기 때문에 A의 기능도 사용할 수 있다.
        c.height = 100;
        c.weight = 200;

        c.level = 1;
        c.nickName = "C";

        System.out.println(c.age);
        System.out.println(c.height);
        System.out.println(c.weight);

    }//end of main
}//end of class
