package useful.ch17;

import java.util.Arrays;
import java.util.List;

//메서드 참조 --> 세미콜론 2개를 의미(::)
public class StreamDemo8 {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("a1", "bb2", "ccc3", "dddd4");
        //리스트안에 들어가 있는 각 4개의 문자열의 길이값을 확인하고 싶어!
        words.stream().map(s-> s.length()).forEach(e-> System.out.println("길이1: " + e)); //형태를 바꾸기 위한 map처리
        System.out.println("-------------------------------------------------");
        //람다식이 그 매개변수를 그대로 호출하는 형태일 때 더 짧게 줄여서 쓸 수 있다.
        words.stream().map(String::length).forEach(e -> System.out.println("길이2: " + e));

    }//end of main
}
