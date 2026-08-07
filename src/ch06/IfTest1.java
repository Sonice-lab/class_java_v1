package ch06;

public class IfTest1 {
    //코드 실행의 시작점
    public static void main(String[] args) {
        //만약 ... 이라면 --> if, if else, if else if else
        //주어진 조건에 따라서 실행이 다르게 이루어지도록 구현할 수 있음
        boolean flag = true; //변수의 효용
        // 단독 if 구문
        if (flag) {
            //수행구문
            System.out.println("주어진 식이 true이면 실행됨");
        } //end of if
        System.out.println("프로그램을 종료합니다.");
        //중요!
        //단독 if 구문은 수행 구문이 실행될 수도 있고, 안될 수도 있다.
    } //end of main
}//end of class
