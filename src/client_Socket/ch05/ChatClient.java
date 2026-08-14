package client_Socket.ch05;

import java.io.IOException;
import java.net.Socket;

//소켓통신을 하기 위한 클래스
public class ChatClient extends  AbstractClient {
    public ChatClient(String name) {
        super(name);
    }

    @Override
    protected void connectToServer() {
        try {
            setSocket((new Socket("localHost", 5002)));
        } catch (IOException e) {
            System.err.println("서버측 연결 도중 예외 발생(IP, PORT 주소 확인)");
        }
    }

    public static void main(String[] args) {
        new ChatClient("홍길동").run();
    }
}
