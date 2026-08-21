package http.practice;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 핸들러(handler)란?
 * 다루다, 처리하다 라는 뜻이며 핸들러는 처리하는 쪽이라는 뜻
 * 프로그래밍에서 어떠한 일이 일어났을 때 실행될 코드를 가리킬 때 쓴다.
 */

public class TimeHandler implements HttpHandler {


    @Override
    public void handle(HttpExchange exchange) throws IOException {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = now.format(formatter);
        try{

           SimpleHttpServer.sendResponse(exchange, 200, SimpleHttpServer.TYPE_JSON,"now: " + formattedDate);

        }finally {
            exchange.close();
        }
    }
}
