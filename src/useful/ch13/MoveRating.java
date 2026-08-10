package useful.ch13;

import java.util.ArrayList;
import java.util.List;

public class MoveRating {

    public static void main(String[] args) {

        List<String> movies = new ArrayList<>();

        movies.add("범죄도시 -*****");
        movies.add("기생충 -****");
        movies.add("올드보이 -****");
        movies.add("태권브이 -**");

        System.out.println("=== 전체 영화 목록 ===");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println(i + " ." + movies.get(i)); //인덱스로 꺼내기
        }

        //총 몇 편인가?
        System.out.println("\n총 " + movies.size() + "편");

        //올드보이를 삭제하고 싶다.
        //movies.remove("올드보이 -****"); //요소로 삭제 -> 인덱스로 삭제하는 것이 편리!
        movies.remove(2);
        System.out.println("---------------------------------------");
        System.out.println("\n총 " + movies.size() + "편");

        //기생충 영화 여부 확인
        System.out.println("기생충 존재 여부 확인: " + movies.contains("기생충")); // 기생충 존재 여부 확인: false -> 요소 검색할 때는 완전히 같아야 한다.
        System.out.println("기생충 존재 여부 확인: " + movies.contains("기생충 -****")); //기생충 존재 여부 확인: true

    }//end of main
}//end of class
