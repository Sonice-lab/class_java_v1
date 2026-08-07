package useful.ch12;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Step6 {
    /**도전과제
     * 아래 정보를 순서대로 출력하는 프로그램을 작성하세요.
     * *요구사항**
     * 1. 생일이 무슨 요일이었는지 (한글로)
     * 2. 기준 날짜 시점의 만 나이
     * 3. 태어난 지 총 며칠이 지났는지
     * 4. 기준 날짜부터 크리스마스까지 D-day ( ChronoUnit  )
     * 5. 기준 시각을 "2025년 05월 13일 오후 02시 30분" 형식으로 출력
     * **기대 출력**
     * 생일 요일: 금요일
     * 만 나이: 25세
     * 살아온 날: 9132일
     * 크리스마스까지: 226일
     * 현재: 2025년 05월 13일 오후 02시 30분
     */
    public static void main(String[] args) {
        //1. 생일이 무슨 요일이었는지 (한글로)
        LocalDate birthday = LocalDate.of(2009, 12, 31);
        System.out.println("My Birthday Day: " + birthday.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN));

        //2. 기준 날짜 시점의 만 나이
        //Period 년/월/일을 따로 담는다. 년 자리만 꺼내면 만 나이가 된다.
        LocalDate today = LocalDate.now();
        Period age = Period.between(birthday, today);
        System.out.println("만 나이: " + age.getYears() + "세");

        //3. 태어난 지 총 며칠이 지났는지
        //년/월/일로 쪼개지 않고 "날짜"라는 하나의 단위로 환산 -> ChronoUnit
        long daysBetween = ChronoUnit.DAYS.between(birthday, today);
        System.out.println("살아온 날: " + daysBetween + "일");

        //4. 기준 날짜부터 크리스마스까지 D-day ( ChronoUnit  )
        // 가. 기준 날짜: FullStack 개발자 과정을 수강한 날 -> 2026-7-21
        //순서 주의: (기준일, 목표일) 순으로 넣어야 양수가 나옴
        LocalDate lectureStart = LocalDate.of(2026, 7, 21);
        LocalDate christmas = LocalDate.of(2026, 12, 25);
        long daysBetween2 = ChronoUnit.DAYS.between(lectureStart, christmas);
        System.out.println("크리스마스까지: " + daysBetween2 + "일");

        //5. 기준 시각을 "2025년 05월 13일 오후 02시 30분" 형식으로 출력
        // a  : 오전/오후  (Locale.KOREAN이 있어야 한글로 나온다)
        // hh : 12시간제, 두 자리 (HH는 24시간제라 14로 나옴)
        // mm : 분  (MM은 월이므로 절대 혼동 금지)
        LocalDateTime now = LocalDateTime.of(2025,5,13,14,30);
        DateTimeFormatter log = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 a hh시 mm분", Locale.KOREAN);
        System.out.println(now.format(log));
    }
}
