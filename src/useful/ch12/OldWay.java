package useful.ch12;

//사전 기반지식으로 아래의 내용을 학습해보자!

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class OldWay {
    public static void main(String[] args) {

        //Date - JDK1 버전에 만들어진 클래스
        //1. 현재 시간 출력하기
        Date now = new Date();
        System.out.println("현재 시각: " + now); //현재 시각: Fri Aug 07 09:20:05 KST 2026

        //문제발생! 출력 형식이 영어 요일과 월 이름이 섞여 있어서 사용자 화면에 그대로 쓸 수 없음!

        //2. Date로 특정 날짜 만들기
        Date date = new Date(2025, 4, 12);
        System.out.println("설정한 날짜: " + date); //설정한 날짜: Tue May 12 00:00:00 KST 3925
        //3925로 년도 오류! -> Date의 연도는 1900년을 기준으로 세기 때문! 2025년으로 출력하려면 125를 넣어야 함!
        Date date2 = new Date(125, 4, 12); //Date month 는 0부터 시작! -> 4월로 출력하고 싶은데 5월로 출력됨
        System.out.println("설정한 날짜2: " + date2); //설정한 날짜2: Mon May 12 00:00:00 KST 2025
        //위와 같은 번거로움 때문에 JDK 1.1부터 곧바로 Calendar 클래스를 만들어야 함!

        System.out.println("------------------------------------");
        // JDK 1.1에서 Data 타입에 대한 대안
        Calendar cal = Calendar.getInstance(); //new 하여 객체 생성하는 개념과 같음 <-- 싱글톤 패턴이 구현되어있어 메서드로 호출되어야 함
        cal.set(2025,4,12);
        System.out.println(cal.getTime()); //Mon May 12 09:26:54 KST 2025 -> 역시 의도한 4월이 아닌 5월로 인식!

        //위 문제들을 해결하기 위해 8버전부터 java.time 패키지를 제공함

        LocalDate localDate = LocalDate.of(2025,4,12);//4월은 그냥 4월
        System.out.println("설정한 날짜: " + localDate); //설정한 날짜: 2025-04-12 -> 의도된 대로 출력됨 야호야호!

    }//end of main
}//end of class
