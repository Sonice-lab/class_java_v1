package com.oop16;
//바나나는 과일 타입으로 바라볼 수 있고, 과일 타입 또한 바나나 타입으롭 바라볼 수 있다. -> 다형성
public class Banana extends Fruit {
    //원산지 선언
    private String origin;

    public Banana() {
        name = "바나나";
        price = 5000;
        origin = "필리핀";
    }

    public String getOrigin() {
        return origin;
    }

    //바나나에만 있는 고유메서드
    public void saleBanana() {
        if (price <= 1000) {
            System.out.println("더이상 할인할 수 없습니다.");
            return;
        }
        // 정액 할인 - 고정값 1000원만 뺴기
        price -= 1000;
        System.out.println("바나나 가격을 할인합니다. 현재 가격: " + price);
    }
}
