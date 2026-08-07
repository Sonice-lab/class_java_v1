package com.oop12;

public class Book {
    private String title; //null
    private String author; //null
    private int totalPage; //0
    //대문자로 시작하는 타입 --> 참조 변수 --> null로 초기화가 된다.

    //1. 생성자 만들기
    //생성자가 private일 경우 외부에서 호출할 수 없음
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    //2. 생성자 만들기
    public Book(String title, String author, int totalPage) {
        this(title, author);
        this.totalPage = totalPage;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void showInfo() {
        System.out.println(">>>책 정보<<<");
        System.out.println("제목: " + title);
        System.out.println("저자: " + author);
        if (totalPage != 0) {
            System.out.println("총 페이지수: " + totalPage);
        }
    }
}//end of class

