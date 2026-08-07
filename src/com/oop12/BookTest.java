package com.oop12;

//테스트 코드 작성해보기
public class BookTest {
    public static void main(String[] args) {

        Book[] books = new Book[10];//[주소][주소][주소][주소][주소][null][null][null][null][주소] --> 참조 값은 주소값이 들어간다.
        books[0] = new Book("플러터UI실전", "김근호", 300); //객체 생성
        books[1] = new Book("무궁화꽃이 피었습니다.", "김진명", 500); //객체 생성
        books[2] = new Book("흐르는 강물처럼", "파울로코엘로", 250); //객체 생성
        books[3] = new Book("리딩으로리드하라", "이지성", 450); //객체 생성
        books[4] = new Book("사피엔스", "유발하라리", 850); //객체 생성

        books[9] = new Book("홍길동전", "허균", 350); //마지막 인덱스, 객체 생성
        String title1 = books[0].getTitle();
        String author1 = books[0].getAuthor();
        int totalPage1 = books[0].getTotalPage();

            //books[0]인덱스에 있는 객체의 title 출력해
        for (int i = 0; i < books.length; i++) {
            //books[i].getTitle();
            //방어적코드 작성(배열)
            //만약 i번째가 가리키는 주소가 있을 때만 동작하세요.
            if(books[i] != null){
                System.out.println(books[i].getTitle() + ", " + books[i].getAuthor() + ", " + books[i].getTotalPage());
            }
//            System.out.println(books[i].getTitle());//if처리를 하지 않았다면 NullPointerException > 객체를 생성하지 않았거나 가리키는 주소가 없을 때 오류가 발생한다.
                                                     // books[5]는 생성하지 않았기 때문에 프로그램이 뻗어버림
        }

    }//end of main
}//end of class
