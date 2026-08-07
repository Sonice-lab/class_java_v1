package ch07;

public class ForTest3 {
    public static void main(String[] args) {
        //1부터 100까지 수 중 총합을 구하시오.
        //1부터 100까지 중 홀수의 총합을 수하여 담아주세요.
        // 1 + 2 ...... + 99 + 100 ->
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                sum += i; //sum = sum + i;와 같음
            }
        }
        System.out.println("sum: " + sum);

        // 반복문에 증감식을 2씩 증가 시켜보자.
        for (int i = 0; i < 10; i += 2) {
            System.out.println("2씩 증가 + " + i);
        }

        //문제 - 화면에 10 9 8 7 6 5 4 3 2 1을 출력하는 코드를 작성하시오.
        for (int i = 10; i > 0; i-- ){
            System.out.print(" " + i);
        }



    } //end of main
}//end of class
