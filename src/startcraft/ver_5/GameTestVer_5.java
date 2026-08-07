package startcraft.ver_5;

//인터페이스로 구현해보기

public class GameTestVer_5 {
    public static void main(String[] args) {
       // 테스트 코드 작성
        // 1. 유닛 생성
        Zealot zealot = new Zealot("질럿1");
        Marine marine = new Marine("마린1");
        Wraith wraith = new Wraith("레이스1");

        // 2. 다형성을 이용해 배열에 담기
        Unit[] army = new Unit[3];
        army[0] = zealot;
        army[1] = marine;
        army[2] = wraith;

        System.out.println("=== 부대 전진 ===");
        // 3. 배열을 순회하면서 비행 가능한 유닛만 공중으로 이동시키기
        for (int i = 0; i < army.length; i++) {

            // 현재 꺼낸 유닛이 Flyable 인터페이스를 가지고 있다면(즉, 비행 유닛이라면)
            if (army[i] instanceof Flyable) {
                // Flyable 타입으로 형변환(다운캐스팅)하여 fly() 메서드 실행
                Flyable flyingUnit = (Flyable) army[i];
                flyingUnit.fly();
            } else {
                System.out.println(army[i].getName() + "이(가) 지상으로 걸어서 이동합니다.");
            }
        }

        System.out.println("\n=== 전투 발생 ===");
        // 상속받은 attack 메서드도 당연히 정상 작동합니다.
        wraith.attack(zealot);

    }//end of main
}//end of class


