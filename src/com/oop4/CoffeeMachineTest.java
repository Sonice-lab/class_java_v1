package com.oop4;

public class CoffeeMachineTest {
    public static void main(String[] args) {
        //생성자 1로 부르기
        CoffeeMachine machine1 = new CoffeeMachine();
        //생성자 1로 불렀을 경우, 아래의 명령어를 통해
        //물 몇 ml이 필요한지, 커피 몇 g이 필요한지 적어주어야 함
        machine1.water = 300;
        machine1.coffee = 50;
        //생성자 2로 부르기
        // 생성자의 경우, 원래 그 값을 포함하도록 생성하여
        // 객체 생성 시 그 값을 바로 정의할 수 있도록 할 수 있음!
        CoffeeMachine machine2 = new CoffeeMachine(500, 50);

        //커피를 1잔씩 만들었을 때 현황 표시 흐름
        String result = machine1.makeCoffee(); //1잔 만듬
        System.out.println("커피 요청 결과: " + result); //
        machine1.showInfo();
        machine1.showCount();
        machine1.makeCoffee(); //2잔 만듬
        machine1.makeCoffee(); //3잔 만듬
        machine1.makeCoffee(); //x
        machine1.makeCoffee(); //x
        machine1.makeCoffee(); //x
        machine1.showInfo(); // 남은 물의 양: 0, 남은 원두의 양: 20
        machine1.showCount(); //현재 3잔을 만듬

        //물이나 커피가 떨어졌을 경우 호출할 때
        machine1.refillWater(200);
        machine1.refillCoffee(100);
        //현재 machine1의 현황
        machine1.showInfo();

    }//end of main
}//end of class
