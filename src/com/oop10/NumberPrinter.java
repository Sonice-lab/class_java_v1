package com.oop10;

public class NumberPrinter {
    int id; //식별자, 일반변수
    //static 예제
    //은행에서 번호표를 뽑는 상황
    //int waitNumber;//그냥은 멤버 변수에 static 추가 --> 추가하는 순간 대기 번호가 겹치지 않는다.
    //--> 인스턴스(객체)들이 공유할 수 있는 메모리 영역(static)
    static int waitNumber;//대기 번호(static 변수)

    //1. 생성자 생성
    public NumberPrinter(int id) {
        this.id = id;
        waitNumber = 1; //1을 초기값으로 가진다.
    }

    //2. 번호표 출력 가능
    public void printWaitNumber() {
        System.out.println(id + "번 기기의 대기 순번은: " + waitNumber);
        waitNumber++;
    }
}
