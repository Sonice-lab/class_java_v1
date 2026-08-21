package http.ch07;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 데이터를 담는 클래스 DTO
 * <p>
 * GSON은 "자바 객체"와 "JSON 문자열"을 서로 바꿔주는 라이브러리이다.
 * 그러려면 먼저 담을 그릇, 즉 클래스가 있어야 한다.
 * <p>
 * 필드 이름이 곧 JSON의 키가 된다.
 * {"id" : 1, "name" : "홍길동", "email" : "abc@naver.com"}
 *
 */
@Data
//생성자 오버로딩 기법
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
