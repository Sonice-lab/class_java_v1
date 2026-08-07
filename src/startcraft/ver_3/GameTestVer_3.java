package startcraft.ver_3;

public class GameTestVer_3 {

    public static void main(String[] args) {
        // 1. 유닛 객체 생성
        Zealot zealot1 = new Zealot("질럿1");
        Marine marine1 = new Marine("마린1");
        Zergling zergling1 = new Zergling("저글링1");

        // 2. 초기 상태 확인
        System.out.println("=== 게임 시작 ===");
        zealot1.showInfo();
        marine1.showInfo();
        zergling1.showInfo();

        // 3. 전투 테스트
        System.out.println("\n=== 전투 발생 ===");
        zealot1.attack(marine1);   // 질럿이 마린을 공격
        marine1.attack(zergling1); // 마린이 저글링을 공격
        zergling1.attack(zealot1); // 저글링이 질럿을 공격

        // 사망 테스트 (저글링이 마린을 연속 공격)
        System.out.println("\n=== 연속 공격 ===");
        for(int i = 0; i < 20; i++) {
            zergling1.attack(marine1);
        }

        // 4. 전투 후 상태 확인
        System.out.println("\n=== 전투 종료 후 상태 ===");
        zealot1.showInfo();
        marine1.showInfo();
        zergling1.showInfo();
    }
}
