package com.oop12;

import java.util.Scanner;
//코드를 메서드화시켜서 처리하는 기능을 프로그램으로 구현해보기
//가독성좋게 코드를 디자인해보기!

/**
 * 모든 프로그래밍의 기본은 C(Create)R(Read)U(Update)D(Delete)이다.
 * 배열을 활용한 간단한 데이터 관리 시스템
 */

public class MyBookStore {
    //1단계기본 코드 작성
    //현재 저장된 실제 데이터 개수를 추적하는 공유 변수(static)
    //lastIndexNumber == 요소가 쌓여있는 마지막 인덱스 번호
    static int lastIndexNumber = 0;

    //전체 조회하기 메서드
    public static void readAll(Book[] books) {//매개 변수 주기
        System.out.println("-------------전체조회 호출됨-----------");
        //
        //방법 1) boolean isFind = false;
        //방법 2)
        if (lastIndexNumber == 0) {
            System.out.println("아직 저장된 책이 없습니다.");
            return;
        }

        //배열에 들어가 있는 요소들 전체 불러오기
        for (int i = 0; i < books.length; i++) {
            //방어적 코드 null이 아닐때만 출력해!
            if (books[i] != null) {
                //방법 1) isFind = true;
                System.out.println(books[i].getTitle() + ", " + books[i].getAuthor());
            }
        }
//    방법1)   if(isFind==false){
//            System.out.println("저장된 책이 아직 없습니다.");
//        }
    }

    //전체 삭제하기 메서드
    public static void deleteAll(Book[] books) {
        System.out.println("------------전체삭제 호출됨-------------");
        //books 배열에다 null 값 넣기
        for (int i = 0; i < books.length; i++) {
            books[i] = null;
        }
        //다시 기준값 전체 삭제 후 0으로 초기화 되어야함
        lastIndexNumber = 0;
    }

    //저장하기 메서드
    public static void save(Scanner sc, Book[] books) { // Book[] books > Book배열 주소값 부르기
        System.out.println("--------------저장하기 호출 됨-------------");
        //방어적 코드 작성
        //배열의 길이를 초과했을때는 저장할 공간이 확보되지 않았으므로, 책을 더이상 저장할 수 없음
        if (lastIndexNumber >= books.length) {
            System.out.println("저장 공간이 가득 찼습니다.");
            return;
        }

        System.out.println("책의 제목을 입력하세요.");
        String title = sc.nextLine();
        System.out.println("책의 저자를 입력하세요.");
        String author = sc.nextLine();
        //사용자에게 입력받은 변수들로 book이라는 객체 만들기
        Book book = new Book(title, author);
        //몇번째 인덱스까지 채웠는지 관리해야함! lastIndexNumber 활용
        books[lastIndexNumber] = book;
        //덮어쓰면 안되니까 증감 연산자를 활용해서 내용이 덮어쓰이지 않게 처리
        lastIndexNumber++;

    }

