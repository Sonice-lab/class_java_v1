package http.ch02;

import java.util.ArrayList;
import java.util.List;

public class JsonMaker {

    public static void main(String[] args) {
        String name = "홍길동";
        int age = 21;
        List<String> subjects = new ArrayList<>();
        subjects.add("수학");
        subjects.add("물리");
        subjects.add("컴퓨터과학");

        // 위 데이터를 메서드 호출해서 json 형식의 문자열로 변환하는 기능을 호출할 예정
        String jsonStr = toJson(name, age, subjects);
        System.out.println(jsonStr);


    }//end of main

    // 학생 정보를 JSON 문자열로 조립하는 기능(메서드)
    public static String toJson(String name, int age, List<String> subjects) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("\"name\" : \"").append(name).append("\",\n");//문자열
        sb.append("\"age\" : ").append(age).append(",\n"); //숫자
        sb.append("\"subjects\" : [\n");

        //한 과목씩 한 줄로 띄워서 하는 방법?-?
        for (String subject : subjects) {
            sb.append(subject).append(",\n"); //문자배열
        }

        sb.append("]\n");
        sb.append("}\n");

        return sb.toString();
    }

}
/*
실행 결과:
{
  "name": "홍길동",
  "age": 21,
  "subjects": [
    "수학",
    "물리",
    "컴퓨터 과학"
  ]
}
*/



