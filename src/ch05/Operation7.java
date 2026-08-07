package ch05;

/**
 * 빠른 평가란?
 * 논리 연산에서 첫 번째 조건이 결과를 결정하는 경우
 * 두번쨰 조건을 평가하지 않는 것
 */
public class Operation7 {

    // 코드 실행의 시작점
    public static void main(String[] args) {

        int number = 5; //변수 선언과 동시에 초기화
        int index = 0;

        //논리곱(&&)을 사용한 빠른 평가
        //첫번째 조건이 false 였기 때문에 논리곱에서는 두번째 조건은 아예 평가되지않는다. <- 빠른 평가의 개념
        //boolean result = ((number = number + 10) < 10) && ((index = index + 2) < 10);
        boolean result = ((number += 10) < 10) && ((index += 2) < 10);
        System.out.println("number: " + number);
        System.out.println("index: " + index);
        System.out.println("논리곱 결과 확인: " + result);

        System.out.println("------------------------------------------");

        //논리합을 사용한 빠른 평가 확인
        //number는 위에서 연산을 했기 때문에 현재 15이다.
        //index는 위에서 빠른 평가로 진행했기 때문에 현재 0이다.
        //                            25 < 10 --> false                     2 < 10 --> true
        //                                  F            ||      T --> T
        boolean result2 = ((number += 10) < 10) || ((index += 2) < 10); //빠른 평가가 진행되지 않음
        System.out.println("result2: " + result2);
        System.out.println("number: " + number);
        System.out.println("index: " + index);

        // 문제 1.
        //빠른 평가 수식을 스스로 만들어보고 결과를 확인하는 코드를 작성해보세요.
        int n1 = 1;
        int n2 = 5;

        boolean result3 = ((n1 + n1) < 0) && ((n2 + 10) < 14);
        System.out.println(result3);

        boolean result4 = ((n1+n2 > 8)) || ((n1-n2 < 0));
        System.out.println(result4);

    }//end of main
}//end of class
