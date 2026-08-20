package http.ch03;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class TodoListClient {
    public static void main(String[] args) {
        //1단계: HTTP 통신을 활용한 복수건 조회
        String urlString = "https://jsonplaceholder.typicode.com/todos";
        HttpURLConnection conn = null;

        try {// 연결할 수 있는 객체만 만든 단계
            URL url = new URL(urlString);
            conn = (HttpURLConnection) url.openConnection();

            //HTTP 프로토콜 설정
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode(); //통신 진행
            System.out.println("응답 코드 확인" + responseCode); //200 통신 요청 성공
            // 방어적 코드
            if (responseCode != 200) {
                System.out.println("요청 실패!");
                return;
            }

            //응답 본문(HTTP 메세지 body 영역에서 내용 추출)
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }

                //GSON 라이브러리 활용
                Gson gson = new Gson(); //자동으로 파싱해줌

                //JSON Array 형태 파싱 처리
                // fromJson(문자열, 변환 타입)이 여기에서 사용됨
                //코드 흐름의 설정 1. 타입 지정
                TypeToken<List<Todo>> typeToken = new TypeToken<List<Todo>>() {
                };
                //2. 설계된 타입에 실제 파싱 처리
                List<Todo> todoList = gson.fromJson(sb.toString(), typeToken.getType());// 이렇게 쓰자고 약속! <T>

                System.out.println("전체 개수: " + todoList.size());
                System.out.println("---------------------------------------");
                //반복문을 활용하여 상위 3개만 출력해보자.
                for (int i = 0; i < 3; i++) {
                    System.out.println(todoList.get(i));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //모든 동작 후 연결 끊기
            if (conn != null) {
                conn.disconnect();
            }
        }
    }//end of main
}


