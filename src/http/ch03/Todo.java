package http.ch03;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//생성자 오버로딩
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
//받을 JSON을 확인하여 그릇(클래스)를 만듬
   private int userId;
   private int id;
   private String title;
   private boolean completed;

}



/**
 * {
 *         "userId": 3,
 *             "id": 50,
 *             "title": "cupiditate necessitatibus ullam aut quis dolor voluptate",
 *             "completed": true
 *     }
 */
