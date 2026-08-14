package io.Socket.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


//서버측 코드
public class WhileServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("---클라이언트의 연결을 기다립니다.---");
            Socket socket = serverSocket.accept();//블로킹 - 기다리는 상태
            System.out.println("--- 클라이언트 연결 완료---");

            //스트림을 소켓에서 뽑아내어 데이터를 받아낸다.
            //1. 입력/출력 스트림 준비
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); //데코레이터 패턴 방식
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            //서버측 프로그램에서 키보드에서 데이터를 받아 클라이언트로 전송 - 2. 키보드 스트림 준비
            BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));

            //클라이언트가 먼저 메세지를 보내면 ---> 서버측에서 데이터를 읽는다.
            // ---> 답을 주기 위해 키보드에서 값 입력  ---> 클라이언트에게 발송
            String line;
            while( (line = reader.readLine()) != null ){
                //프로토콜: EXIT 문자열이 들어오면 프로그램 종료
                //대소문자 구분없이 읽어들이고 싶음
                if("exit".equalsIgnoreCase(line)){
                    break;
                }
                System.out.println("클라이언트 >>" + line);
            }

            // 서버측에서 키보드의 값을 받아서 보내기
            System.out.println("--- 콘솔 로그--- 내용 입력 ---");
            //키보드에서 값을 받을 수 있는 명령어
            String serverKeyboardMessage = keyboardReader.readLine(); //Scanner의 sc.nextLine()과 같은 기능 -> 키보드에서 값을 받기 위해 대기중
            //키보드에서 입력받은 값을 클라이언트와 연결되어있는 출력스트림(writer)을 통해서 보내기
            writer.println(serverKeyboardMessage);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }//end of main
}//end of class
