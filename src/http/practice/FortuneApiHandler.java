package http.practice;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.util.Random;

/**
 * 1. 랜덤 명언(운세) API (GET /api/fortune)
 * 동작 방식: 클라이언트가 요청을 보내면, 서버가 미리 배열에 저장해 둔 명언이나 오늘의 운세 중 하나를 랜덤으로 뽑아 JSON으로 응답합니다.
 * <p>
 * 연습 포인트: GET 요청 처리, Math.random() 활용, sendJson() 메서드 사용.
 */

public class FortuneApiHandler implements HttpHandler {

    // 1. 전체 데이터는 핸들러가 가지고 있음
    private final String[] quotes = {
            "늦었다고 생각할 때가 진짜 너무 늦었다.",
            "가는 말이 고우면 얕본다.",
            "참을 인(忍) 세 번이면 호구 된다.",
            "티끌 모아 티끌이다.",
            "일찍 일어나는 새가 피곤하다.",
            "어려운 길은 길이 아니다.",
            "내일도 할 수 있는 일을 굳이 오늘 할 필요는 없다.",
            "고생 끝에 골병난다.",
            "성공은 1%의 재능과 99%의 빽이다.",
            "감사의 표시는 돈으로 하라"
    };

    // 2. DTO (응답을 예쁘게 JSON으로 만들기 위한 틀)
    static class FortuneResponse {
        String message; // 여기에 뽑힌 명언을 담을 예정.
    }
    int size = quotes.length; //10이 저장됨

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        try {
            String method = exchange.getRequestMethod();
            if (method.equals("GET")) {
                handleGet(exchange);
            } else {
                //만약, 지원하지 않는 요청이 들어왔다면? -> 405 전송
                //405를 보낼 경우 어떤 메서드가 되는지 Allow 헤더로 알려주는 것이 HTTP의 규칙이다.
                exchange.getResponseHeaders().set("Allow", "GET");
                SimpleHttpServer.sendResponse(exchange, 405, SimpleHttpServer.TYPE_TEXT, "지원하지 않는 기능입니다.(GET만 지원!)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            exchange.close();
        }
    }

    private void handleGet(HttpExchange exchange) throws IOException {
        // [힌트 1 적용] 여기에 랜덤 뽑기 로직을 작성하기!
        // 1. Random 객체 생성
        Random random = new Random();
        // 2. quotes 배열의 길이(크기) 안에서 랜덤 인덱스(int) 뽑기
        //0부터 (size -1) 사이의 숫자 중 하나가 randomIndex에 저장됨
        int randomIndex = random.nextInt(size);
        //3. 뽑힌 번호로 명언 꺼내기
        String randomQuote = quotes[randomIndex];
        // [힌트 3 적용] 뽑아낸 문자열을 DTO에 담아서 응답하기
        // 1. FortuneResponse 객체 생성
        FortuneResponse fortuneResponse = new FortuneResponse();
        // 2. 객체의 message 필드에 뽑은 명언 넣기
        fortuneResponse.message = randomQuote;
        // 3. SimpleHttpServer.sendJson(exchange, 200, 생성한DTO객체) 호출
        SimpleHttpServer.sendJson(exchange, 200, fortuneResponse.message);
    }
}

