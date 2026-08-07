package ch01;

/**
 * 복습: 변수란 값을 담을 수 있는 메모리 상자를 의미함
 * 규칙 1: 변수에 선언
 * 규칙 2: 변수에 값을 대입
 * 규칙 3: 변수에 접근하는 방법을 알아야 함(이름을 알아야 함)
 *
 */
public class Variable2 {

    // 메인 함수(실행의 시작점)
    public static void main(String[] args) {

        //변수를 만들 때 규칙이 있습니다.
        // 1. 변수 선언시 대소문자를 명확히 구분하며 길이에 제한이 없다.
        int age = 10; // 변수에 선언과 동시에 초기화(값을 넣다.)
        // int age = 10; > 선언불가 > 같은 중괄호{} 영역 안에서는 동일한 변수를 사용(선언)할 수 없다.
        int aGe = 10; // 선언 가능
        int aGE = 10; // 선언 가능

        //2. 자바에서 사용하는 예약어는 사용할 수 없다.
        // int, double, for, while, list ... 미리 선점되어있는 단어(예약어)는 변수로 사용할 수 없음
        // 예시) int for; <-- 오류 발생

        //3. 특수문자는 _(언더바), $(달러) 표기만 사용 가능
        int _count;
        int $count;
        int $_tel;
        int tel_count_$age;
        //int *count; > *는 변수 선언 시 사용 불가


    } //end of main

} //end of class
