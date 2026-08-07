package com.oop10;

public class Customer {

    int cardNumber;//고유 카드 번호
    private String name;
    private int customerId;

    //생성자 생성 - 카드 회원이 늘어날수록 자동을 카드 번호 생성
    public Customer(String name, int customerId){
        this.name = name;
        this.customerId = customerId;

        //CardCompany의 카드번호를 활용해서 0000,0001로 출력하게 하기
        cardNumber = CardCompany.cardSerialNumber;
        CardCompany.cardSerialNumber++;
    }
}//end of class
