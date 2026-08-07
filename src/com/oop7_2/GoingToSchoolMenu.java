package com.oop7_2;

import java.util.Scanner;

public class GoingToSchoolMenu {
    // 코드를 실행해보는 측
    // 객체를 생성할 수 있는가?
    //문제(오류)를 해결할 수 있는가?
    public static void main(String[] args) {

        //준비물
        Scanner sc = new Scanner(System.in);
        final int EAT = 1;
        final int BUS = 2;
        final int SUBWAY = 3;
        final int MY_INFO = 4;
        final int END = 5;
        int money = 5_000;


        System.out.print("학생 이름을 입력하세요.: ");
        String name = sc.nextLine();

        //객체 생성(등장 인물 준비)
        Student student = new Student(name, 5_000);
        Rice rice = new Rice("김치볶음밥", 3_000);
        Bus bus133 = new Bus(133, 1_000);
        Subway line1 = new Subway(1, 1_400);

        while (true) {
            System.out.println();
            System.out.println("메뉴 선택");
            System.out.println("1. 밥먹기 2. 버스타기 3. 지하철타기 4. 내상태 5. 종료");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == EAT) {


            } else if (choice == BUS) {
                student.takeBus(bus133);

            }
//            else if (choice == SUBWAY) {
//                student.takeSubway(line1);
//
//            }
            else if (choice == MY_INFO) {
                student.showInfo();

            } else if (choice == END) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        } //직접 실행 흐름 만들어보기


    } //end of main
}//end of class
