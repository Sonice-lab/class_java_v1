package com.oop9;

public class DogMainTest {
    public static void main(String[] args) {
        //객체 불러오기
        Dog dog1 = new Dog("두부", 10, 15);
        dog1.setName("바둑이");
        dog1.setAge(0);
        dog1.setWeight(10);
        System.out.println(dog1.getName());
        System.out.println(dog1.getAge());
        System.out.println(dog1.getWeight());
        dog1.showInfo();
    }//end of main
}//end of class


