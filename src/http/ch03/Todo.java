package http.ch03;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//생성자 오버로딩 -> 단순 실습! 여기서 이 부분을 생략해도 코드는 잘 작동한다.
@NoArgsConstructor
@AllArgsConstructor

//Data는 아래와 같이 반드시 설정해주어야 함
@Data
public class Todo {
//받을 JSON을 확인하여 그릇(클래스)를 만듬
// JSON 의 키 이름과 자바 필드 이름을 맞춰서 설계합니다
// {"userId":1, "id":1, "title":"...", "completed":false}
   private int userId; //"userId"
   private int id; //"id"
   private String title; //"title"
   private boolean completed; //"completed"
}



/**
 * {
 *         "userId": 3,
 *             "id": 50,
 *             "title": "cupiditate necessitatibus ullam aut quis dolor voluptate",
 *             "completed": true
 *     }
 */



