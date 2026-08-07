package ch08;

import java.awt.*;
import java.util.Scanner;

/**
 * - 다음 코드에서 잘못된 입력을 3번 이상 입력시 강제 종료
 * - 단, 3회 이전에 제대로 된 메뉴를 눌렀다면 다시 0으로 초기화되어야 함
 */

public class MenuChoice3 {

    //코드 실행의 시작점
    public static void main(String[] args) {
        //준비물
        Scanner scanner = new Scanner(System.in);
        final int CREATE = 1;
        final int READ = 2;
        final int UPDATE = 3;
        final int DELETE = 4;
        final int END = 0;
        int errorCount = 0;

        //1,2,3,4,0 <--상수 선언하고 활용
        //CRUD

        while (true) {
            System.out.println("\n메뉴선택");
            System.out.println("“1.등록 2.조회 3.수정 4.삭제 0.종료”");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            //만약, 잘못된 입력 값이 아니라면, errorCount를 0으로 초기화해라.
            if (choice >= 1 && choice <= 4) {
                errorCount = 0;
            }

            if (choice == CREATE) {
                System.out.println("등록을 선택했습니다.");
                //   errorCount = 0;
            } else if (choice == READ) {
                System.out.println("조회를 선택했습니다.");
                //   errorCount = 0;
            } else if (choice == UPDATE) {
                System.out.println("수정을 선택했습니다.");
                //   errorCount = 0;
            } else if (choice == DELETE) {
                System.out.println("삭제를 선택했습니다.");
                //    errorCount = 0;
            } else if (choice == END) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                errorCount++;
                System.out.println("잘못된 입력입니다. 다시 선택해주세요");

                if (errorCount >= 3) {
                    System.out.println("3회 잘못 입력! 강제종료합니다.");
                    break;
                }
            }
        } //end of while
        scanner.close();
    }//end of main
}//end of class


