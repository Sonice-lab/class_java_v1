package com.oop6;

public class Account {
    //1. 속성 정의
    private String name;
    private int balance;
    // 2. 행위 정의
    //입금하다.
    public void deposit(int money) {
        balance = balance + money;
        System.out.println("입금 완료");
    }
    //출금하다.
    public int withdraw(int money) {
        if (balance >= money) {
            balance -= money;
            System.out.println("출금 완료");
            return money;
        } else {
            System.out.println("잔액 부족");
            return 0;
        }
    }
    //현재 잔액 표시
    public void showInfo(){
        System.out.println("현재 잔액: " + balance + "원");
    }
}






