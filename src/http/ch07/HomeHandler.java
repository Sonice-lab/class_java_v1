package http.ch07;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

import static http.ch07.SimpleHttpServer.TYPE_HTML;

/**
 * GET 요청 처리
 * -- 만드는 규칙 --
 * 1. HttpHandler Interface 구현
 * 2. handler(HttpExchange) 메서드 하나를 재정의한다.
 * 3. main에서 createContext로 경로를 짝지어 등록한다.
 */
public class HomeHandler implements HttpHandler {

    private static final String HOME_PAGE = """
            <!doctype html>
            <html lang="ko">
              <head>
                <meta charset="UTF-8" />
                <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                <title>나의 HTTP 서버</title>
              </head>
              <body>
                <h1 style='color:blue'>내가 자바로 만든 순수 HTTP 서버</h1>
                <ul>
                  <li><a href="/health">서버 상태 확인</a></li>
                  <li><a href="/api/users">사용자 목록(JSON)</a></li>
                </ul>
              </body>
            </html>
            
            """;

    private static final String NotFoundRoute = """
            <!doctype html>
                   <html lang="ko">
                     <head>
                       <meta charset="UTF-8" />
                       <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                       <title>404 Not Found</title>
                       <style>
                         /* 전체 화면 중앙 정렬 및 배경색 설정 */
                         body {
                           font-family:
                             -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto,
                             "Helvetica Neue", Arial, sans-serif;
                           background-color: #f1f5f9;
                           display: flex;
                           justify-content: center;
                           align-items: center;
                           height: 100vh;
                           margin: 0;
                         }
                         /* 콘텐츠를 담는 깔끔한 흰색 카드 */
                         .card {
                           background-color: #ffffff;
                           padding: 40px 50px;
                           border-radius: 12px;
                           box-shadow: 0 4px 10px rgba(0, 0, 0, 0.05);
                           text-align: center;
                         }
                         /* 제목 스타일링 */
                         h1 {
                           color: #3b82f6; /* 기존 파란색을 더 부드럽고 세련된 톤으로 변경 */
                           font-size: 28px;
                           margin-top: 0;
                           margin-bottom: 10px;
                         }
                         /* 안내 문구 추가 */
                         p {
                           color: #64748b;
                           margin-bottom: 30px;
                         }
                         /* 리스트 점 제거 및 가로 정렬 */
                         ul {
                           list-style: none;
                           padding: 0;
                           display: flex;
                           gap: 15px;
                           justify-content: center;
                           margin: 0;
                         }
                         /* 링크를 버튼 모양으로 변경 */
                         li a {
                           display: inline-block;
                           text-decoration: none;
                           color: white;
                           background-color: #3b82f6;
                           padding: 12px 24px;
                           border-radius: 8px;
                           font-weight: bold;
                           transition: background-color 0.2s ease-in-out;
                         }
                         /* 마우스 올렸을 때 색상 변화 효과 */
                         li a:hover {
                           background-color: #2563eb;
                         }
                       </style>
                     </head>
                     <body>
                       <div class="card">
                         <h1>[404] Not Found Route</h1>
                         <p>요청하신 주소를 찾을 수 없습니다.</p>
                         <ul>
                           <li><a href="/health">서버 상태 확인</a></li>
                           <li><a href="/api/users">사용자 목록 조회</a></li>
                         </ul>
                       </div>
                     </body>
                   </html>
            
            """;

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try {
            // / <-- 이 경로를 처리하는 핸들러
            // 주의할 점
            // "/" 로 등록한 핸들러는 다른 핸들러가 맡지 않은 "모든" 경로를 받아요
            // 그래서 정확히 "/" 인지 직접 확인하고, 아니면 404를 돌려 줘야 한다.
            String path = exchange.getRequestURI().getPath();
            if (!path.equals("/")) {
                SimpleHttpServer.sendResponse(exchange, 404,
                        TYPE_HTML, NotFoundRoute);
                return;
            }
            // Content-Type 을 text/html 로 보내야 브라우저야 HTML 로 해석한다.
            // text/plain 으로 보내면 태그가 글자로 보인다. (확인)
            ///SimpleHttpServer.sendResponse(exchange, 200, "text/plain; charset=UTF-8", HOME_PAGE);
            SimpleHttpServer.sendResponse(exchange, 200, TYPE_HTML, HOME_PAGE);
        } finally {
            exchange.close();
        }
    }
}
