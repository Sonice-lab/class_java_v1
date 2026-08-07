package com.oop10;

public class MainTest2 {
    public static void main(String[] args) {

        Customer c1 = new Customer("홍가람", 1);
        Customer c2 = new Customer("홍나람", 2);
        Customer c3 = new Customer("홍다람", 3);

        System.out.println(c1.cardNumber);
        System.out.println(c2.cardNumber);
        System.out.println(c3.cardNumber);

    }//end of main
}//end of class
