package http.practice;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;

/**
 * 순수 자바 코드로 구현하는 HTTP 서버!
 * ★등장 클래스★
 * 1. HttpServer: 포트를 열고 연결 받는 것을 담당
 * 2. HttpHandler: 특정 경로의 처리 로직 담당
 * 3. HttpExchange: 한 건의 요청과 응답 처리를 담당하는 클래스
 *
 * 요청이 들어올 때마다 서버가 새로 만들어 handle()에게 넘겨주고 끝나버린다.
 *
 * 소켓과 비교했을때
 * Socket           VS          HttpExchange
 * -------------------------------------------------
 * getInputStream()            getRequestBody
 * getOutputStream()           getRequestBody
 * (직접 파싱해야했다.)         getRequestMethod()
 * (직접 파싱해야했다.)         getRequestURI()
 *
 * 즉, 소켓은 바이트다 왔다 까지만 알려주며
 * HttpExchange 그 바이트를 HTTP 규칙대로 해석해 둔 결과까지 들고 왔음
 *
 */
//
public class SimpleHttpServer {
    private static final int PORT = 8080;
    private static final int THREAD_POOL_SIZE = 10;//미리 생성새두는 Thread 갯수를 의미

    static final String TYPE_HTML = "text/html; charset=UTF-8";
    static final String TYPE_TEXT = "text/plain; charset=UTF-8";
    static final String TYPE_JSON = "application/json; charset=UTF-8";

    public static void main(String[] args) throws IOException {

        //1. HTTP 서버 객체 생성 코드
        /**
         * 지금까지 쓰던 ServerSocket(8080)과 같은 일을 한다.
         *  HttpServer.create(new InetSocketAddress(PORT), 0);를 호출할 경우
         *  둘 다 이 포트로 들어오는 연결을 내가 받겠다.라고 운영체제에게 등록하는 일이다.
         *  차이는 받는 바이트를 누가 해석하느냐일 뿐이다.
         *
         *  첫번째 인자: InetSocketAddress = 주소 + 포트 번호
         *  new InetSocketAddress("127.0.0.1", 8080) 그 주소로 들어온 요청만 받는다.
         *  즉, 외부에서 오는 요청은 받을 수 없다.
         *
         *  두번째 인자: 블로킹, 대기 큐 크기
         *  서버가 아직 처리하지 못한 연결이 줄서서 기다리는 자리수이다.
         *  0이나 음수를 주면 현재 코드에서는 아마 내부적으로 50 기본값으로 바꿔서 처리함
         *  서버 안에 들어오기 전에 자리를 50개를 미리 만들어둔다.
         */
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
        //2. 경로와 담당 Handler 연결
        // / signUp < - 이러한 (약속)경로가 들어 오면 어떤 메서드(핸들러), 객체를 실행해라고 미리 정의하는 장치가 필요
        //등록 순서는 상관없음, 요청이 오면 "가장 길게 일치하는 경로"가 선택된다.
        //즉, /api/users 요청이 들어오면 "/"와 "/api/users" 둘 다 걸리지만 더 긴 쪽이 이긴다.

        //접근 경로 예시 1) http://localhost:8080/
        server.createContext("/", new HomeHandler());
        //접근 경로 예시 2) http://localhost:8080/health
        server.createContext("/health", new HealthHandler());
        //접근 경로 예시 3) http://localhost:8080/api/users
        server.createContext("/api/users", new UserApiHandler());
        //접근 경로 예시 4) http://localhost:8080/api/time
        server.createContext("/api/time", new TimeHandler());
        //접근 경로 예시 5) http://localhost:8080/api/fortune
        server.createContext("/api/fortune", new FortuneApiHandler());


        //3. 요청을 처리할 Thread Pool 지정
        //Http 서버는 멀티 스레드 프로그램이라서 미리 생성할 스레드를 지정한다.
        //매번 스레드를 새로 생성할 경우 통신이 느려짐 > 쓰고 반납하는 형태의 기법으로 개발자들이 아이디어를 냄!
        server.setExecutor(Executors.newFixedThreadPool(THREAD_POOL_SIZE));

        //4.서버 시작! main은 여기서 역할이 끝나며, 서버는 별도로 스레드에서 계속 작동한다.
        //이유: main이 끝나도 프로그램이 종료되지 않는 이유는 HttpServer가 만든 스레드가 살아있기 때문!

        server.start();
        System.out.println(">>HTTP 서버 시작<<");//NullPointerException > 만들어주어야 함

    }//end of main

    ////////////////////////////////////////////////////////////////
    //공통 메서드 정의

    /// ////////////////////////////////////////////////////////////

    //응답을 내보낸다.
    static void sendResponse(HttpExchange exchange, int statusCode, String contentType, String bodyText) throws IOException {
        //1. 보낼 데이터(매개 변수 bodyText)
        //2. 문자열을 바이트 배열로 바꾼다.
        byte[] bodyBytes = bodyText.getBytes(StandardCharsets.UTF_8);

        //3. 응답의 종류를 헤더에 적는다.(응답 HTTP 메세지)
        exchange.getResponseHeaders().set("Content-Type", contentType);

        //4. 상태코드와 본문 길이를 설정하며 헤더를 실제로 내보낸다.
        exchange.sendResponseHeaders(statusCode, bodyBytes.length);

        //5. 헤더가 나간 다음에야 본문 통로가 열린다.
        //getResponseBody() OutputStream 이므로 문자열이 아니라 바이트를 쓰고 있음
        //자원을 닫아야 하기에 try-resource 활용
        try (OutputStream out = exchange.getResponseBody()) {
            out.write(bodyBytes);
        }
    }

    //JSON으로 응답하는 경우는 다른 핸들러에서도 사용할 수 있기 때문에 이 파일에서 로직을 작성한다.
    static void sendJson(HttpExchange exchange, int statusCode, Object data) throws IOException {
//         new Gson().toJson(data) --> 자바 객체를 JSON 문자열로 변환
        sendResponse(exchange, statusCode, TYPE_JSON, new Gson().toJson(data));
    }

    //요청 본문을 문자열로 읽는 기능
    static String readRequestBody(HttpExchange exchange) throws IOException {
        StringBuffer requestBody = new StringBuffer();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(exchange.getRequestBody(), StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                requestBody.append(line);
            }
        }
        return requestBody.toString();
    }
}//end of class



