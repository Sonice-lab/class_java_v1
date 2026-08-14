package io.Socket.ch02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServerFile2 {
    //내 자리 IPv4 주소 . . . . . . . . . : 192.168.5.11 -> 친구찾아가는 것
    //채팅 기능 구현 가능
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("서버측 프로그램 시작 - 포트번호: 5000에서 대기중 ....");
            //클라이언트를 기다리는 명령어
            //클라이언트가 내 IP 주소와, 포트번호를 사용해서 연결할 때까지 이 줄에서 멈춤(블로킹)
            Socket socket = serverSocket.accept();

            //읽기 스트림 문자기반, 클라이언트 ---> 서버
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //쓰기스트림(문자기반), 서버 ---> 클라이언트
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            //클라이언트가 보낸 데이터 한 줄 읽기
            String message = reader.readLine(); //데이터가 올 때까지 대기 상태
            System.out.println("클라이언트 메세지: " + message);

            //서버가 클라이언트로 응답 메세지 보내기
            writer.println("안녕! 나는 두부야!!!");


            //2. 텍스트 파일에 메시지 옆에 일시 출력하기
            //가. 현재 시간 구하기 및 포맷 지정(원하는 형태로 변경 가능)
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formateNow = now.format(formatter);

            //서버측에서 클라이언트가 온 메세지를 파일에 저장하는 기능 만들기
            //1. 파일 생성

            try (FileWriter fw = new FileWriter("assets/clientMessage.txt", true)) {
                fw.write(message + "[" + formatter + "]" + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }//end of main
}


