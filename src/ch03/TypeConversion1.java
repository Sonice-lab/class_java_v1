package ch03;
/**
 * 형변환이란?
 * 데이터의 타입을 다른 타입으로 변경하는 것
 * - 자동 형변환, 강제 형변환
 */
public class TypeConversion1 {

    //코드의 시작점
    public static void main(String[] args) {
        int intDataBox = 100;
        double doubleDataBox;

        //1. 자동 형변환 예시
        //8바이트 상자 = 4바이트 상자
        doubleDataBox = intDataBox; //자동 형변환함.화살표를 누르는 시점 = 런타임 시점
        System.out.println("doubleDataBox: " + doubleDataBox);

        //2. 강제 형변환 예시
        final double PI = 3.14159;
        // 컴파일러야, 괜찮으니까 그냥 강제로 집어넣어! > (자료형)
        int intBox = (int) PI; //코드를 작성하는 시점 + Ctrl S = 컴파일 시점
        System.out.println("intBox: " + intBox); //강제 형변환하여 소수점을 버려버림! > 강제형변환 시 데이터 손실 가능성 있음

        //연습
        double interestRate;
        int discount;

        interestRate = 15.5;
        //아래 오류나는 문법을 해결하고 결과를 출력하시오.
        discount = (int) interestRate;

        System.out.println("discount: " + discount);

        float floatBox = 10.5f;

    } //end of main
} //end of class
