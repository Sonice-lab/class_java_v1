package ch05;

import java.io.FilterOutputStream;

/**
 * 조건 연산자(삼항 연산자)
 * 조건식 ? 결과1:결과2
 * 조건식에 결과값이 true이면 결과1 반환, 아니라면 결과 2를 반환
 */

public class Operation8 {

    //코드 실행의 시작점
    public static void main(String[] args) {
        int number = 6;  //7이라는 값이 홀수인지, 짝수인지 판별해보자.

        //조건식 ?
        char result1 = (number % 2 == 0) ? '짝' : '홀';
        System.out.println("result1: " + result1);

        boolean isOk = (5 > 3) ? true : false;
        System.out.println("isOk: " + isOk);

        // 두 수 중에(정수) 큰 수를 max라면 변수에 담아보세요.
        int max = (10 > 1) ? 10 : 1;
        System.out.println("max: " + max);

        int n1 = 500; //변수의 효용
        int n2 = 300;
        int max2;
        //n1과 n2값을 비교해서 더 큰수를 max2 변수에 담는 코드를 작성하시오.
        //단, 삼항 연산자를 사용
        max2 = (n1 > n2) ? n1 : n2;
        System.out.println(max2);

    } //end of main
}//end of class
