package ch08;

import java.util.Scanner;

public class MenuChoice6 {

    //코드 실행의 시작점
    public static void main(String[] args) {
        //준비물
        Scanner scanner = new Scanner(System.in);
        final int CREATE = 1;
        final int READ = 2;
        final int UPDATE = 3;
        final int DELETE = 4;
        final int END = 0;
        String name = "";// 빈문자열
        boolean isResistered = false;

        //1,2,3,4,0 <--상수 선언하고 활용
        //CRUD

        while (true) {
            System.out.println("\n메뉴선택");
            System.out.println("“1.등록 2.조회 3.수정 4.삭제 0.종료”");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); //개행 문자 소비

            if (choice == CREATE) {
                if (isResistered) {
                    System.out.println("이미 등록된 데이터가 있습니다.: " + name);
                } else
                //만약 name에 등록된 값이 있다면, '이미 등록되어있습니다.'를 출력.
                //name이라는 변수에 스캐너를 사용해서 이름을 등록하는 기능을 구현
                System.out.print("이름을 입력하세요.: " + name);
                name = scanner.nextLine();
                isResistered = true;
                System.out.println(name + "이 성공적으로 저장되었습니다!");
            } else if (choice == READ) {
                if (isResistered) {
                    System.out.println("조회 결과: " + name);
                } else {
                    System.out.println("등록된 데이터가 없습니다.");
                }
                // 만약 이름이 등록된 적이 없다면 조회할 이름이 없습니다.
                // name안에 담겨진 값을 출력하는 기능 구현
            } else if (choice == UPDATE) {
                if (isResistered) {
                    System.out.print("수정할 이름을 입력하세요.: ");
                    name = scanner.nextLine();
                    System.out.println("내용이 성공적으로 수정되었습니다.");
                } else {
                    System.out.println("등록된 데이터가 없습니다. 수정할 수 없음.");
                }
                //수정해야할 값이 없습니다. 등록부터 해주세요.
                //name을 수정하는 기능 구현
            } else if (choice == DELETE) {
                if (isResistered) {
                    System.out.println(name + "삭제 완료");
                    name = "";
                    isResistered = false;
                } else {
                    System.out.println("등록된 데이터가 없습니다. 삭제할 수 없음");
                }
                //name을 삭제하는 기능 구현
                //만약 y를 누른다면 해당 name은 삭제됨
                //만약 n을 누른다면 해당 name은 그대로 있음
            } else if (choice == END) {
                System.out.println("프로그램을 종료합니다");
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 선택해주세요");
            }
        } //end of while
        scanner.close();
    }//end of main
}//end of class





