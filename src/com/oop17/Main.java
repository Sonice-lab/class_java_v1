package com.oop17;

public class Main {

    //코드 실행의 시작점
    public static void main(String[] args) {

//        //다형성의 활용 - 하나의 배열에 여러 타입 담기
//
//        //다형성을 모른다면 아래와 같이 코드를 작성하게 된다.
//        com.oop16.Banana[] banana = new com.oop16.Banana[10];
//        banana[0] = new com.oop16.Banana();
//        banana[1] = new com.oop16.Banana();
//
//        com.oop16.Peach[] peaches = new com.oop16.Peach[3];
//        peaches[0] = new com.oop16.Peach();
//        peaches[1] = new com.oop16.Peach();
//        peaches[2] = new com.oop16.Peach();
//
//        // 결론: 다형성이 없다면, 타입별로 배열을 만들어야 한다.
//        System.out.println("----------------------------------------------");
//
//        //즉, 다형성을 사용하면 부모 타입 배열 하나에 자식들을 모두 담을 수 있다!
//        com.oop16.Fruit[] fruits = new Fruit[4];
//        //다형성이 적용되어 과일들이 문제없이 들어간다.
//        //다형성이기 때문에 하나의 배열에 모두 넣을 수 있다.
//        fruits[0] = new com.oop16.Banana();
//        fruits[1] = new Peach();
//        fruits[2] = new com.oop16.Banana();
//        fruits[3] = new com.oop16.Apple();
//
//        //만약 사과라면 할인 금액으로 호출해
//        for (int i = 0; i < fruits.length; i++) {
//            fruits[i].showInfo(); //i번째 객체의 showInfo 메서드를 호출한다.
//            //문제 - 타입이 바나나일 때만 할인 메서드를 호출하시오
//            if (fruits[i] instanceof com.oop16.Banana) {
//                ((Banana) fruits[i]).saleBanana();
//            } else if(fruits[i] instanceof com.oop16.Apple){
//                ((Apple)fruits[i]).saleApple();
//            }
//        }//end of for
//        //그렇지만 이러한 방법은 다른 과일이 추가되었을 때 계속해서 추가를 해주고
//        // 코드를 변경해야하는 번거로움이 있다.

        //응용문제.★ if else 추가 없이 잘 동작하도록 클래스들을 설계해주세요.
        Fruit[] fruits = new Fruit[3];
        fruits[0] = new Banana();
        fruits[1] = new Peach();
        fruits[2] = new Apple();

        // 타입 검사가 필요 없다. 새로운 과일 타입이 추가 되더라고 굳이 if문을 작성할 필요 조차 없다.
        for (int i = 0; i < fruits.length; i++) {
            fruits[i].showInfo();
            fruits[i].sale();
            System.out.println("-----------");

        }

    }//end of main
}// end of class
