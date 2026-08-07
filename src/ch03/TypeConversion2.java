package ch03;

/**
 * 형변환이란?
 * 데이터의 타입을 다른 타입으로 변경하는 것
 * - 자동 형변환, 강제 형변환
 */
public class TypeConversion2 {

    //코드의 시작점
    public static void main(String[] args) {
       //자동 형변환 코드 작성해보기
        short shortDataBox = 5;
        int intDataBox;

        intDataBox = shortDataBox;

        // 강제 형변환 코드 작성해보기
        final int N1 = 33333;
        short shortBox = (short) N1;


        // 결과 출력해보기
        System.out.println("intDataBox: " + intDataBox);
        System.out.println("shortBox: " + shortBox);



    } //end of main
} //end of class
