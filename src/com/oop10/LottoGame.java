package com.oop10;

public class LottoGame {
    //static main 메소드 선언(코드의 진입점)
    public static void main(String[] args) {
        int game1 = LottoNumberMaker.makeNumber();
        int game2 = LottoNumberMaker.makeNumber();
        int game3 = LottoNumberMaker.makeNumber();
        int game4 = LottoNumberMaker.makeNumber();
        int game5 = LottoNumberMaker.makeNumber();
        int game6 = LottoNumberMaker.makeNumber();

        System.out.println(game1 + ", " + game2 + ", " +game3 + ", " +game4 + ", " +game5 + ", " +game6);

        //static이기 때문에 객체 생성이 필요없음
        //LottoNumberMaker 객체를 단 하나도 만든 적이 없다. 다만, 실행이 된다. 그 이유는 static이기 때문이다.
    }
}
