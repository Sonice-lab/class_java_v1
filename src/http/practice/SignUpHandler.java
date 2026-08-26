package http.practice;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SignUpHandler implements HttpHandler {

    //검증기 인스턴스 생성(상태가 없으므로 하나만 만들어 재사용해도 무방!)
    private final UserValidator validator = new UserValidator();
    private final Gson gson = new Gson();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        //POST 요청만 처리
        if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {

            //1. 요청 본문(Json) 읽기 (작성해주신 공통 메서드 활용)
            String requestBody = SimpleHttpServer.readRequestBody(exchange);

            //2. JSON 문자열을 자바 객체로 변환
            UserSignUpRequest requestDto = gson.fromJson(requestBody, UserSignUpRequest.class);

            //3. UserValidator를 이용한 데이터 검증
            int idCheck = validator.validateId(requestDto.getId());
            int pwCheck = validator.validatePassword(requestDto.getPassword());

            Map<String, String> responseData = new HashMap<>();

            //4. 검증 결과에 따른 분기 처리
            if (idCheck == UserValidator.SUCCESS && pwCheck == UserValidator.SUCCESS) {
                //성공 시 HTTP 상태코드 200(OK)
                responseData.put("status", "success");
                responseData.put("message", "회원가입 검증에 통과했습니다.");
                SimpleHttpServer.sendJson(exchange, 200, responseData);
            } else {
                // 실패 시 HTTP 상태 코드 400(Bad Request)
                responseData.put("status", "fail");

                if (idCheck != UserValidator.SUCCESS) {
                    responseData.put("message", "아이디 형식이 올바르지 않습니다.(코드): " + idCheck + ")");
                } else {
                    responseData.put("message", "비밀번호 형식이 올바르지 않습니다. (코드: " + pwCheck + ")");
                }
                SimpleHttpServer.sendJson(exchange, 400, responseData);
            }
        } else {
            //POST 가 아닌 다른 메서드로 요청이 오면 405 Method Not Allowed 반환
            SimpleHttpServer.sendResponse(exchange, 405, SimpleHttpServer.TYPE_TEXT, "POST 메서드만 지원합니다.");
        }
    }
}
