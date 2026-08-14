package io.Socket.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer {
    //프로토콜 하나씩 더 만들어보기
    //  예시1) /이모지를 입력하면 이모지 출력
    //기능 1 -> 어떤 이을 해라.
    //메인스레드
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("=== 서버 실행! ===");
            Socket socket = serverSocket.accept();
            System.out.println("=== 클라이언트가 연결되었습니다. ===");
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));

            //1.언제든지 읽을 수 있도록 reader에 스레드 붙이기
            //읽기 스레드 만들기: 클라이언트에게 온 메세지만 수신함
            Thread readThread = new Thread(() -> {
                String clientMessage;
                try {
                    while ((clientMessage = reader.readLine()) != null) {

                        //프로토콜 1.
                        if ("exit".equalsIgnoreCase(clientMessage)) {
                            System.out.println("클라이언트가 종료를 원합니다.");
                            break;
                        }
                        System.out.println("[클라이언트]" + clientMessage);

                        //프로토콜 2.
                        if("🎉".equalsIgnoreCase(clientMessage)){
                            System.out.println("클라이언트측에서 축하메세지를 보내왔습니다.");
                            break;
                        }
                    }
                } catch (IOException e) {
                    //throw new RuntimeException(e);
                    System.err.println("클라이언트가 강제로 연결을 끊었습니다.");
                }
            });

            //2. 키보드에 값을 읽어서 writer에 보내도록 묶어서 스레드에 붙이기
            //쓰기 스레드 만들기 ---> 키보드에서 값을 입력받아서 클라이언트에게 전달시키는 장치
            Thread writeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    String serverMessage;
                    try {
                        while ((serverMessage = keyboardReader.readLine()) != null) {

                            if ("exit".equalsIgnoreCase(serverMessage)) {
                                writer.println(serverMessage);
                                System.out.println("서버가 종료되었습니다.");
                                break;
                            }
                            writer.println("[서버] 응답메세지: " + serverMessage);//\n이 포함되어있음을 의미

                            if ("🎉".equalsIgnoreCase(serverMessage)) {
                                writer.println(serverMessage);
                                System.out.println("축하 메세지 전송 완료!");

                            }
                            writer.println("[서버] 응답메세지: "  + serverMessage);
                        }


                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            readThread.start();
            writeThread.start();

            //메인스레드에게 내가 종료될 때까지 대기해! > join처리
            readThread.join();
            writeThread.join();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
