package ch03;

public class ConstantTest3 {
    // 코드 실행의 시작점
    public static void main(String[] args) {
       // 도전 과제 - 사각형의 면적을 구하는 코드를 작성하여 값을 화면에 출력해보세요.(단, 상수 활용)

        // 상수 선언 1 final과 대문자
        final int WIDTH = 5;

        //상수 선언 2
        final int HEIGHT = 2; //2와 같이 값 자체를 의미하는 것 = 리터럴이라고 함, JVM 안에 저장되어 있음

        // 사각형 면적 계산 3
        int result = WIDTH * HEIGHT;

        // 결과 출력 4
        System.out.println("사각형 면적: " + result);


    } //end of main
} //end of class

