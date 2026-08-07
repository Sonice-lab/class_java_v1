package com.oop9;

public class Dog {
    private String name;
    private int age;
    private double weight;

    //생성자를 생성해보자.
    public Dog(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    //1. get 메서드를 만들어주세요.
    //현재의 값만 리턴해야하는 경우 사용하는 메서드
    //가. 이름의 get메서드를 만들어보자.
    public String getName() {
        return name;
    }

    //나. 나이의 get 메서드를 만들어보자.
    public int getAge() {
        return age;
    }

    //다. 무게의 get메서드를 만들어보자.
    public double getWeight() {
        return weight;
    }

    //2. set메서드를 만들어주세요.
    //상태를 바꾸고 싶을 떄
    //setter 메서드는 값만 받을 거라서 return 타입이 무조건 void이다.
    //또한, 매개 변수가 선언되어야 한다.
    //가. 이름의 상태를 변경할 수 있는 set메서드를 만들어보자.
    public void setName(String name) {
        this.name = name;
    }

    //나. 나이의 상태를 변경할 수 있는 set메서드를 만들어보자.
    public void setAge(int age) {
        //방어적 코드 짜기
        if(age <= 0){
            System.out.println("나이를 0보다 작게 입력할 수 없습니다.");
            return;//실행의 제어권 반납
        }
        this.age = age;
    }

    //다. 무게의 상태를 변경할 수 있는 set메서드를 만들어보자.
    public void setWeight(double weight) {
        //방어적 코드 짜기
        if(weight <= 0){
            System.out.println("몸무게를 0보다 작게 입력할 수 없습니다.");
            return;
        }
        this.weight = weight;
    }

    // 정보 출력 기능
    public void showInfo() {
        System.out.println("강아지 이름: " + name + ", 나이: " + age + ", 몸무게: " + weight + "kg");
    }
}
