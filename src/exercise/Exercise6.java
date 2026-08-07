package exercise;

import java.util.Scanner;

public class Exercise6 {

    //코드 실행의 시작점
    public static void main(String[] args) {
        //연습 문제 1 : 짝수의 합 계산하기
        //자바를 사용하여 1부터 사용자가 입력한 숫자까지의 모든 짝수의 합을 계산하는 프로그램을 작성해보세요.
        // 이 프로그램은 사용자로부터 숫자 하나를 입력받고, 그 숫자까지의 짝수들만을 더한 결과를 콘솔에 출력합니다.
        // 이때, for 반복문을 단일로 사용하여 문제를 해결해야 합니다.
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력하세요: ");
        int maxNumber = scanner.nextInt();

        int sum = 0;

        // ... 코드를 작성해주세요

        for (int i = 1; i <= maxNumber; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println("짝수의 합: " + sum);
        scanner.close();
    } //end of main
}//end of class
