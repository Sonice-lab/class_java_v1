package com.oop8;

public class Book {
    private String title;
    private String author;
    private int price;

    public Book(String title){
        this.title = title; //멤버 변수인지 매개 변수인지 구분할 수 있다.
        System.out.println("1번 생성자 호출됨");
    }
    public Book(String title, String author){
        //this.title = title;
        this(title);
        this.author = author;
        System.out.println("2번 생성자 호출됨");
    }

    public Book(String title, String author, int price) {
        this(title, author);
        this.price = price;
        System.out.println("3번 생성자 호출됨");
    }

    //메서드
    public Book getBook(){
        return this; //자기 자신의 주소값을 반환함
    }
}


