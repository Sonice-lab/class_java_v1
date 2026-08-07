package com.oop10;

public class NumberPrinterTest2 {
    public static void main(String[] args) {

        //NumberPrinter printer1 = new NumberPrinter(1);
        //NumberPrinter printer2 = new NumberPrinter(2);
        //Static 변수는 모든 객체가 공유하는 변수를 만들 때 사용한다.
        //static 변수는 심지어 객체가 생성하기 전에도 먼저 사용할 수 있다.
        //---> 그렇기에 static 변수는 class 변수하고도 함

        //printer1.WaitNumber; //예전에는 됬었으나, 지금은 호출 자체를 맏아둠
        System.out.println(NumberPrinter.waitNumber);
        System.out.println(NumberPrinter.waitNumber);
        //tip) static은 태양이다. --> 여러 객체들(인간)이 공유하는 자원, 객체(인간)가 있기 전 사전에 있었던 자원
        //객체들이 공통으로 사용해야하는 변수가 필요한 경우
        // 1. 은행에서 대기표를 뽑을 경우(2개 이상)
        // 2. 스타크래프트 게이트웨이 각각 유닛을 생산했을 때 몇마리를 생성했는가?
        // 3. 회사에 사원이 입사할 때마다 새로운 사번이 필요한 경우

    }//end of main
}//end of class
