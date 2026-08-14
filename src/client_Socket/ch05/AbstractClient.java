package client_Socket.ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//코드의 가독성 높이기
public abstract class AbstractClient {

    private String name;
    private Socket socket;
    private PrintWriter socketWriterStream;
    private BufferedReader socketReaderStream;
    private BufferedReader keyboardReaderStream;

    public AbstractClient(String name) {
        this.name = name;
    }

    //생성자를 주입하지 않더라도 setter를 통해 생성자와 같은 역할을 할 수 있음
    //메서드를 통해서 socket을 주입 받을 수 있다.
    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    //메서드에 final 선언했을 경우 오버라이딩을 할 수 없다. 다만, 호출만 할 수 있다.
    //순서를 미리 정하는 메서드
    public final void run() {

        try {
            connectToServer(); //스트림을 연결하기 위함
            setupStreams();
            startCommunication();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    //상속받은 자식 클래스는 무조건 이 메서드를 재정의해야한다.(강제성 부여)
    protected abstract void connectToServer();

    private void setupStreams() throws IOException {
        socketWriterStream = new PrintWriter(socket.getOutputStream(), true);
        socketReaderStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        keyboardReaderStream = new BufferedReader(new InputStreamReader(System.in));
    }

    private void startCommunication() throws InterruptedException {
        //1.서버에서 보낸 데이터 받기
        Thread readThread = new Thread(() -> {
            String msg;

            try {
                while ((msg = socketReaderStream.readLine()) != null) {
                    System.out.println(msg);
                    //프로토콜 생략!
                }
            } catch (Exception e) {
                System.err.println("서버와의 연결이 끊겼습니다.");
            }
        });
        //2. 키보드에서 값을 받아서 서버로 메세지 전송
        Thread writeThread = new Thread(() -> {

            try {

                String input;
                while ((input = keyboardReaderStream.readLine()) != null) {
                    socketWriterStream.println("[" + name + "]" + " "+ input);
                }
            } catch (IOException e) {
                System.err.println("메세지 전송 중 오류 발생!");
            }
        });

        readThread.start();
        writeThread.start();

        readThread.join(); //run의 메서드에서 호출
        writeThread.join();
    }
}
