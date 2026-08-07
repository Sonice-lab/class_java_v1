package com.oop15;

public class Computer {
    //합성관계: Computer는 내부적으로 CPU 객체들을 소유한다.
    private String operation;//연산수행
    private CPU commandControl;//명령어 제어
    private CPU workConduct;//작업 지휘
    
    //getter를 만드는 순간, 합성관계를 깨진다.
    //따라서, 아래와 같이 생성자를 생성한다.
    public Computer(String operation){
        this.operation = operation;
        //합성 조건 1.
        this.commandControl = new CPU("명령어 제어");
        this.workConduct = new CPU("작업 지휘");
    }
    //합성 조건 2. CPU에 대한 getter 메서드를 만들지 않음
    public void showInfo(){
        System.out.println(operation + "을 수행합니다.");
        commandControl.use();
        workConduct.use();
    }
}
