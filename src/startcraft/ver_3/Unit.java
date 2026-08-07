package startcraft.ver_3;

//각 파일의 통일된 부분 고쳐넣기
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

    //1. 질럿이 특정 저글링을 공격합니다.
    public void attack(Zergling zergling) {
        //로직작성
        if (this.hp <= 0) {
            System.out.println(this.name + "은 이미 사망하여 공격할 수 없습니다.");
            return; //값을 반환시키거나 메서드를 즉시 종료시킬 수 있음. // 이미 죽어버려 공격 자체를 할 수 없을 떄
        }
        System.out.println(this.name + "이 " + zergling.getName() + "을 공격합니다.");
        zergling.beAttacked(this.power);
    }

    //2. 질럿이 특정 마린을 공격합니다.
    public void attack(Marine marine) {
        //로직 작성
        if (this.hp <= 0) {
            System.out.println(this.name + "은 이미 사망하여 공격할 수 없습니다.");
            return;
        }
        System.out.println(this.name + "이" + marine.getName() + "을 공격합니다.");
        marine.beAttacked(this.power);
    }

    //3. 저글링이 질럿을 공격합니다.
    public void attack(Zealot zealot) {
        //로직작성
        if (this.hp <= 0) {
            System.out.println(this.name + "은 이미 사망하여 공격할 수 없습니다.");
            return; //값을 반환시키거나 메서드를 즉시 종료시킬 수 있음.
        }
        System.out.println(this.name + "이 " + zealot.getName() + "을 공격합니다.");
        zealot.beAttacked(this.power);
    }

    //4. 자기자신(저글링)이 공격을 당합니다.
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

    //5. 메서드 내 현재 상태 보기
    public void showInfo() {
        System.out.println("-----상태창-----");
        System.out.println("이름: " + name);
        System.out.println("현재 공격력: " + power);
        System.out.println("현재 생명력: " + hp);
    }
}
