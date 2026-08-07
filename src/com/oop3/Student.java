package com.oop3;

public class Student {

    //필드, 클래스 영역에 선언된 변수를 좀 더 구체적으로는 멤버 변수라고 볼 수 있음.
    int studentId;
    String studentName;
    String address;

    //행위 - 공부하기, 휴식하기
    void study(){
        System.out.println(studentName + "(이)가 공부를 합니다.");
    }

    void breakTime(){
        System.out.println(studentName + "(이)가 휴식을 합니다.");
    }

    void showInfo(){
        System.out.println("----------상태창-----------");
        System.out.println("학생 ID: " + studentId);
        System.out.println("학생 이름: " + studentName);
        System.out.println("학생 주소: " + address);
    }

    void takeATest(){
        System.out.println(studentName + "(이)가 시험을 칩니다.");
    }

    void cleanTheRoom(){
        System.out.println(studentName + "(이)가 청소를 합니다.");
    }

}//end of class
