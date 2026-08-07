package useful.ch12;

import java.time.LocalDate;
import java.time.Period;

public class Step3 {
    public static void main(String[] args) {
        //Period - 나이와 D-day 구하기
        LocalDate birth = LocalDate.of(2000, 5, 12);
        LocalDate today = LocalDate.of(2026,8,7);
        //Period 클래스 -> 년, 월, 일 세 개의 int를 하나의 묶어 담아두는 상자
        Period age = Period.between(birth, today);

        System.out.println("만 나이: " + age.getYears() + "세");//만 나이: 26세
        System.out.println("정확히: " + age.getYears() + "년" + age.getMonths() + "월" + age.getDays() + "일"); //정확히: 26년2월26일

        //Period를 객체 그래도 출력 불가!
        System.out.println(age); //P26Y2M26D -> 사람이 읽는 형식이 아님!
    }
}


