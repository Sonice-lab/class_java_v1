package http;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

//Scanner에서 값을 받는 원리와 비슷하다.
//다른 주소에서 다른 데이터를 받을 수 있다.
// 이 파일에서 http 통신으로 접근할 서버 주소
// https://jsonplaceholder.typicode.com  < -- 서버주소
//                                     /todos/1  < --end point
//요청 완성 주소: https://jsonplaceholder.typicode.com/todos/1
public class SimpleHttpClient {

    public static void main(String[] args) {
        String baseURL = "https://jsonplaceholder.typicode.com";
        String urlString = baseURL + "/todos/2";
        //String urlString = "https://www.google.com/?hl=ko"; //https: -> https: 통신으로 암호화해서 요청하고 받겠다. -> 암호화가 가미된 요청 방식
        HttpURLConnection connection = null;//객체 생성 전


        try {
            //1단계: URI로 파싱한 뒤 URL 객체로 변환
            URI uri = URI.create(urlString);
            URL url = uri.toURL();

            //2단계: 연결 객체 생성(아직 연결되지 않습니다.)
            connection = (HttpURLConnection) url.openConnection(); //소켓통신에서 소켓을 감싸는 역할을 함 > 형변환

            //3단계: 요청방식 설정(Method 등 설정) > 데이터를 가져옴 > HTTP 메서드의 GET
            connection.setRequestMethod("GET");
            //GET 요청은 HTTP 요청 메세지에 HTTP 바디 영역이 없는 요청이다.

            //추가 설정도 셋팅 가능
            connection.setRequestProperty("Accept", "application/json");

            //4단계: 이 시점에서 실제로 TCP 연결 + 요청 전송 발생
            int responseCode = connection.getResponseCode();
            System.out.println("응답 코드(HTTP 상태코드)" + responseCode);

            //방어적 코드 작성
            if (responseCode != 200) {
                //실패 응답의 본문의 getInputStream()이 아닌
                //getErrorStream()으로 읽어야 함 --> error 만 던짐
                System.out.println("요청 실패!");
                return;
            }

            //데이터 추출하기
            //5단계: 응답 본문(HTTP 응답 메세지 body 부분) 읽기
            // I/O 단원에서 배운 데이터를 추출할 수 있음 + 보조스트림(버퍼 스트림 활용)
            //connection은 socket을 의미
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder response = new StringBuilder();// 단일 스레드에서 더 빠름
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line).append("\n");
                }
                System.out.println("응답 내용: ");
                System.out.println(response);
            }


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            //6단계: 연결 종료
            // HttpURLConnection: 예전에 만든 녀석이라 try-with-resources를 사용할 수 없음
            //문법적으로 인터페이스 Closeable을 구현하지 않아서 사용할 수 없음

            if(connection != null){
                connection.disconnect(); //연결 끊기
            }
        }

    }//end of main

}
