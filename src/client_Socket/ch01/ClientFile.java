package client_Socket.ch01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientFile {

    public static void main(String[] args) {

        try (Socket socket = new Socket("192.168.5.17", 5000)) {
            System.out.println("클라이언트: 서버에 연결했습니다.");

            //서버측으로 메세지를 보내기 위한 출력스트림 사용
            //socket.getOutputStream();
            //socket + PrintWriter: autoFlush 처리됨

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("안녕하세요! 저는 두부인데요! 사실 벽돌이랍니다!>< 제 데이터가 보이시나여?-? 꺄르륵꺄르륵");

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }//end of main
}//end of class


