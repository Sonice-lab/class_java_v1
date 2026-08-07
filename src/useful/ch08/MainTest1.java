package useful.ch08;

public class MainTest1 {
    public static void main(String[] args) {
        //1단계: 박싱과 언박싱을 직접 호출해서 확인해보자.
        int num = 3;
        Integer num2 = Integer.valueOf(3); //객체로 취급할 때 쓰는 코드 > 박싱: int --> Integer 객체

        int num3 = num2.intValue(); //기본 데이터 타입에 잘 들어감 --> 언박싱: Integer ---> int

        System.out.println(num2);
        System.out.println(num3);//num2와 num3은 크게 다르지 않게 3으로 똑같이 출력됨

        //자바 5버전부터 자동 박싱, 자동 언박싱을 제공하고 있음

        //2단계: 자동 박싱/ 자동 언박싱 제공
        Integer num4 = 17; //컴파일 시점에서 오류없이 잘 들어감 --> 자동 박싱, 오토 박싱
                           // 컴파일러가 Integer.valueOf(17);로 변환함
        int num5 = num4; //자동 언박싱: 컴파일러가 num4.intValue()로 자동 변환해줌
    }//end of main
}//end of class
