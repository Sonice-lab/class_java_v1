package ch02;

public class DataType3 {

    //메인 함수의 시작점
    public static void main(String[] args) {
        //기본 자료형(실수형)
        // 1.0, 0124...
        //float(4Byte), double(8Byte) 두가지 종류가 있음

        //4바이트 상자에 8바이트 크기를 넣으려니 오류가 발생
        float floatBox1 = 0.5f;
        float floatBox2 = 0.5F;
        //변수의 선언과 동시에 초기화, 접미사 f 선언을 해주어야 함, 실수형에 기본에 연산에 단위는 double 타입니다.
        // 접미사를 사용해서 자바 컴파일러에게 0.5는 double이 아닌 float 타입임을 명시해야함
        // 접미사를 표시할 경우 대소문자 모두 가능

        double doubleBox1 = 0.123;
        double doubleBox2 = 0.5;

        // 실수형 자료에서 기본 연산에 단위는 double 타입이다.
        // 왜 더 큰 8 바이트를 기본 연산으로 사용할까?
        // 값의 정확성 때문 예시) 0.1 > 0.1235456432132456456343


    }  // end of main

} // end of class
