package startcraft.ver_4;


public class GameTestVer_4 {
    public static void main(String[] args) {
        // 테스트 코드 작성
        // 1. 유닛 객체 생성
        Zealot zealot1 = new Zealot("질럿1");
        Marine marine1 = new Marine("마린1");
        Zergling zergling1 = new Zergling("저글링1");

        System.out.println("=== 1:1 전투 테스트 ===");
        zealot1.attack(marine1);
        marine1.attack(zergling1);
        zergling1.attack(zealot1);

        System.out.println("\n=== 다형성을 활용한 배열 테스트 ===");
        // Unit 부모 타입 배열에 자식 객체들을 모두 담을 수 있습니다!
        Unit[] army = new Unit[3];
        army[0] = zealot1;
        army[1] = marine1;
        army[2] = zergling1;

        // 배열을 순회하며 모든 유닛의 상태 정보 출력
        for (int i = 0; i < army.length; i++) {
            army[i].showInfo();
        }
    }//end of main
}//end of class


