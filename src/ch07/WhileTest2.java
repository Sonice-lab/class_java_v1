package ch07;

public class WhileTest2 {
    public static void main(String[] args) {
        // 특정 조건이 생길 때 반복문을 종료 시킬 수 있다.
        boolean flag = true;
        int start = 0;
        final int END = 50;

        while (flag){
            if(start == END){
                flag = false; //조건식을 변경하는 코드 생성
                              //만약 start 값이 50이라면 flag라면 변수에 접근해서 값을 false에 변경하게 됨
            }
            System.out.println("start: " + start);
            start++;
        } System.out.println("프로그램을 종료합니다.");

    } //end of main
}//end of class
