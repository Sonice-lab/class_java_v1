package startcraft.ver_1;

public class Zergling {
    //멤버 변수는 기본값을 받는다.
    private String name; //null, Zealot1, Zealot2
    private int power;//0
    private int hp;//0

    public Zergling(String name) {
        this.name = name;
        this.power = 3;
        this.hp = 50;
    }

    //get메서드 --> 다른곳에서 이름을 가져오기 위함이다.
    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public int getHp() {
        return hp;
    }

    //set메서드
    //1. 저글링이 질럿을 공격합니다.
    public void attack(Zealot zealot) {
        //로직작성
        if (this.hp <= 0) {
            System.out.println(this.name + "은 이미 사망하여 공격할 수 없습니다.");
            return; //값을 반환시키거나 메서드를 즉시 종료시킬 수 있음.
        }
        System.out.println(this.name + "이 " + zealot.getName() + "을 공격합니다.");
        zealot.beAttacked(this.power);
    }

    //2. 저글링이 마린을 공격합니다.
    public void attack(Marine marine) {
        //로직작성
        if (this.hp <= 0) {
            System.out.println(this.name + "은 이미 사망하여 공격할 수 없습니다.");
            return; //값을 반환시키거나 메서드를 즉시 종료시킬 수 있음.
        }
        System.out.println(this.name + "이 " + marine.getName() + "을 공격합니다.");
        marine.beAttacked(this.power);
    }

    //3. 자기자신(저글링)이 공격을 당합니다.
    public void beAttacked(int power) {
        //로직 작성
        if (this.hp <= 0) {
            System.out.println(this.name + "은 이미 사망한 상태입니다.");
            return;
        }
        this.hp -= power;
        System.out.println(this.name + " 이 공격을 당합니다.");
        if (this.hp <= 0) {
            this.hp = 0;
            System.out.println(this.name + " 사망했습니다.");
        }//때린 다음의 상황
    }

    //4. 메서드 내 현재 상태 보기
    public void showInfo() {
        System.out.println("-----상태창-----");
        System.out.println("이름: " + name);
        System.out.println("현재 공격력: " + power);
        System.out.println("현재 생명력: " + hp);
    }

}//end of class




