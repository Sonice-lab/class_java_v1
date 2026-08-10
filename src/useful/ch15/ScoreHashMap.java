package useful.ch15;

import java.util.HashMap;
import java.util.Map;

public class ScoreHashMap {
    public static void main(String[] args) {

        Map<String, Integer> scores = new HashMap<>();

        //추가(put) - 키 값은 중복될 수 없다.
        //put()을 사용해서 키 값이 중복된다면 앞의 값에 덮어씌우기가 된다.
        //이 특징을 활용하면 업데이트 기능을 구현할 수 있다.
        scores.put("철수", 90);
        scores.put("영희", 85);
        scores.put("민준", 92);
        scores.put("철수", 100); //덮어쓰기 되었음! 90이 사라짐!
        System.out.println(scores);

        // 조회 방법(get)
        System.out.println(scores.get("철수")); //90 -> 키가 있으면 Value 반환
        System.out.println(scores.get("없는키")); //키가 없을 경우 null 반환

        //포함 여부
        System.out.println(scores.containsKey("철수")); //true -> 키 존재 여부 확인
        System.out.println(scores.containsValue(85)); //true -> 값 존재 여부 확인

        //삭제 방법
        int removedResult = scores.remove("철수");
        System.out.println(removedResult + "(이)가 삭제되었습니다."); //90
        System.out.println(scores); //{영희=85, 민준=92} -> map에서는 중괄호로 표현

        //크기 확인
        System.out.println(scores.size());

        //map 구조는 인덱스가 없음
        //전체 순회
        for (String k : scores.keySet()) {
            System.out.println(k + ":" + scores.get(k) + "점"); //키를 꺼내면 값이 나온다.
        }


    }//end of main
}//end of class
