package startcraft.ver_2;

public class Zealot {
    //멤버 변수는 기본값을 받는다.
    private String name; //null, Zealot1, Zealot2
    private int power;//0
    private int hp;//0

    public Zealot(String name) { //생성자 생성
        this.name = name;
        this.power = 5;
        this.hp = 80;
    }

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

    //set메서드
    //1. 질럿이 특정 저글링을 공격합니다.
    public void attackZergling(Zergling zergling) {
        //로직작성
        if (this.hp <= 0) {
            System.out.println(this.name + "은 이미 사망하여 공격할 수 없습니다.");
            return; //값을 반환시키거나 메서드를 즉시 종료시킬 수 있음. // 이미 죽어버려 공격 자체를 할 수 없을 떄
        }
        System.out.println(this.name + "이 " + zergling.getName() + "을 공격합니다.");
        zergling.beAttacked(this.power);
    }

    //2. 질럿이 특정 마린을 공격합니다.
    public void attackMarine(Marine marine) {
        //로직 작성
        if(this.hp <= 0){
            System.out.println(this.name + "은 이미 사망하여 공격할 수 없습니다.");
            return;
        }
        System.out.println(this.name + "이" + marine.getName() + "을 공격합니다.");
        marine.beAttacked(this.power);
    }

    //3. 자기자신(질럿)이 공격을 당합니다.
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
            System.out.println(this.name + "이 사망했습니다.");
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
