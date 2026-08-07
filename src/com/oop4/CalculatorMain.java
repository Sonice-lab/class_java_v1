package com.oop4;

public class CalculatorMain {

    // 두 숫자를 더하는 함수
    static int add(int n1, int n2) {
//        int result = n1 + n2;
//        return result;
        return n1 + n2;
    }

    // 두 숫자를 빼는 함수
    static int sub(int n3, int n4) {
//        int result1 = n3 - n4;
//        return result1;
        return n3 - n4;
    }

    // 두 숫자를 곱하는 함수
    static int square(int n5, int n6) {
//        int result2 = n5 * n6;
//        return result2;
        return n5 * n6;
    }

    // 두 숫자를 나누는 함수
    static double divide(int a, int b) {
//        int result3 = n7 / n8;
//        return result3;
        //방어적 코드를 잘 작성해야함(예외처리)
        if (b == 0) {
            System.out.println("0으로 나눌 수 없습니다.");
            return 0;//제어권 반납
        }
        //정수 / 정수를 해버리면 소수점이 버려짐.
        // 정확한 결과값을 위해 a와 b 둘 중 하나라도 실수 데이터 타입이어야 함
        return (double) a / b;
    }

    //짝수인지 판별하는 함수
    static boolean isEven(int number) {
        return number % 2 == 0;
    }

    //홀수인지 판별하는 함수
    static boolean isOdd(int number) {
        return number % 2 == 1;
    }


    //위 함수를 설계하고 테스트 코드 작성
    public static void main(String[] args) {
        //함수1
        System.out.println(add(5, 6));
        //함수2
        System.out.println(sub(7, 2));
        //함수3
        System.out.println(square(5, 6));
        //함수4
        System.out.println(divide(7, 3));
        //함수5
        System.out.println(isEven(8));
        //함수6
        System.out.println(isOdd(9));

    } //end of main


}//end of class
