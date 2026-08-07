package com.oop1;

public class StudentMainTest1 {

    //코드 실행의 시작점(메인 함수)
    public static void main(String[] args) {

        //내가 설계한 클래스를 메모리에 직접 올려보자!
        //JVM (자바 가상 머신) 메모에 올릴 수 있다.
        Student s1 = new Student(); // 객체 생성: 클래스를 메모리에 올려라 (인스턴스화 했다.)
        Student s2 = new Student(); //

        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);

        int grade = 10;
        double height = 1.1;

        System.out.println("grade: " + grade);
        System.out.println("height: " + height);

        //자바의 변수는 가장 크게 변수
        // 기본 변수: 실제 값이 담겨진다.
        // 참조 변수: 변수에 실제 값이 아니라 주소 값이 담긴다.

    }// end of main
}//end of class
