package com.oop15;

//Car와 Engine의 관계는 문법적으로는 동일하나 같은 객체라도 보기에는 애매함
//그러므로 상속을 사용하는 것은 적합하지 않다.
//따라서 아래와 같이 합성 관계를 설정해준다.
public class Engine {

    private String name;

    public Engine(String name){
        this.name = name;
    }

    public void start(){
        System.out.println(name + "엔진이 가동됩니다.");
    }

    public void stop(){
        System.out.println(name + "정지합니다.");
    }
}//end of class
