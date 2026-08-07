package com.oop4;

public class CoffeeMachine {

    //커피 머신의 상태(필드): 물의 양(ml), 커피 원두 양(g)
    int water;
    int coffee;
    int count;

    //생성자 1. --> 어떠한 수도 안넣게 하고 싶을 때
    public CoffeeMachine() {
    }

    //생성자 2. 사용자 정의 생성자
    //생성자 직접 설계해서 테스트 코드 작성해보기
    //반환값 없음. 코드 작동 후 종료.
    // 생성자의 경우, 원래 그 값을 포함하도록 생성하여
    // 객체 생성 시 그 값을 바로 정의할 수 있도록 할 수 있음!
    public CoffeeMachine(int w, int c) {
        water = w;
        coffee = c;
    }

    // 2. 메서드 1) 물 채우기
    void refillWater(int amount) {
        if (amount > 0) {
            water += amount;
            System.out.println(amount + "ml의 물을 채웠습니다.");
        } else {
            System.out.println("0보다 큰 양의 물을 채워주세요.");
        }
    }
    //3. 메서드 2) 원두 채우기
    void refillCoffee(int amount){
        if(amount > 0){
            coffee += amount;
            System.out.println(amount + "의 원두를 채웠습니다.");
        }else{
            System.out.println("0보다 큰 양의 커피를 채워주세요.");
        }
    }
    //4. 메서드 3) 커피 만들기
    String makeCoffee(){
        //방어적 코드
        //커피 한 잔에 물 100ml, 원두 10g 필요
        if(water >= 100 && coffee >=10){
            water -= 100;
            coffee -= 10;
            count++; //증감 연산자, 만든 잔 수 1씩 증가
            return "맛있는 커피가 완성되었습니다.";
        }else {
            return "재료가 부족합니다. 물이나 원두를 채워주세요.";
        }
    }

    //5. 메서드 4) 해당하는 객체의 현재 상태 값을 보여주는 기능 추가
    // 단, 여기서 콘솔창에 출력하는 기능(return 타입) 필요 없음
    void showInfo(){
        System.out.println("-----현황-----");
        System.out.println("남은 물의 양: " + water );
        System.out.println("남은 원두의 양: " + coffee );
    }

    //6. 메서드 5) 현재 해당하는 커피 머신이 몇 잔의 커피를 만들었는지 출력하는 기능을 만들어주세요.
    void showCount(){
        System.out.println("현재" + count + "잔을 만들었습니다.");
    }
}//end of class
