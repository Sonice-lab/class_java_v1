package useful.ch14;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    public static void main(String[] args) {

        //Set<String> set = new Set(); -> 인터페이스로 설계되어있기 때문에 이와 같이 객체를 생성할 수 없음
        //순서가 없고 중복된 값을 저장하지 않는다.
        Set<String> set = new HashSet<>();

        //추가
        set.add("철수");
        set.add("영희");
        set.add("철수");// 중복된 값은 덮어쓰기됨
        System.out.println(set.toString());//재정의 되어있음 -> [철수, 영희]
        System.out.println(set.size());//2

        // 포함 여부
        System.out.println(set.contains("철수")); //true
        System.out.println(set.contains("민준")); //false

        //삭제
        set.remove("철수");
        System.out.println("------------------------------------");
        //전체 순회
        //일반 for문 사용할 수 없음 -> 향상된 for문 사용 가능
        for(String name : set){
            System.out.println(name); //영희
        }
    }//end of main
}//end of class
