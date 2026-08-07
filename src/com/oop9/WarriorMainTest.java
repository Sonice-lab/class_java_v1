package com.oop9;

public class WarriorMainTest {
    public static void main(String[] args) {
        //Warrior의 멤버 변수의 접근 제어 지시자는 private라 여기서 접근 불가능!
        //그렇다면 외부에서 필요하다면 값을 확인할 수 있는 방법은? 특히 값만!
        //값만 리턴받고 싶다!
        // --> 이 때, getter, setter 메서드를 사용해서
        //외부사용자가 활용해서 쓸 수 있도록 설계할 수 있다.
        Warrior w1 = new Warrior("광폭전사");
        Warrior w2 = new Warrior("일반전사");

        //필요에 의해서 멤버 변수 상태값을 변경해보자.
        //객체의 상태 변경 및 행위(메서드)를 통해서 변경해야 한다.
        //get, set 메서드 사용해보기
        w1.setHp(-1000);
        w1.setLevel(-2); //방어적 코드를 작성해주는 개념에 대한 테스트
        w1.setName("작은전사");
        System.out.println("-------------------------");
        System.out.println(w1.getHp());
        System.out.println(w1.getLevel());
        System.out.println(w1.getName());


    }//end of main
}//end of class

