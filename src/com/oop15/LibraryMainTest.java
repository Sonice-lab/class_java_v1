package com.oop15;

public class LibraryMainTest {

    //코드 시작의 시작점
    public static void main(String[] args) {
       //1. 책 객체를 밖에서 먼저 생성한다.(독립적인 존재)
       Book b1 = new Book("자바의 정석");
       Book b2 = new Book("이펙트브 자바");

       //2. 도서관을 만들고 책을 넣을 수 있다.
        Library library1 = new Library(5);
        library1.addBook(b1);
        library1.addBook(b2);
        library1.showBooks();

        System.out.println("------도서관 폐관------");

        //3. 도서관 객체를 가리키던 참조를 끊는다.
        //주의: 이 순간, 객체가 사라지는 것은 아님, 다만, GC(Garbage Collector)의 수거대상이 될 뿐이다.
        //메모리 관리 2가지 - 1. 메모리 해지, 2. 자동으로 메모리 수거
        library1 = null;

        //4. 도서관은 사라졌지만,  b1, b2는 여전히 살아있다.
        // 즉, b1, b2 변수가 각 Book 객체를 계속 붙잡고 있기 때문에 GC 대상이 된다.
        //library1.showBooks(); //NullPointerException
        b1.display(); //독립적인 객체이기 때문에 library가 null값이 되더라고 정보를 살아있다.
        b2.display();


    }//end of main
}//end of class
