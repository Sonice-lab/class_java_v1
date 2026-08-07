package startcraft.ver_5;


public class Unit {
    //속성
    protected String name; //null, Zealot1, Zealot2
    protected int power;//0
    protected int hp;//0

    //get메서드
    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public int getHp() {
        return hp;
    }

    //1. 각 객체들이 공격함 --> 다형성을 활용하여 코드 통합
    public void attack(Unit unit){

        //로직작성
        if (this.hp <= 0) {
            System.out.println(this.name + "은 이미 사망하여 공격할 수 없습니다.");
            return; //값을 반환시키거나 메서드를 즉시 종료시킬 수 있음. // 이미 죽어버려 공격 자체를 할 수 없을 떄
        }
        System.out.println(this.name + "이 " + unit.getName() + "을 공격합니다.");
        unit.beAttacked(this.power);
    }

    //2. 자기자신(저글링)이 공격을 당합니다.
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

    //3. 메서드 내 현재 상태 보기
    public void showInfo() {
        System.out.println("-----상태창-----");
        System.out.println("이름: " + name);
        System.out.println("현재 공격력: " + power);
        System.out.println("현재 생명력: " + hp);
    }
}
