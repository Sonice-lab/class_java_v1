package oop_test.ch02;

public class Main {

    public static void main(String[] args) {

        BoardService boardService = new BoardService();
       boardService.writePost("첫 번째 글입니다", "자바 객체지향 연습을 하고 있습니다.");

    }
}

//# 실습 문제 2: 게시글 등록 흐름 구현하기
//
//## 안내 사항
//
//이 문제는 객체 생성과 메서드 호출 흐름을 연습하기 위한 실습입니다. 실제 데이터베이스(JDBC) 연결이나 SQL 동작 코드는 구현할 필요가 없으며, 요구사항에 적힌 대로 화면 출력(System.out.println)으로만 흐름이 이어지는지 확인하면 됩니다.
//
//새로운 자바 프로젝트를 만들고, 아래의 역할에 맞춰 총 4개의 클래스를 설계해 보세요.
//
//        ### 1. Board 클래스 (데이터 객체)
//
//- 필드: title (문자열), content (문자열)
//        - 기능: 필드값을 초기화하는 생성자를 만들고, 값을 가져올 수 있는 Getter 메서드를 작성하세요.
//
//        ### 2. BoardDao 클래스 (데이터 처리 객체)
//
//- 메서드: insertPost
//- 파라미터: Board 객체
//- 기능: 파라미터로 전달받은 Board 객체에서 제목을 꺼내어 "제목: [제목] - 게시글이 DB에 등록되었습니다." 라고 화면에 출력하세요.
//
//### 3. BoardService 클래스 (비즈니스 로직 객체)
//
//- 필드: BoardDao dao (객체를 생성해서 초기화해 두세요.)
//- 메서드: writePost
//- 파라미터: title (문자열), content (문자열)
//        - 기능:
//        1. 파라미터로 받은 title과 content를 이용해 새로운 Board 객체를 생성하세요.
//2. 생성한 Board 객체를 dao 객체의 insertPost 메서드 파라미터로 전달하여 호출하세요.
//
//        ### 4. Main 클래스 (실행)
//
//- 기능: main 메서드 내부에서 BoardService 객체를 생성하고, writePost("첫 번째 글입니다", "자바 객체지향 연습을 하고 있습니다.")
// 메서드를 호출하여 전체 실행 흐름이 정상적으로 동작하는지 확인하세요.
//
//        ### 5. 클래스 다이어 그램을 도구를 활용해서 직접  그려 보세요
