package useful.ch03;

public class StringTest1 {

    public static void main(String[] args) {
        String s1 = "aaa"; //heap메모리 안에 상수풀에 들어 있는 객체를 가리킴
        String s2 = "aaa";
        String s3 = new String("aaa");//heap메모리에 올리는 방식
        String s4 = new String("aaa");

        System.out.println("s1==s2: " + (s1 == s2)); //true
        System.out.println("s3==s4: " + (s3 == s4)); //false
        System.out.println("s3.equals.(s1): " + s3.equals(s1)); //true
        //왜 그럴까? 메모리 위치 특성때문에 그러한 부분이 있음
        //한번 생성한 문자열은 다시 만들지 않음
        //미리 만들어 진 것이 있다면 다시 생성하지 않음 > 그러므로 s1과 s2는 같은 객체를 바라보고 있음
        //== 는 주소값(참조) 비교한다.
        //Object의 equals() 기본 동작은 주소값 비교이지만,
        //String의 equals()를 내부적으로 재정의되어있어 "문자열 내용"을 비교한다
        //즉, 논리적 동등성 비교함
        //결론: 문자열을 논리적으로 비교할 때 무조건 == 대신 equals()를 사용해야 함

        //aaa + a
        s1 += "a";
        System.out.println(s1); //aaaa --> 상수풀에서 aaaa를 생성해냄, 전에 생성해 둔 aaa는 그대로 있음 -> String은 불변이다.

    }//end of main
}//end of class
