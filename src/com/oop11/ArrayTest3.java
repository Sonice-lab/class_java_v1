package com.oop11;

public class ArrayTest3 {
    public static void main(String[] args) {

        //배열은 반복문과 함께 많이 사용되어진다.
        char[] alphabets = new char[26];

        char ch1 = 'A';
        alphabets[0] = ch1;

        char ch2 = 'B';
        alphabets[1] = ch2;

        char ch3 = 'C';
        alphabets[2] = ch3;

        char ch26 = 'Z';
        alphabets[25] = ch26;

        System.out.println(alphabets[0]);
        System.out.println(alphabets[1]);
        System.out.println(alphabets[2]);
        System.out.println(alphabets[25]);

        System.out.println(alphabets[3]); //아무것도 출력되지 않음

        System.out.println("------------");

        //반목문 for 활용
        int forCount = 0;
        for (int i = 0; i < alphabets.length; i++) {//alphabets.length > 26으로 치환됨
            System.out.println(alphabets[i]);
            forCount++;
        }System.out.println();
        System.out.println("for 동작 횟수: " + forCount);//end of for

        //배열안에 들어가는 것 element(요소), 현재 들어가 있는 요소의 갯수는 4개임.
        //배열의 길이와 요소의 개수는 동일하지 않을 수 있다.

    }//end of main
}//end of class
