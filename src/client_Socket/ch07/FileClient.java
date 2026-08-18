package client_Socket.ch07;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class FileClient {

    // 로컬 환경에서 테스트할 경우 "127.0.0.1" 또는 "localhost"를 사용하세요.
    private static final String HOST = "127.0.0.1"; // 서버 IP 주소
    private static final int PORT = 5000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //String filePath = sc.nextLine();
        System.out.println("전송할 파일 경로 예) C:\\work_java\\test.txt ");

        // 전송할 파일의 경로를 지정합니다.
        String filePath = "C:\\kdh\\work_space\\java_class_1\\java_v1\\assets\\a.txt";

        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            System.out.println("파일이 존재하지 않거나 폴더 경로입니다: " + filePath);
            return;
        }

        String fileName = file.getName(); //--> test.txt 만 추출됨
        byte[] nameBytes = fileName.getBytes();

        if (nameBytes.length > 255) {
            System.out.println("파일 이름이 너무 깁니다. (최대 255바이트)");
            return;
        }

        System.out.println("서버로 전송 시도: " + fileName + " (" + file.length() + " 바이트)");

        try (Socket socket = new Socket(HOST, PORT)) {
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();

            // 1단계: 파일 이름의 길이 전송 (1바이트)
            out.write(nameBytes.length);

            // 2단계: 실제 파일 이름 전송
            out.write(nameBytes);

            // 3단계: 실제 파일 내용 전송
            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }
            out.flush();

            // 4단계: 전송 완료 신호 (출력 스트림 닫기)
            socket.shutdownOutput();
            System.out.println("파일 데이터 전송을 완료하고 서버의 응답을 기다립니다...");

            // 5단계: 서버 응답 수신
            byte[] responseBuffer = new byte[1024];
            int responseLength = in.read(responseBuffer);
            if (responseLength > 0) {
                System.out.println("서버 응답: " + new String(responseBuffer, 0, responseLength));
            }

        } catch (UnknownHostException e) {
            System.err.println("서버를 찾을 수 없습니다: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("통신 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}