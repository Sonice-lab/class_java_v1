package io.ch02;

import java.io.IOException;

public class KeyboardInputTest2 {
    public static void main(String[] args) throws IOException {
        //in - 한번에 여러 데이터를 받을 수 있는 기능을 구현(Scanner <--- 대신 표준 입출력 사용)
        System.out.println("알파벳 여러개를 쓰고 enter를 누르세요.");

        int i;
        //'\n' -> enter을 의미
        while ((i = System.in.read()) != '\n') {
//            System.out.println("i: " + i);
//            System.out.println("문자로 변환: " + (char) i);
//            System.out.println("받은 결과: " + (char)i);
            System.out.print((char)i); //dslkjgfhndksjghnkj -> 스캐너를 활용하지 않고도 처리할 수 있는 시스템을 구현할 수 있다.
        }
    }
}