    //선택조회하기 메서드
    private static void searchByTitle(Scanner sc, Book[] books) {
        System.out.println("--------------------선택조회 호출됨-------------------");
        //제목을 입력하면 책이 있는지 없는지를 확인할 수 있는 기능
        System.out.print("조회할 책 제목을 입력해주세요.: ");
        String targetTitle = sc.nextLine();

        //100번 돌더라도 탐색된다면 검색을 멈추기 위한 처리
        boolean isFine = false;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                //문자열 비교는 반드시 equals를 사용!
                //.trim() <-- 문자열에 앞뒤 공백 자동 제거
                //(공백)사비 엔스(공백) > 중간 공백은 날리지 않음
                if (books[i].getTitle().equals(targetTitle.trim())) {
                    System.out.println("[검색 결과 확인]");
                    books[i].showInfo(); //책정보 출력
                    isFine = true;
                    break;
                }
            }
        }
        //isFine -> true or false
        //isFine -> true --> false
        //if(isFine ==false){
        if (isFine == false) {//단독 if -> true 실행 / 반대로 false -> !부정
            System.out.println("조회된 책 결과가 없습니다."); //공백도 글자로 간주
        }
    }

    //도전과제 1)
    //선택 삭제 기능 만들어보기
    //1. 선택 삭제하는 메뉴 만들기
    private static void deleteByTitle(Scanner sc, Book[] books) {

        System.out.println("------선택 삭제 호출됨------");
        //만약, 검색했을 때 데이터가 없다면 > "삭제하고자하는 책이 없습니다."
        if (lastIndexNumber == 0) {
            System.out.println("삭제할 책이 없습니다.");
            return;
        }
        System.out.print("삭제할 책제목을 입력해주세요.: ");
        String targetTitle = sc.nextLine().trim(); //키보드에서 입력 값을 받는 동시에 앞뒤 공백 제거
        //1단계: 삭제할 책의 위치(인덱스)를 먼저 찾는다.
        int targetIndex = -1; //관용적인 표현, -1"못 찾았다"는 뜻으로 약속한 값
        //만약, 검색을 했을 때 데이터가 있다면," 해당하는 책이 확인되었습니다.
        for (int i = 0; i < lastIndexNumber; i++) {//lastIndexNumber 좀 더 반복문을 줄일 수 있음

            if (books[i] != null && books[i].getTitle().equals(targetTitle)) {
                System.out.println("책이 검색되었습니다.");
                //시나리오 작성하기
                //[][][O][]
                targetIndex = i;
                break;
            }
        }
        //2단계: 못 찾았으면 여기서 동작 끝
        if (targetIndex == -1) {
            System.out.println("해당 제목의 책을 찾을 수 없습니다.");
            return;
        }
        System.out.println("[삭제대상]");
        books[targetIndex].showInfo();
        System.out.println("책이 성공적으로 삭제되었습니다.");

        //3단계: 삭제할 자리 뒤에 있는 요소들을 한칸씩 앞으로 당겨서 삭제할 대상 덮어쓰기
        //[A][B][C][D] ---> 1. 인덱스 삭제 ----> [A][C][D][D]
        // targetIndex == 2 ~ 4
        for (int i = targetIndex; i < lastIndexNumber - 1; i++) {
            //[][][C][][]   = [][][][D][E]
            books[i] = books[i + 1];
            //[][][D][E][E]
            //[B] ---> 1번째 인덱스 = [C] ---> 2번째 인덱스를 덮어쓰기
        }
        //4단계: 맨 뒷 칸을 비우고 실제 개수를 하나 줄인다.(라이스 인덱스 번호 재갱신)
        //[][][D][E][null]
        books[lastIndexNumber - 1] = null;
        lastIndexNumber--; //관리하고있는 인덱스 번호 -1 처리
    }


    //메인 함수
    public static void main(String[] args) {
        //준비물
        Scanner sc = new Scanner(System.in);
        Book[] books = new Book[100]; //배열안에 100칸짜리의 공간이 있다.

        //샘플 데이터 만들어놓기
        books[0] = new Book("플러터UI실전", "김근호"); //객체 생성
        books[1] = new Book("무궁화꽃이 피었습니다.", "김진명"); //객체 생성
        books[2] = new Book("흐르는 강물처럼", "파울로코엘로"); //객체 생성
        books[3] = new Book("리딩으로리드하라", "이지성"); //객체 생성
        books[4] = new Book("사피엔스", "유발하라리"); //객체 생성

        //샘플데이터가 5개 이므로, 인덱스 관리 번호로 사용
        lastIndexNumber = 5;


        boolean flag = true; //while문을 종료시키기 위한 선언

        final String SAVE = "1";
        final String SEARCH_ALL = "2";
        final String SEARCH_BY_TITLE = "3";
        final String DELETE_ALL = "4";
        final String DELETEBYTITLE = "5";
        final String END = "0";


        //2단계 실행의 흐름 만들어보기
        while (flag) {

            System.out.println("** 메뉴 선택 **");
            System.out.println("1. 저장 2. 전체조회 3. 선택조회 4. 전체 삭제 5. 부분 삭제 0. 종료");

            //사용자에게 몇번 메뉴를 받을 것인가? 스캐너 활용
            String selectedNumber = sc.nextLine();
            if (selectedNumber.equals(SAVE)) {//문자열을 비교할 땐 통상적으로 equals를 사용한다.
                save(sc, books);
            } else if (selectedNumber.equals(SEARCH_ALL)) {
                readAll(books);
            } else if (selectedNumber.equals(SEARCH_BY_TITLE)) {
                searchByTitle(sc, books);
            } else if (selectedNumber.equals(DELETE_ALL)) {
                deleteAll(books);
            } else if (selectedNumber.equals(DELETEBYTITLE)) {
                deleteByTitle(sc, books);
            } else if (selectedNumber.equals(END)) {
                System.out.println("---------프로그램 종료--------");
                flag = false; //break가 아닌 다른 방법으로도 프로그램을 멈출 수있다.
            } else {
                System.out.println(">>>잘못된 선택입니다.<<<");
            }
        }
    }//end of main
}
