package startcraft.ver_5;

// Unit을 상속받아 기본 유닛의 속성을 가지고, Flyable을 구현하여 비행 능력을 추가합니다.
public class Wraith extends Unit implements Flyable{
    public Wraith(String name) {
        super.name = name;
        super.power = 8;
        super.hp = 120;
    }
    // Flyable 인터페이스의 메서드를 반드시 재정의(Override)해야 합니다.
    @Override
    public void fly() {
        System.out.println(this.name + "이(가) 공중으로 날아올라 이동합니다. (슈우웅~) ");
    }
}
