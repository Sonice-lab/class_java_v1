package useful.ch17;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamOnceDemo4 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3);
        Stream<Integer> stream = numbers.stream();

        System.out.println("첫번째 사용: " + stream.count());
        //System.out.println("두번째 사용: " + stream.count()); //IllegalStateException - 컨베이어 벨트가 첫번쨰사용에서 끝났기 때문에 예외 발생
        //stream은 일회성이다.
        // 해결 방법? 한번 더 사용하고 싶다면? -> 새로 하나 더 생성하면 됨!
        System.out.println("두번째 사용(단 새로 생성): " + numbers.stream().count());

    }//end of main
}//end of class


