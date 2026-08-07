package com.oop10;

import java.util.Random;

public class LottoNumberMaker {
    //난수 생성기를 만들어서 계속 재사용해보자.

    //static 변수 활용
    //난수 생성기 가지고오기(import)
    //int n1 = 10;
    private static Random random = new Random();

    //static 메서드 - 1부터 45사이의 번호를 하나 만들어서 반환한다.
    public static int makeNumber() {
        //0~44 -> +1 ex) 0 + 1 --> 1, 44+1 + 45
        return random.nextInt(45) + 1;
    }
}//end of class
