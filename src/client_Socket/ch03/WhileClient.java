package client_Socket.ch03;

import com.oop14.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class WhileClient {
    public static void main(String[] args) {

        //도전 과제
        //WhileServer와 원활한 소통을 하려면 주석으로 무엇을 해야할지만 작성해보세요(준비물 등)

        //준비물 - 1. socket(끝점과 끝점을 연결할 선), 2. BufferedReader(읽기 스트림) 3. InputStreamReader(바이트에서 문자로 변환) 4. PrintWriter(쓰기 스트림)

        //구현 순서
        //1. 소켓준비(서버 IP 주소, 포트번호)
        try (Socket socket = new Socket("192.168.5.17", 5001)) {
            //2.1. 소켓과 연결된 읽기 스트림 구현(서버 ---> 클라이언트)
            //2.2. 소켓과 연결된 쓰기 스트림 구현(클라이언트 ---> 서버)
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            //3. 클라이언트 측 키보드 스트림 구현
            BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));

            String line;
            //3. 서버측으로 보낼 메세지 작성(while반복문 활용)
            while (true) {
                System.out.println("[client] 콘솔 로그 클라이언트 입력 >>>>");
                String input = keyboardReader.readLine();//블로킹 sc.nextLine();
                writer.println(input);//소켓과 연결괸 출력스트림을 사용해서 서버측에 데이터를 보냄
                if ("exit".equalsIgnoreCase(input)) {
                    break; //즉, 키보드 입력 스트림 종료
                }
                //4. 서버측으로의 응답을 수신할 수 있는 장치 작성
                //서버측에서 보낸 메세지를 받아서 클라이언트 콘솔창에 입력
                String response = reader.readLine();
                if ("exit".equalsIgnoreCase(response)) {
                    break;
                }
                System.out.println("서버측 응답: " + response);
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }//end of main
}//end of class
