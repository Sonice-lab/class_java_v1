package client_Socket.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MultiThreadClient {
    public static void main(String[] args) {
        //도전 과제
        //필요한 준비물을 주석으로 먼저 작성하기!
        //준비물
        //1. socket(끝점과 끝점을 연결할 선), 2. BufferedReader(읽기 스트림)
        //3. InputStreamReader(바이트에서 문자로 변환) 4. PrintWriter(쓰기 스트림)
        //1. 소켓 준비(서버 IP 주소, 포트번호)
        try (Socket socket = new Socket("192.168.5.101", 5002)) {
            System.out.println("서버가 연결되었습니다.");
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));

            //읽기 스레드 만들기(서버측에서 들어온 데이터를 계속 받을 수 있도록 처리)
            Thread readThread = new Thread(() -> {

                try {
                    String serverMessage;
                    while ((serverMessage = reader.readLine()) != null) {
                        //프로토콜1 - exit 생성
                        if ("exit".equalsIgnoreCase(serverMessage)) {
                            System.out.println("서버가 종료를 원합니다.");
                            break;
                        }
                        //프로토콜2 - 이모지를 입력하면 문자로 축하메세지 생성
                        if ("🎉".equalsIgnoreCase(serverMessage)) {
                            System.out.println("서버측에서 축하메세지를 보내왔습니다.");
                            break;
                        } else {
                            System.out.println(serverMessage);
                        }
                    }
                } catch (Exception e) {
                    System.err.println("서버가 강제종료되었습니다.");
                }
            });
            //쓰기 스레드(클라이언트측 키보드값을 입력받아서 서버측으로 전송)
            Thread writeThread = new Thread(() -> {
                String clientMessage;
                try {
                    while ((clientMessage = keyboardReader.readLine()) != null) {
                        writer.println(clientMessage);
                        //프로토콜 상황을 클라이언트 상태창에 남기고 싶다면 작성
                        if ("exit".equalsIgnoreCase(clientMessage)) {
                            System.out.println("클라이언트가 종료되었습니다.");
                            break;
                        }
                        if ("🎉".equalsIgnoreCase(clientMessage)) {
                            System.out.println("서버측에 축하메세지를 보냈습니다.");

                        }
                    }
                } catch (Exception e) {
                    System.out.println("메세지 전송 중 오류가 발생했습니다.");
                }
            });

            readThread.start();
            writeThread.start();

            //메인스레드를 종료시키면 다른 스레드도 실행되지 않기 때문에 join처리를 해주어야 한다.
            readThread.join();
            writeThread.join();

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //2.1. 소켓과 연결된 읽기 스트림 구현(서버 ---> 클라이언트) -> 스레드 구현 1.
        //2.2. 소켓과 연결된 쓰기 스트림 구현(클라이언트 ---> 서버) -> 2.2와 3을 묶어서 스레드 구현 2.
        //3. 클라이언트 측 키보드스트림 작성

        //4. 서버측으로 보낼 메세지 작성(while 반복문 활용)

        //5. 서버측으로의 응답을 수신할 수 있는 장치 작성
        //서버측에서 보낸 메세지를 받아 클라이언트 콘솔창에 입력

    }//end of main
}//end of class
