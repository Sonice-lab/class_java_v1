package http.ch04;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class UserClient {
    public static void main(String[] args) {
        //1단계: HTTP 통신을 활용한 단건 조회
        String urlString = "https://jsonplaceholder.typicode.com/users/1";
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
                //fromJaon(json 문자열, 변환할 클래스)
                User user = gson.fromJson(sb.toString(), User.class);
                System.out.println("파싱 결과");
                //System.out.println(user);

                System.out.println(user.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            //모든 동작 후 연결 끊기
            if(conn != null){
                conn.disconnect();
            }
        }
    }//end of main
}
