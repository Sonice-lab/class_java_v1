package test;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pricePerCup = 2500; //아메리카노 단가
        int quantity = 0; // 주문 수량

        //[요구사항 3] 오류 수정 및 예외 처리
        //0 또는 음수 입력 시 반복해서 다기 입력받도록 while문 사용
        while (true) {
            System.out.print("주문할 아메리카노 수량을 입력하세요.");
            quantity = scanner.nextInt();

            if (quantity <= 0) {
                System.out.println("1잔 이상 주문해야 합니다.\n");
            } else {
                break;
            }
        }
        //[요구사항 1] 총 금액 계산
        int totalPrice = quantity * pricePerCup;

        //[요구사항 2] 총 금액 계산 결과 출력
        System.out.println("총 결제 금액: " + totalPrice + "원");

        //[요구사항 2] 2잔 이상 구매 시 스탬프 출력 (if과 이중 for문 활용)
        if (quantity >= 3) {
            System.out.println("3잔 이상 구매 서비스 스탬프 발급:");

            //3행 3열의 별(*) 사각형 모양 출력
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++ ) {
                    System.out.print("* ");
                }
                System.out.println(); //한 행을 출력한 후 줄바꿈
            }
        }
        scanner.close(); //스캐너 종료
    }
}
