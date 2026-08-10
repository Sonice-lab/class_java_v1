package useful.ch13;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MyStore {

    public static void main(String[] args) {

        //방법 1. ArrayList 타입을 선언
        ArrayList<String> list1 = new ArrayList<>();

        //방법 2. List 타입으로 선언
        // 인터페이스는 왜 최상위에 있을까? 기능의 규약, 규칙 -> 추상 메서드로 설계
        // 하위에 구현된 클래스들은 똑같이 인터페이스와 구현되어야 한다.
        // 리스트 계열
        List<String> list2 = new ArrayList<>();

        //3. 추가하는 방법
        // 방법 1.
        //array[0] = "";
        list1.add("사과"); //요소가 있다면 맨 끝에 항상 추가, 앞에 아무것도 없었기 때문에 0번째 인덱스에 추가
        //방법 2.
        list1.add(1, "포도"); //인덱스 1 위치에 추가
        //list1.add(1, 3); --> 컴파일 오류 발생!

        //조회
        list1.get(0);
        list1.size();// 실제 안에 들어가 있는 요소의 갯수
        list1.contains("사과");//자료 구조안의 포함 여부를 true, false 값으로 출력
        list1.indexOf("사과");//위치 반환: - . 인덱스가 몇번째에 있는가? 없으면 보통 -1을 반환

        //삭제
        list1.remove("사과"); //값으로 삭제
        list1.remove(0); //인덱스로도 삭제 가능
        list1.clear();//전체 삭제

        //확인
        list1.isEmpty(); //메모리 공간 안의 요소가 없고 비어있는지 여부 확인 true, false로 반환

        System.out.println("-------------------------------------------");

        //리스트를 활용하여 제공해주는 메서드를 직접 작성하고 결과를 출력하세요.
        // 연습해보기.
        // 수정 가능한 ArrayList 생성
        List<String> names = new ArrayList<>();
        names.add("kim");
        names.add("lee");
        names.add("park");

        System.out.println("원본 리스트: " + names);

        //2. 람다식을 활용하여 모든 요소를 대문자로 변경!
        names.replaceAll(name -> name.toUpperCase());
        System.out.println("대문자 변경 후: " + names);

        //3. 메서드 참조(Method Refference) 스타일 사용
        names.replaceAll(String::toLowerCase);
        System.out.println("소문자 원복 후: " + names);

        //4. 각 이름에 접두사(Prefix) 붙이기
        names.replaceAll(name -> "개발자_" + name);
        System.out.println("접두사 추가 후: " + names);

    }//end of main
}//end of class
// 배열로 채팅 접속자 관리
