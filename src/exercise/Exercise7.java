package exercise;

import java.util.Scanner;

public class Exercise7 {

    //함수만들기 1

    /**
     * **인사말 출력하기**
     * <p>
     * - 함수 이름: **`greet`**
     * - 입력: 이름(String)
     * - 출력: 없음 (콘솔에 직접 출력)
     * - 설명: 사용자의 이름을 입력받아 "안녕하세요, [이름]님!"이라고 콘솔에 출력하는 함수입니다.
     */
    static void greet(String greeting) {
        System.out.println("안녕하세요. [ " + greeting + " ] 님!");
    }
    //함수만들기 2

    /**
     * **제곱 계산하기**
     * <p>
     * - 함수 이름: **`square`**
     * - 입력: 정수(int)
     * - 출력: 입력된 수의 제곱(int)
     * - 설명: 하나의 정수를 입력받아 그 수의 제곱을 반환하는 함수입니다.
     */
    static int square(int a) {

        return a * a;
    }
    //함수만들기 3

    /**
     * **수의 부호 판별**
     * <p>
     * ( 입력값이 0 —> “ZERO” , 1 —>  “positive” , - 1  → “negative”)
     * <p>
     * - 함수 이름: **`signOfNumber`**
     * - 입력: 정수(int)
     * - 출력: 문자열(String) - "positive", "negative", "zero"
     * - 설명: 입력받은 정수의 부호에 따라 "positive", "negative", "zero" 중 하나를 반환합니다.
     */

    static String signOfNumber(int i) {
        if (i > 0) {
            return "positive";
        } else if (i < 0) {
            return "negative";
        } else {
            return "zero";
        }
    }

    //함수만들기 4

    /**
     * **나이 확인**
     * <p>
     * //     * - 함수 이름: **`checkAdult`**
     * //     * - 입력: 나이(int)
     * //     * - 출력: 성인 여부(Boolean)
     * //     * - 설명: 입력받은 나이가 18세 이상인지 확인하여 성인이면 **`true`**, 아니면 **`false`**를 반환합니다.
     * //
     */
//
    static boolean checkAdult(int age) {
        return age >= 18;
    }

    //함수만들기 5

    /**
     * **최대값 찾기 함수**
     * <p>
     * - 함수 이름: **`findMax`**
     * - 입력: 정수 배열
     * - 출력: 입력 받은 값 중 가장 큰 수
     * - 설명: 입력받은 두 수중에서 가장 큰 값을 반환하는 함수를 작성하세요.
     */
    static int findMax(int b, int c) {
        if (b > c) {
            return b;
        } else {
            return c;
        }
    }


    //끝에 main 메서드 만들기
    public static void main(String[] args) {
        greet("예솔");
        System.out.println(square(3));
        System.out.println(signOfNumber(-1));
        System.out.println(checkAdult(18));
        System.out.println(findMax(30, 20));

    }//end of main
}//end of class
