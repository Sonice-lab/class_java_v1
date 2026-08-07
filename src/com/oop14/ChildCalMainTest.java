package com.oop14;

public class ChildCalMainTest {

    public static void main(String[] args) {
        ChildCal childCal = new ChildCal();

        System.out.println(childCal.sum(10,10));
        System.out.println(childCal.multiply(10,0)); //오버라이드된 메서드
        System.out.println(childCal.minus(100,1));

        // 상황 1) 코드 수정 요청이 들어옴
        //수정사항: 곱하기 기능에 n1과 n2에 0이 들어온다면, 0을 입력하지 마시오
        //메서드 실행 시 자식의 기능부터 실행시키며, 자식에 기능이 없으면 부모의 기능을 실행시킨다.

        //답) 메서드 오버라이드를 활용하여 부모클래스에게 물려받은 기능 수정

    }



}
