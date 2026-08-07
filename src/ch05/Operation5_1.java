package ch05;

public class Operation5_1 {

    public static void main(String[] args) {

        //게임 캐릭터 상태 설정
        int playerHealth = 50; // 플레이어의 회복
        int playerLevel = 10; // 플레이어의 레벨
        int enemyHealth = 30; // 적군 체력
        int ecemyLevel = 15; //적군 레벨

        //1. 플레이어의 체력이 적군의 체력보다 높은지 확인하는 코드를 작성하고 출력

        //boolean result1 = playerHealth > enemyHealth;//true
        //System.out.println("result1: " + result1);
        //또는
        System.out.println(playerHealth > enemyHealth);

        //2. 플레이어 체력이 위험 수준인 20 이하 인지 확인

        //boolean result2 = playerHealth <= 20;
        //System.out.println("result2: " + result2);
        //또는
        System.out.println(playerHealth <= 20);

        //3. 플레이어와 적의 체력이 같은지 확인

        //boolean result3 = playerHealth == enemyHealth;
        //System.out.println("result3: " + result3);
        //또는
        System.out.println(playerHealth == enemyHealth);
        //4. 플레이어의 특정 레벨이 30이상인지 확인

        //boolean result4 = playerLevel >= 30;
        //System.out.println("result4: " + result4);
        //또는
        System.out.println(playerLevel >= 3);

        //주의사항 - 경계값 포함 여부
        //이하  <= 경계값이 포함됨
        //이상  >=  경계값이 포함됨
        //미만  <    경계값이 포함안됨
        //초과  >    경계값이 포함안됨


        //5. 플레이어의 체력이 30미만인 지 확인하는 코드 작성
        System.out.println(playerHealth < 30);

        //6. 플레이어의 체력이 50 초과하는지 확인하는 코드 작성
        System.out.println(playerHealth > 50);

    }

}
