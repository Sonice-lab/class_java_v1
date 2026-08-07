package com.oop2;

public class FunctionTest2 {

    // 문제 1. 세개의 수를 입력받아 뺄셈하는 함수를 설계하고 그 값을 반환하는 함수를 만들어보자.
    static int sub(int a, int b, int c) {
        int result = a - b - c;
        return result; //실행의 제어권을 반납 > 메인 함수로 돌아감
    }

    // 문제 2. 리턴 키워드가 없는 함수를 만들어보자.
    //void <- 텅빈, 값이 없는
    static void sayHello(String greeting) {
        System.out.println("[[[ " + greeting + "]]] ~~~ 😆😆😆");
    }

    // 문제 3. 매개 변수가 없는 함수를 설계해보자.
    static int calcSum() {
        //지역 변수는 항상 초기화 값을 먼저 할당해야 오류가 나지 않음
        int sum = 0;
        int i;

        for (i = 1; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }

    // 4. 맨 마지막에 메인 함수 설계
    //코드의 시작점(메인 함수) JVM - stack에 할당됨
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        //인수: 함수 호출 시 들어가는 함수
        int result1 = sub(num1, num2, 10);
        sayHello("안녕, 함수야! 반가워!"); //문제 2에 대한 결과(1)
        sayHello("안녕, 홍길동! 반가워!"); //문제 2에 대한 결과(2)
        int result2 = calcSum(); //매개 변수에는 아무것도 안 넣는 것으로 설계되어있음

        System.out.println("result1: " + result1);// 문제 1에 대한 결과 출력
        System.out.println("result2: " + result2);// 문제 3에 대한 결과 출력

    }//end of main
}//end of class
