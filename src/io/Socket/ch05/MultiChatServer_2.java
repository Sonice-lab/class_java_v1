package io.Socket.ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// 추상 클래스를 상속받아 '멀티 채팅' 기능에 집중한 자식 클래스
public class MultiChatServer_2 extends AbstractServer_2 {

    // 부모 클래스의 생성자 호출
    public MultiChatServer_2(int port) {
        super(port);
    }

    // 부모 클래스의 추상 메서드 오버라이딩 (구체적인 클라이언트 처리 로직)
    @Override
    protected void handleClient(Socket socket) {
        // 클라이언트가 연결되면 새로운 스레드 객체를 생성하고 즉시 실행(start)
        new ClientHandler(socket).start();
    }

    // 내부 클래스로 스레드 구현 (기존과 동일하되 가독성을 위해 분리 유지)
    private class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // 입출력 스트림 초기화
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // 부모 클래스가 가지고 있는 접속자 리스트에 현재 클라이언트 스트림 추가
                clientWriterList.add(out);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("수신: " + message);
                    // 모든 클라이언트에게 메세지 브로드캐스트
                    broadcast(message);
                }
            } catch (Exception e) {
                System.err.println("클라이언트 통신 오류: " + e.getMessage());
            } finally {
                // 클라이언트 종료 시 리스트에서 제거 및 소켓 자원 반납
                clientWriterList.remove(out);
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        System.err.println("소켓 종료 오류: " + e.getMessage());
                    }
                }
                System.out.println("클라이언트 퇴장, 현재 접속자: " + clientWriterList.size() + "명");
            }
        }

        private void broadcast(String msg) {
            // 부모 클래스의 clientWriterList를 순회하며 메세지 전송
            for (PrintWriter w : clientWriterList) {
                w.println(msg);
            }
        }
    } // end of inner class

    // 실행 엔트리 포인트
    public static void main(String[] args) {
        // 포트 번호 5002를 주입하여 채팅 서버 객체 생성 및 실행
        MultiChatServer_2 chatServer = new MultiChatServer_2(5002);
        chatServer.startServer();
    }
}
