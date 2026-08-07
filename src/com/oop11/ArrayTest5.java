package com.oop11;

import java.util.Random;

public class ArrayTest5 {

    public static int[] makeNumber() {
        //1, 10, 11, 12, 13, ... 6자리 값을 반환하는 값으로 만들고 싶음
        //6자리 정수값을 반환하기 위해 int[]로 반환값을 선언한다.
        Random random = new Random();
//        int g1 = random.nextInt(45 + 1);//1~45까지 나올 수 있도록 설정
//        int g2 = random.nextInt(45 + 1);//1~45까지 나올 수 있도록 설정
//        int g3 = random.nextInt(45 + 1);//1~45까지 나올 수 있도록 설정
//        int g4 = random.nextInt(45 + 1);//1~45까지 나올 수 있도록 설정
//        int g5 = random.nextInt(45 + 1);//1~45까지 나올 수 있도록 설정
//        int g6 = random.nextInt(45 + 1);//1~45까지 나올 수 있도록 설정

        int[] numbers = new int[6];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(45 + 1); //값이 반복할 때마다 덮어쓰지 않도록 배열로 처리
        }
        return numbers;
    }//end of makeNumber method

    public static void main(String[] args) {

        int[] lotto = makeNumber();
        System.out.println(lotto); //주소값이 나옴

        //안의 값을 볼려면 index를 활용해야 함
//        System.out.println(lotto[0]);
//        System.out.println(lotto[1]);
//        System.out.println(lotto[2]);
//        System.out.println(lotto[3]);
//        System.out.println(lotto[4]);
//        System.out.println(lotto[5]);

        //일반 for문: i값을 써서 편하게 제어할 수 있음
        for (int i = 0; i < lotto.length; i++) {
            System.out.print(lotto[i] + "\t"); //   \t: tab 간격만큼 띄워라!
        }

        //더 나아가기) 초기화 for문의 형태: 처음부터 끝까지 돌려야할 때 사용
        //for (int i : lotto) {
        //}

    }//end of main
}//end of class
