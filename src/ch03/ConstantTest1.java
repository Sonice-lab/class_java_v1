package ch03;

public class ConstantTest1 {
    // 코드 실행의 시작점
    public static void main(String[] args) {
        int num = 10;
        num = 101; // 수를 바꿀 수 있음
        // 상수 사용해보기
        //final 키워드를 사용하고 변수명에 이름을 작성할 때 대문자, _(언더바)를 사용하는 게 권장사항이다.
        final int MAX_NUM = 100; //final을 씀으로써 상수 처리됨 > 한 번 값이 정해지면 다시 변경할 수 없다.(상수)
        // MAX_NUM = 1;
        // 상수가 언제 필요한가? 상수 예시) 원주율, 날짜(1년 12개월)
        // 원주율을 상수로 선언해보자.
        final double PI = 3.14159;
        final int RADIUS = 5;
        //준비물:
        // 1. 원에 둘레를 계산해보자(계산 공식 찾아 보기) > C = 2*pi*r (여기서 C는 둘레, r은 반지름)
        // 2. 원에 면적을 계산해보자(계산 공식 찾아 보기)
        //    A(면적) = pi * r^2(r의 제곱)(여기서 pi는 약 3.14159, r은 원의 반지름)

        double permiter = 2 * PI * RADIUS;
        System.out.println("원의 둘레: " + permiter);  //+연산은 문자열을 만든다.

        double area = RADIUS * RADIUS * PI;
        System.out.println("원의 면적: " + area);

    } //end of main
} //end of class






