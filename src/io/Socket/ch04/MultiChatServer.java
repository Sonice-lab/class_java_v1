package io.Socket.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

//채팅 서버를 만들어서 누군가가 이 서버에 메세지를 보내면 다른 클라이언트에게 해당 메세지를 발송함 -> 직접 채팅을 치는 것이 아님!
public class MultiChatServer {
    //상수 선언
    private static final int PORT = 5002;
    //Vector는 멀티스레드 환경에서 안전한 동작을 한다.(why) --> 동기화 처리가 자동으로 되어있음
    //준비물
    private static Vector<PrintWriter> clientWriterList = new Vector<>();


    //내부 클래스 생성 및 스레드 상속
    private static class ClientHandler extends Thread {
        //멤버변수로 소켓을 가질 수 있도록 선언
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        //생성자 생성
        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        //run 메서드가 Thread.start() 시 일하도록 약속되어있는 메서드이다.
        @Override
        public void run() {
            //스트림
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //추후 브로드캐스드(접속자들에게 방송하기 위해서 생성된 출력스트림을 자료 구조에 저장한다.)
                clientWriterList.add(out);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("수신: " + message);
                    //A, B, C 누구든지 연결된 사람이 있다면
                    //받은 메세지를 현재 연결된 모든 클라이언트에게 전송(브로드캐스트)
                    broadcast(message);

                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                //클라이언트가 강제 종료 및 우리만의 프로토콜 exit 값이 넘어오면
                //서버측에서 관리하고 있는 자료구조에서 출력스트림을 제거해야한다.
                clientWriterList.remove(out); //출력 스트림 제거
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        private void broadcast(String msg) {
            for (PrintWriter w : clientWriterList) {
                //자료 구조에 저장된 출력스트림을 전체 꺼내서 하나씩 메세지 전송!
                w.println(msg);
            }
        }

    }//end of inner class


    public static void main(String[] args) {
        System.out.println("=== 서버 시작 ===");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                //소켓 생성
                Socket socket = serverSocket.accept(); //블로킹 상태
                //클라이언트가 연결되면 새로운 객체를 생성하고 연결된 소켓 객체 주소값을 해당 클래스 필드에 할당한다.
                // ClientHandler또한 Thread라고 볼 수 있기 때문에 바로 start() 처리 가능
                new ClientHandler(socket).start();
                System.out.println("클라이언트 접속, 현재 접속자: " + clientWriterList.size() + "명");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }//end of main
}//end of class
