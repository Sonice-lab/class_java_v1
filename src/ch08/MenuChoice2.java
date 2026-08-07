package ch08;

import java.util.Scanner;

//도전과제. (코드 추가하거나 수정)
// 프로그램 종료시 사용자가 메뉴를 누른 횟수를 출력할 수 있게 코드를 수정해주세요.
// 메뉴를 몇 번 선택했습니다가 출력되도록
//1~4까지만 횟수 인정
//스스로 변수를 선언할 수 있는가?
//🌟 if를 활용하는 방법 실습해보기

public class MenuChoice2 {

    //코드 실행의 시작점
    public static void main(String[] args) {
        //준비물
        Scanner scanner = new Scanner(System.in);
        final int CREATE = 1;
        final int READ = 2;
        final int UPDATE = 3;
        final int DELETE = 4;
        final int END = 0;
        int count = 0;

        //1,2,3,4,0 <--상수 선언하고 활용
        //CRUD

        while (true) {
            System.out.println("\n메뉴선택");
            System.out.println("“1.등록 2.조회 3.수정 4.삭제 0.종료”");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            if (choice == CREATE) {
                count++;
                System.out.println("등록을 선택했습니다.");
            } else if (choice == READ) {
                count++;
                System.out.println("조회를 선택했습니다.");
            } else if (choice == UPDATE) {
                count++;
                System.out.println("수정을 선택했습니다.");
            } else if (choice == DELETE) {
                count++;
                System.out.println("삭제를 선택했습니다.");
            } else if (choice == END) {
                System.out.println(count + " 번 출력했습니다.");
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 선택해주세요");
            }
        } //end of while
        //  scanner.close();
    }//end of main
}//end of class


