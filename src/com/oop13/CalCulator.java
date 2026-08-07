package com.oop13;


// 메서드 오버로딩: 같은 이름의 메서드를 여러개 정의하는 것을 의미한다.

public class CalCulator {

    // 정수형 덧셈 메서드 --> 정수를 호출한다면 얘를 호출하는 것을 컴파일러는 알 수 있다!
    public int add(int a, int b) {
        return a + b;
    }

    //실수형 덧셈 메서드 --> 실수를 호출한다면 얘를 호출하는 것을 컴파일러는 알 수 있다!
    public double add(double a, double b) {
        return a + b;
    }

    // 세 정수의 덧셈 메서드
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    //main 함수의 시작점
    //클래스 이름.으로 접근하는 것 static 변수
    public static void main(String[] args) {

        //println 또한 메서드 오버로딩 기법(println에 커서를 두고 Ctrl + 좌클릭해서 오버로딩된 메서드 내역 확인 가능)
        System.out.println(1);
        System.out.println(1.0);
        System.out.println(true);
        System.out.println("String");
        System.out.println(1.0 + "String"); //문자열로 인식하여 출력

        //메서드 오버로딩 기법이 없다면 아래와 같이 매번 호출했어야함!
        // printlnInt()
        // printlnIDouble()
        // printlnBoolean()
        // printlnString()


    }//end of main

}//end of class
