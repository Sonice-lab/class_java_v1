package useful.ch12;

/**
 * 내 코드는 얼마나 걸릴까?
 * 1부터 1억까지 더하는 로직이 실제로 몇 밀리초 걸리는지 측정하는 프로그램입니다.
 *로직이 실제로 얼마나 걸리는지 출력 하시오.
 */

public class Step7 {

    public static void main(String[] args) {
        //1. 시작 시간 기록(나노초 기준)
        long startTime = System.nanoTime();
        long sum = 0;

        for (int i = 1; i <= 100_000_000; i++) {
            sum += i;
        }

        //2. 끝 시간 기록
        long endTime = System.nanoTime();
        System.out.println("모든 수의 총합: " + sum);
        System.out.println(endTime);

    }

}
