package com.oop15;

public class UniversityMainTest {

    //코드의 시작점
    public static void main(String[] args) {
        //1. 교수 객체를 밖에서 먼저 생성한다.(독립적인 존재)
        Professor p1 = new Professor("이수진");
        Professor p2 = new Professor("함연경");

        //2. 대학을 설립하여 교수를 배정할 수 있다.
        University university1 = new University(5);
        university1.addProfessor(p1);
        university1.addProfessor(p2);
        university1.showInfo();

        System.out.println("----------대학교 폐교---------");
        university1 = null;

        //3. 대학교 객체를 가리키던 참조를 끊는다.
        //주의: 이 순간 객체가 사라지는 것은 아님! 다만, GC(Garbage Collector) 대상이 되어버림!
        //university1.showInfo(); //NullPointerException
        p1.display();
        p2.display();
    }
}
