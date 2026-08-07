package com.oop1;

public class BookMainTest1 {

    //코드 실행의 시작점
    public static void main(String[] args) {

        //참조변수: 본인이 설계한 데이터
        //new 키워드를 3번 썼기 때문에 Heap이라는 메모리 영역에 객체가 3개 생성이 되었다.
        // 즉, 메모리에 올라가면(인스턴스화) 우리는 이것을 객체라고 부른다.
        Book book1 = new Book();//객체 생성
        Book book2 = new Book();//객체 생성
        Book book3 = new Book();//객체 생성

        System.out.println("book1 : " + book1);
        System.out.println("book2 : " + book2);
        System.out.println("book3 : " + book3);




    }//end of main
}// end of class
