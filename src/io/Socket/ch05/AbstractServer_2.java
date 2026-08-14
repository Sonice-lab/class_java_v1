package io.Socket.ch05;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

// 채팅뿐만 아니라 다양한 형태의 서버를 만들 때 재사용할 수 있는 추상 클래스
public abstract class AbstractServer_2 {
    // 공통적으로 사용할 상수 및 변수
    protected final int port;

    // 자식 클래스에서 접근할 수 있도록 protected 접근 제어자 사용
    // 멀티스레드 환경에서 안전한 Vector 자료구조
    protected Vector<PrintWriter> clientWriterList = new Vector<>();

    // 생성자를 통해 포트 번호를 초기화
    public AbstractServer_2(int port) {
        this.port = port;
    }

    // 서버 실행 템플릿 메서드 (공통 로직)
    public void startServer() {
        System.out.println("=== 서버 시작 (Port: " + port + ") ===");
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                // 클라이언트 접속 대기 (블로킹)
                Socket socket = serverSocket.accept();
                System.out.println("클라이언트 접속, 현재 접속자: " + (clientWriterList.size() + 1) + "명");

                // 클라이언트 접속 시 구체적인 처리는 자식 클래스에게 위임 (추상 메서드 호출)
                handleClient(socket);
            }
        } catch (IOException e) {
            System.err.println("서버 실행 중 오류 발생: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    // [핵심] 자식 클래스가 반드시 구현해야 하는 추상 메서드
    protected abstract void handleClient(Socket socket);
}
