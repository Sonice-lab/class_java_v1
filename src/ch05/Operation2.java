package ch05;

public class Operation2 {

    //코드 실행의 시작점(메인 함수)
    public static void main(String[] args) {
        System.out.println(5 + 3);
        System.out.println(5 - 3);
        System.out.println(5 * 3);
        System.out.println(5 / (double) 3);
        // 실제 결과(1.66666666..)결과 1이 나온 이유? > 형변환 개념과 같은 것 > int / int이기에 소수점은 버림
        //5나 3 중 둘 중 하나를 형변환 시키면 소수점을 살릴 수 있음
        System.out.println(5 % 3); //나머지 연산


        // 문제
        //1. (12+3)/3을 화면에 출력해보세요. 단, 변수를 선언해서 결과값을 변수에 담아서 출력
        double n1 = (12 + 3) / 3;  //나누기 연산은 더블로 하는 것이 데이터를 잃을 확률이 없음
        System.out.println("(12 + 3) / 3 = " + n1);

        //2. (25 % 2) 값을 화면에 출력해보세요.
        int n2 = 25 % 2;
        System.out.println("(25 % 2) = " + n2);
        // 나머지 연산자는 해당하는 값이 홀수인지 짝수인지 판별할 때 유용함
        // 어떤 수를 2로 나누었을 때 나머지가 0이면 짝수, 1이면 홀수라고 판별할 수 있음

        //3. 7896456 값이 홀수인지 짝수인지 화면에 1또는 0으로 표시하세요.

        System.out.println(7896456 % 2); //0이면 짝수로 판단할 수 있음
        int result1 = 7896456 % 2;


    }//end of main
}//end of class
