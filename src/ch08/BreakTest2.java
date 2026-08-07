package ch08;

public class BreakTest2 {
    public static void main(String[] args) {

        //문제 1. 1부터 100까지 화면에 출력
        //문제 2. 3의 배수만 화면에 출력하시오
        //문제 3. 50 이상이면 반복문을 종료 시키세요.
        //문제 4. for 구문으로 코드 작성
        int i = 1;
        int j = 100;

//        while (i <= j) {
//
//            if (i >= 50) {
//                break;
//            }
//
//            if (i % 3 == 0) {
//                System.out.println(i);
//            }
//            i++;
//        }

        for (i = 3; i <= 100; i++) {
            if (i >= 50) {
                break;
            }
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }

    }//end of main
}//end of class
