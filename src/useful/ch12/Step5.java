package useful.ch12;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Step5 {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.of(2026,8,7,10,17, 55);
        System.out.println(now); //2026-08-07T10:17 <-- 여기서 T는 Time의 약자이다. 사용자에게 바로 보여주기에는 문제가 있음
                                // 그러므로, 원하는 형식으로 포맷을 지정할 필요가 있음
        DateTimeFormatter korean = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"); //2026년 08월 07일
        System.out.println(now.format(korean));

        DateTimeFormatter clock = DateTimeFormatter.ofPattern("a hh시 mm분", Locale.KOREAN);
        System.out.println(now.format(clock)); //오전 10시 17분

        //동시에 모든 정보를 출력하고 싶을 때
        DateTimeFormatter log = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(now.format(log)); //2026-08-07 10:17:00

    }//end of main
}
