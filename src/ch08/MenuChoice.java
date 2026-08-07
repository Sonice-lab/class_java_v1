package ch08;

import java.util.Scanner;

/**
 * - 사용자에게 다음 옵션을 보여주고 선택하도록 요청합니다
 * <p>
 * “1.등록 2.조회 3.수정 4.삭제 0.종료”
 * <p>
 * - 사용자가 옵션 번호를 입력하면, 해당 옵션에 대한 메시지를 출력합니다. 예를 들어, 사용자가 '1'을 선택하면 "등록을 선택했습니다."라고 출력합니다.
 * - 사용자가 '0'을 선택하면 "프로그램을 종료합니다."라는 메시지를 출력하고 프로그램을 종료합니다.
 * - 사용자가 유효하지 않은 번호를 입력하면 "**잘못된 입력입니다. 다시 선택해주세요**."라고 안내하고 다시 메뉴 선택을 할 수 있도록 합니다.
 * - Scanner, while 그리고 if 구문을 활용해서 프로그램을 완성하세요.
 */

public class MenuChoice {

    //코드 실행의 시작점
    public static void main(String[] args) {
        //준비물
        Scanner scanner = new Scanner(System.in);
        final int CREATE = 1;
        final int READ = 2;
        final int UPDATE = 3;
        final int DELETE = 4;
        final int END = 0;

        //1,2,3,4,0 <--상수 선언하고 활용
        //CRUD

        while (true) {
            System.out.println("\n메뉴선택");
            System.out.println("“1.등록 2.조회 3.수정 4.삭제 0.종료”");
            System.out.print("선택: ");
            int choice = scanner.nextInt();

            if (choice == CREATE) {
                System.out.println("등록을 선택했습니다.");
            } else if (choice == READ) {
                System.out.println("조회를 선택했습니다.");
            } else if (choice == UPDATE) {
                System.out.println("수정을 선택했습니다.");
            } else if (choice == DELETE) {
                System.out.println("삭제를 선택했습니다.");
            } else if (choice == END) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 선택해주세요");
            }
        } //end of while
        scanner.close();
    }//end of main
}//end of class


