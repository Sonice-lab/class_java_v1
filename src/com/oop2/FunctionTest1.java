package com.oop2;

public class FunctionTest1 {

    //함수를 설계해보자.
    // 두 개의 숫자를 받아서 더한 결과값을 반환하는 프로그램을 만들기
    // 두 개의 정수값을 인풋 값으로 받아서 덧셈을 하고, 그 결과를 반환하는 일련의 작업 묶음
    static int add(int n1, int n2) { //함수의 선언부
        int result; //함수 안에서 변수 선언 > 지역 변수
        result = n1 + n2;
        // return <-- 값을 반환한다.
        return result; //실행의 제어권 반납
    }//함수의 몸체

    //2. 함수 사용하기(모양맞추기)
    //코드 실행의 시작점(메인 함수)
    public static void main(String[] args) {
        System.out.println("내가 설계한 함수를 사용해보자.");
        //함수 이름 호출 그리고 모양 맞추기
        int result1 = add(10, 20);
        System.out.println("result1: " + result1);
    }
}//end of class
