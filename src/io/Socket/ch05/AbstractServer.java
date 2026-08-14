package io.Socket.ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//[서버측] 코드의 가독성을 높이기 위한 추상 클래스 설계
public abstract class AbstractServer {

    private String name;
    private Socket socket;
    private PrintWriter socketWriterStream;
    private BufferedReader socketreaderStream;
    private BufferedReader keyboardReaderStream;

    //생성자 생성
    public AbstractServer(String name){
        this.name = name;
    }

    //메서드를 통해서 socket을 주입받을 수 있음
    public  void setSocket(Socket socket){
        this.socket = socket;
    }

    //순서를 미리 정하는 메서드
    //메서드에 final 선언 > 오버라이딩은 할 수 없지만 호출은 가능!
    public final void run(){

            //스트림을 연결하기 위함
            connectToServer();
        //   setupStreams();
            startCommunication();

    }



    //상속받은 자식 클래스는 무조건 이 메서드를 재정의해야한다.(강제성 부여) - 추상 메서드
    protected abstract void connectToServer();

    private void setupStreams() throws IOException {
        socketWriterStream = new PrintWriter(socket.getOutputStream(), true);
        socketreaderStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        keyboardReaderStream = new BufferedReader(new InputStreamReader(System.in));
    }

    private void startCommunication() {
        //1. 클라이언트에서 보낸 데이터 받기
        Thread readThread = new Thread(()->{
            String msg;

            try{
                while((msg = socketreaderStream.readLine()) != null){
                    System.out.println(msg);

                }

            } catch(Exception e){
                System.err.println("서버와의 연결이 끊겼습니다.");
            }
        });
    }

}
