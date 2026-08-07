package com.oop9;

public class Warrior {

    private String name;
    private int level;
    private int hp;

    public Warrior(String name) {
        this.name = name;
        level = 1; //레벨은 1로 초기화
        hp = 100;
    }

    //getter 메서드 만들어보기(read only 성질을 가짐)
    //현재의 값만 리턴해야하는 경우 사용하는 메서드
    public String getName() {//이런 일을 하는 메서드
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    //setter 메서드 만들어보기(단, 필요하다면 만들어줄 수 있다.)
    //상태를 바꾸고 싶을 떄
    //setter 메서드는 값만 받을 거라서 return 타입이 무조건 void이다.
    //또한, 매개 변수가 선언되어야 한다.
    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        if (level <= 0) {
            System.out.println("0보다 작은 값을 입력할 수 없습니다.");
            return;
        }
        this.level = level;
    }

    public void setHp(int hp) {
        if (hp < 0) {
            System.out.println("0보다 작은 값을 입력할 수 없습니다.");
            return;//실행의 제어권 반납
        }
        this.hp = hp;
    }

    //일반 메서드
    //행위가 일어났을 때 로직
    //1. 멤버 변수 level 1이 증가하는 로직
    //2. 레벨이 올랐기 때문에 hp로 +5씩 증가하는 로직
    //3. 화면에 안내 문구 출력
    public void levelUp() {
        level++;
        hp += 5;
        System.out.println(name + "의 현재 레벨은 " + level + " 입니다.");
    }

}//end of class
