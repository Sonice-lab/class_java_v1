package com.oop11;

public class ArrayTest2 {
    public static void main(String[] args) {

        //문자열을 사용하는 방법
        //방법 1
        String s1 = "안녕"; //참조 타입, 생성과 동시에 초기화
        //방법 2
        String s2 = new String("안녕"); // 객체를 따로 class설계하지 않아도 바로 사용 가능

        //문자열로 배열을 사용해보자.
        String[] names = new String[5]; //값을 초기화하지 않았기 때문에 각 칸에는 null이 들어간다.

        //인덱스 연산자를 활용하여 값을 초기화
        names[0] = "김씨";
        names[1] = "나씨";
        names[2] = "박씨";

        //인덱스 연산자를 활용하여 값을 조회해보자.
        System.out.println(names); // [Ljava.lang.String;@b4c966a > 객체의 Heap메모리, 주소값 출력 [][][][][] 생성됨
        System.out.println(names[0]); //김씨
        System.out.println(names[1]); //나씨
        System.out.println(names[2]); //박씨

        //인덱스 연산자를 통해서 값을 수정해보자.
        names[0] = "Mr Kim";
        names[1] = "Mr Na";
        names[2] = "Mr Park";

        System.out.println(names[0]);

        //인덱스 연산자를 통해서 값을 삭제 String <--  값이 없을 경우 null로 초기화
        //null: 가리키는 주소가 없다.
        names[0] = null;
        names[1] = null;
        names[2] = null;

        System.out.println(names[0]);
        System.out.println(names[1]);
        System.out.println(names[2]);
        System.out.println(names[3]);
        System.out.println(names[4]);

        //System.out.println(names[5]); // 배열의 길이를 벗어난 잘못된 입력값, 실행시 예외(오류)발생: ArrayIndexOutOfBoundsException
                                        //프로그램이 뻗어버려 다음 아래의 코드를 실행할 수 없다.

        System.out.println("배열의 길이: " + names.length);//길이를 나타내는 것, 이 배열의 길이는 얼마인가?
        System.out.println("배열의 인덱스 크기: " + (names.length - 1));//인덱스의 길이

    }//end of main
}//end of class
