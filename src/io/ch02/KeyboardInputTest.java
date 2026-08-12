package io.ch02;

import java.io.IOException;

public class KeyboardInputTest {
    public static void main(String[] args) throws IOException {
        //표준 입출력 - 아무것도 구현하지 않아도 활용 가능!
        //1. 표준 출력 스트림
        //데이터 타입: out -> OutputStream -> println()
        System.out.println("문자를 입력하세요.");//표준 출력 시스템

        //1. 표준 입력 스트림 - InputStream(키보드) 1바이트씩 데이터를 읽어들임
        //왜 반환값이 바이트가 아니라 int 값일까? > 내부적인 이유! 더 명확하게 표시하기 위함
        int keyCode = System.in.read(); //예외 처리를 던져버림

        System.out.println("반환된 정수값: " + keyCode);
        System.out.println("문자로 변환(char): " + (char)keyCode); //1바이트만 표현 가능하기 때문에 3바이트인 문자가 깨져서 출력

        System.err.println("한글은 깨져서 표준 입출력만으로는 처리가 힘습니다.");

    }//end of main
}
