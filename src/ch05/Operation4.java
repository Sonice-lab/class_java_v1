package ch05;

import javax.crypto.spec.PSource;

/**
 * 증감, 감소 연산자 ++, --
 * 부호연산자와 다르게 변수에 직접 접근에 오직 1증가, 감소를 시키는 연산자
 */

public class Operation4 {
    public static void main(String[] args) {

        int value1 = 1;
        //증감 연산자
        value1++;
        System.out.println("value1 " + value1);
        //방법 1. value1 = value1 + 1;
        //방법 2. value1 += 1;
        //방법 3. value1++;

        //감소연산자
        int value2 = 1;
        value2--;
        System.out.println("value2: " + value2);
        //방법 1. value2 = value2 + 1;
        //방법 2. value1 -= value2;
        //방법 3. value1--;

        System.out.println("----------------------------------------------");

        //2.1 - 증감 연산자가 항 앞에 올 경우 (전위 연산자) ++10;
        //2.2 - 증감 연산자가 항 뒤에 올 경우 (후위 연산자) 10++;
        //증감 전위 연산자 사용
        int data1 = 10;
        int temp1 = ++data1;
        System.out.println("temp1: " + temp1);

        //증감 후위연산자 사용
        int data2 = 10;
        int temp2 = data2++;//세미콜론한 뒤(다음줄로 넘어갈 때)에 +1이 담김
        //temp2 = data2++;
        System.out.println("temp2: " + temp2);

        //증감 후의 연산자를 쓸 때 변수에 접근해서 값이 1증가 되는 것은 맞음. 단, ;(세미콜론)이 끝난 이후
        //항이 하나 있을 때 확인
        int data3 = 10;
        int data4 = 10;

        ++data3;
        data4++;
        System.out.println("data3: " + data3);
        System.out.println("data4: " + data4);

        //반복문을 제외하고 전위 연산자를 사용하는 게 권장사항

        //문제 1. 전위 감소 연산자, 후위 감소 연산자를 사용하고 결과를 출력하시오.

        int data5 = 99;
        int temp5 = --data5;
        System.out.println("temp5: " + temp5);

        int data6 = 99;
        int temp6 = data6--;
        //temp6 = data6--;
        System.out.println("temp6: " + temp6);


        int data7 = 99;
        int data8 = 99;

        --data7;
        data8--;
        System.out.println("data5: " + data7);
        System.out.println("data6: " + data8);



    } //end of main
} //end of class
