package useful.ch12;

import java.time.Duration;
import java.time.LocalTime;

/**
 * 내 코드는 얼마나 걸릴까?
 * 1부터 1억까지 더하는 로직이 실제로 몇 밀리초 걸리는지 측정하는 프로그램입니다.
 * 로직이 실제로 얼마나 걸리는지 출력 하시오.
 */

public class Step7_Ver_2 {

    public static void main(String[] args) {
        // start 시간, end 시간
        // end - start = 소요시간
        LocalTime start = LocalTime.now();

        int sum = 0;
        for (int i = 1; i <= 100_000_000; i++) {
            sum += i;
        }
        LocalTime end = LocalTime.now();
        Duration result = Duration.between(start, end);

        System.out.println("시작 시간 : " + start);
        System.out.println("종료 시간 : " + end);
        System.out.println("소요 시간 : " + result.toMillis() + "ms");
    }
}
