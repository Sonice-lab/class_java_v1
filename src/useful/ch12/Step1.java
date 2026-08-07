package useful.ch12;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class Step1 {
    public static void main(String[] args) {
        //1. 지금 이 순간(실행시점) 날짜/시간 가져오기
        LocalDate today = LocalDate.now(); //날짜만 출력
        LocalDateTime now = LocalDateTime.now(); // 날짜와 시간 출력
        System.out.println("오늘 날짜: " + today); //오늘 날짜: 2026-08-07
        System.out.println("현재 시각: " + now); // 현재 시각: 2026-08-07T09:35:23.376660 -> 수정이 필요! 초단위까지 계산해서 나옴

        System.out.println("----------------------------------------------");
        //원하는 날짜를 직접 설정할 수 있다.
        LocalDate birthday = LocalDate.of(1995,5,19); //객체 생성과 동시에 값 초기화
        System.out.println("My Birthday: " + birthday); //My Birthday: 1995-05-19
        System.out.println("생일 요일: " + birthday.getDayOfWeek()); //생일 요일: FRIDAY

        //만약 날짜 표기를 한국어로 표현하고 싶다면?
        System.out.println("생일 요일: " + birthday.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN));// .getDisplayName -> 텍스트 스타일 지정 -> 출력 결과 -> 생일 요일: 금요일


    }//end of main
}//end of class
