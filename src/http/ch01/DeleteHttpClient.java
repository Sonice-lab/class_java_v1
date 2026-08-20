package http.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class DeleteHttpClient {
    //f-delete 브랜치 만들기
    //브랜치 이동해서 작업
    //완료 main 이동 코드 병합

    //요청 완성 주소: https://jsonplaceholder.typicode.com/posts/1

    public static void main(String[] args) {
        String baseURL = "https://jsonplaceholder.typicode.com";
        String urlString = baseURL + "/posts/1";
        HttpURLConnection connection = null;

        try {
            // 1단계 : URI로 파싱한 뒤 URL 객체로 변환
            URI uri = URI.create(urlString);
            URL url = uri.toURL();

            // 2단계 : 연결 객체 생성 (아직 연결되지 않습니다.)
            connection = (HttpURLConnection) url.openConnection();

            // 3단계 : 요청 방식 설정 (Method 등 설정)
            connection.setRequestMethod("DELETE");
            // GET 요청은 HTTP 요청메시지 HTTP 바디 영역 없는 요청이다.

            // 추가 설정도 세팅 가능
            connection.setRequestProperty("Accept", "application/json");

            // 4단계 : 이 시점에서 실제로 TCP 연결 + 요청 전송이 일어남
            int responseCode = connection.getResponseCode();
            System.out.println("응답 코드 (HTTP 상태코드) : " + responseCode);

            // 방어적 코드
            if (responseCode != 200) {
                // 실패 응답의 본문은 getInputStream()이 아니라
                // getErrorStream()으로 읽어야 한다.
                System.out.println("요청 실패!");
                return;
            }

            // 5단계 : 응답 본문 (HTTP 응답 메시지 바디 부분) 읽기
            // I/O 단원에서 배운 그대로 데이터를 추출 + 보조 스트림 (버퍼 스트림 활용)
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line).append("\n");
                }
                System.out.println("응답 내용 : ");
                System.out.println(response);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 6단계 : 연결 종료
            // HttpURLConnection : 예전에 만든 녀석이라 try-with-resources 를 사용할 수 없음.
            // 문법적으로 인터페이스 Closeable 구현하지 않아서 사용할 수 없음
            if (connection != null) {
                connection.disconnect();    // 연결 끊기
            }
        }
    }
}
