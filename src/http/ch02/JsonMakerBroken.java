package http.ch02;

import java.util.ArrayList;
import java.util.List;

public class JsonMakerBroken {

    public static void main(String[] args) {
        String name = "홍\"길동\"";
        int age = 21;
        List<String> subjects = new ArrayList<>();
        subjects.add("수학");
        subjects.add("물리");
        subjects.add("C:\\java\\workpace");

        // 위 데이터를 메서들 호출해서 json 형식에 문자열로 변환하는 기능을 호출할 예정
        String jsonStr = toJson(name, age, subjects);
        System.out.println(jsonStr);

    }// end of main

    // 학생 정보를 JSON 문자열로 조립하는 기능(메서드)
    public static String toJson(String name, int age, List<String> subjects) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        // 문자열 값은 큰따옴표로 감싸야 하므로 \" 를 직접 넣어줍니다
        sb.append("\"name\" : \"").append(name).append("\",\n");
        // 숫자 값은 따옴표 없이 그대로 붙입니다
        sb.append("\"age\" : ").append(age).append(",\n");
        sb.append("\"subjects\": [\n");
        for (int i = 0; i < subjects.size(); i++) {
            sb.append("    \"").append(subjects.get(i)).append("\"");
            // 마지막 항목 뒤에는 쉼표를 붙이지 않습니다
            // 후행 쉼표는 JSON 문법 오류입니다
            if (i < subjects.size() - 1) {
                sb.append(",");
            }
            sb.append("\n");
        }
        sb.append("  ]\n");
        sb.append("}");

        return sb.toString();
    }

} // end of class


/*
실행 결과:
{
  "name": "홍"길동"",
  "age": 21,
  "subjects": [
    "수학",
    "C:\java\workspace"
  ]
}

자바 코드는 정상 실행되고 예외도 발생하지 않습니다.
하지만 출력된 문자열은 유효한 JSON 이 아닙니다.

문제 1: "홍"길동""
        값 안의 큰따옴표가 문자열의 끝으로 인식되어 구조가 깨집니다.
        올바른 표기는 "홍\"길동\"" 입니다.

문제 2: "C:\java\workspace"
        JSON 에서 역슬래시는 이스케이프 시작 문자입니다.
        \j 는 정의되지 않은 이스케이프라 파싱 오류가 납니다.
        올바른 표기는 "C:\\java\\workspace" 입니다.

*/


