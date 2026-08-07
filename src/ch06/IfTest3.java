package ch06;

public class IfTest3 {
    public static void main(String[] args) {
        // if else if else 구문 = 주어진 조건이 여러 개 일 때 많이 사용한다.

        int age = 28;

        if (age <= 7) {
            System.out.println("학교에 아직 안다님");
        } else if (age <= 13) {
            System.out.println("초등학생");
        } else if (age <= 16) {
            System.out.println("중학생");
        } else if (age <= 19) {
            System.out.println("고등학생");
        } else {
            //그외...
            System.out.println("성인입니다.");
        }

        System.out.println("프로그램 종료");

    }//end of main
}//end of class
