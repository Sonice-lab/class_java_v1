package http.ch07;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// /api/users -
//GET 메서드 목록을 조회한다.
//POST를 활용해서 새 사용자를 등록한다.
public class UserApiHandler implements HttpHandler {

    //실제로는 DB에 저장한다. 지금은 메모리 리스트로 대신한다. 즉, 서버를 껐다 켜면 내용이 모두 사라진다.
    private static final List<User> userList = new ArrayList<>(); //오류를 방어하기 위해 동기화 처리가 필요함

    //공통 인스턴스 생성
    // 다음에 부여할 id
    private static int nextId = 1;

    //새로운 문법!) static 초기화 블럭
    //클래스가 메모리에 처음 올라갈 때 딱 한 번만 실행되는 코드 묶음
    //이름이 없음(익명), 우리가 직접 호출하지 않음 0 > JVM이 알아서 실행
    static {
        addUser(new User("홍길동", "a@naver.com"));
        addUser(new User("김철수", "c@naver.com"));
    }


    private static synchronized int addUser(User user) {
        user.setId(nextId); // 최초에 생성한 객체 1이 쏙 들어감!
        nextId++;
        userList.add(user);
        return user.getId();
    }


    //요청이 들어오면 무슨일을 해야하는지 코딩
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try {
            // /api/users 경로 + Method(동작을 정의하는 요소) - GET, POST
            // 즉, 경로가 같아도 Method가 다르다면 하는 일이 다름
            // 그렇기에 이 핸들러 안에서 메서드로 한번 더 갈라 주어야 한다.
            String method = exchange.getRequestMethod();
            if (method.equals("GET")) {

                Thread.sleep(2000);

                handleGet(exchange);
            } else if (method.equals("POST")) {
                handlePost(exchange);
            } else {
                // 만약 지원하지 않는 요청이 들어왔다면? 405라고 보낼것임
                // -> 405를 보낼때는 어떤 메서드가 되는지 Allow 헤더로 알려주는 것이 HTTP의 규칙이다.
                exchange.getResponseHeaders().set("Allow", "GET, POST");
                SimpleHttpServer.sendResponse(exchange, 405, SimpleHttpServer.TYPE_TEXT, "지원하지 않는 메서드입니다.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            exchange.close();
        }
    }

    //    목록을 복사해서 다시 돌려준다.
//    왜 복사하는가?
//    원본을 그래도 넘길 경우 Gson이 JSON으로 바꾸면서 순회 도중에
//    다른 스레드가 POST로 add 요청을 만약 한다면 중간에 예외가 발생함!
//    즉, 순회 도중에 ArrayList의 크기가 바뀌면 예외를 던지는 증상이 있다.
    private ArrayList<User> copyUserList() {
        return new ArrayList<>(userList);
    }

    // GET: 사용자 목록을 조회, (요청 HTTP 메세지 body 없음)
    //List<User>를 그대로 넘기면 Gson이 Json 배열로 바꿔줌
    private void handleGet(HttpExchange exchange) throws IOException {
        // sendJson 호출
        SimpleHttpServer.sendJson(exchange, 200, copyUserList());
    }

    /**
     * POST 요청: 요청 본문(HTTP 요청 메세지 바디)이 있음
     */

    private void handlePost(HttpExchange exchange) throws IOException {
        //1. HTTP 요청 본문 바디를 읽어야 한다.
        String requestBody = SimpleHttpServer.readRequestBody(exchange);
        System.out.println("POST 요청[api/users] 받은 본문 확인: " + requestBody);

        //2. JSON 문자열을 User 객체로 변환한다.
        User user;
        try {
            user = new Gson().fromJson(requestBody, User.class);
        } catch (JsonSyntaxException e) {
            SimpleHttpServer.sendResponse(exchange, 400, SimpleHttpServer.TYPE_TEXT, "JSON 형식이 올바르지 않습니다.");
            return;
        }

        //3. 검증하기
        if (user == null || user.getName().isBlank()) {
            SimpleHttpServer.sendResponse(exchange, 400, SimpleHttpServer.TYPE_TEXT, "name은 반드시 있어야 합니다.");
            return;
        }
        if (user.getEmail() == null) {
            user.setEmail("");
        }

        //4. 저장처리 id 값은 고정값이 아니라서 저장 결과를 다시 돌려준다.
        int newId = addUser(user);

        //5. 등록 성공은 200 대신 201로 Created로 응답을 한다.
        SimpleHttpServer.sendJson(exchange, 201, user);
    }
}//end of class
