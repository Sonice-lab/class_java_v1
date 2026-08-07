package ch08;
//수입하다. 가지고 오다.
import java.util.Scanner;

public class MenuChoice4 {

    //코드 실행의 시작점
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //스캐너 활용 - 문자열로 값받기(키보드에서)
        int menuNumber = sc.nextInt();
        // nextInt는 정수값만 가지고가고 개행 문자를 남겨둔다.
        // 남겨진 개행문자 \n을 소비해주면 됨
         //개행 문자 소비
        String name = sc.nextLine(); //🌟문자열 받기

        System.out.println("menuNumber: " + menuNumber);
        System.out.println("name: " + name);
    }//end of main
}//end of class


