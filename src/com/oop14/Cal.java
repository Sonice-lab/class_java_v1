package com.oop14;

public class Cal {

    public int sum(int n1, int n2) {
        return n1 + n2;
    }

    public int multiply(int n1, int n2) {
        return n1 * n2;
    }
}//end of class

// xxx.java 하나의 자바 파일에 여러 개의 클래스를 사실 선언할 수 있다.(단, 권장하지 않음)
//주의!: 단, 하나의 자바 파일에는 오직 public 클래스는 하나만 선언할 수 있다. --> 문법 약속
//부모 클래스의 기능까지 더해지니, 자식 클래스의 기능이 더 많을 것으로 봐야함
class ChildCal extends Cal {//앞에 public을 붙일 경우, 오류 발생! 이미 public클래스가 있기 때문!

    //-메서드 재정의
    public int minus(int n1, int n2) {
        return n1 - n2;
    }

    //부모 클래스의 메서드를 재정의할 수 있다. --> @Override의 개념(상속 관계에서 사용)
    @Override //어노테이션 --> 컴파일러에게 알려주는 주석
    public int multiply(int n1, int n2) {//선언부는 같아야함
        System.out.println("Child에 multiply() 호출");
        if(n1 == 0 || n2 == 0){
            System.out.println("0으로 입력하지 마세요.");
        }
        return n1 * n2;
    }


}//end of class