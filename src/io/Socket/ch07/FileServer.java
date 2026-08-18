package io.Socket.ch07;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 클라이언트는 서버와 미리 약속한 데이터 순서를 준수해야한다.(프로토콜)
 * 3단계
 * 1. [1바이트] 파일 이름의 길이(0~255)
 * 2. [N바이트] 파일 이름
 * 3. [나머지] 파일 내용
 */
public class FileServer {

    private static final int PORT = 5000;
    private static final String UPLOAD_DIR = "C:\\kdh\\work_space\\java_class_1\\java_v1\\uploads";

    public static void main(String[] args) {
        File dir = new File(UPLOAD_DIR);

        if (!dir.exists()) {
            boolean created = dir.mkdirs();
            System.out.println("업로드 폴더 생성: " + created);
        }

        System.out.println("멀티 클라이언트 파일 서버 시작 - 포트: " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            // 무한 루프를 돌며 다수의 클라이언트 연결을 대기합니다.
            while (true) {
                Socket socket = serverSocket.accept(); // 클라이언트 연결 수락
                System.out.println("새로운 클라이언트 연결됨: " + socket.getInetAddress().getHostAddress());

                // 파일 수신 처리를 담당할 새로운 스레드를 생성하고 실행합니다.
                Thread clientThread = new Thread(new ClientHandler(socket, dir));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 클라이언트와의 통신을 전담할 Runnable 클래스
    private static class ClientHandler implements Runnable {
        private Socket socket;
        private File dir;

        public ClientHandler(Socket socket, File dir) {
            this.socket = socket;
            this.dir = dir;
        }

        @Override
        public void run() {
            try (
                    InputStream in = socket.getInputStream();
                    OutputStream out = socket.getOutputStream()
            ) {
                // 1단계: 파일 이름의 길이 읽기 (1바이트)
                int nameLength = in.read();

                if (nameLength == -1) {
                    System.out.println("클라이언트가 아무것도 보내지 않고 종료했습니다.");
                    return;
                }

                // 2단계: 파일 이름 읽기
                byte[] nameBuffer = new byte[nameLength];
                int nameRead = 0;

                while (nameRead < nameLength) {
                    int count = in.read(nameBuffer, nameRead, nameLength - nameRead);
                    if (count == -1) {
                        throw new IOException("파일 이름을 받는 도중에 연결이 끊겼습니다.");
                    }
                    nameRead += count;
                }

                String originalFileName = new String(nameBuffer);

                // 방어적 코드: 디렉토리 트래버설 공격 방지
                if (originalFileName.contains("..") || originalFileName.contains("/") || originalFileName.contains("\\")) {
                    System.out.println("허용되지 않는 파일 이름입니다: " + originalFileName);
                    return;
                }

                // 다수 클라이언트 중복 방지: 파일명 앞에 타임스탬프 추가
                String saveFileName = System.currentTimeMillis() + "_" + originalFileName;
                System.out.println("수신할 파일 이름: " + saveFileName);

                // 3단계: 파일 내용을 받아서 서버에 저장
                File target = new File(dir, saveFileName);
                try (FileOutputStream fos = new FileOutputStream(target)) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    long total = 0;

                    while ((bytesRead = in.read(buffer)) != -1) {
                        fos.write(buffer, 0, bytesRead);
                        total += bytesRead;
                    }
                    System.out.println("저장 완료: " + target.getPath() + " (총 " + total + " 바이트)");
                }

                // 4단계: 완료 응답 전송
                String responseMsg = "업로드 성공! 저장된 파일명: " + saveFileName;
                out.write(responseMsg.getBytes());
                out.flush();

            } catch (IOException e) {
                System.err.println("클라이언트 처리 중 오류 발생: " + e.getMessage());
            } finally {
                // 스레드 종료 시 소켓 자원 해제
                try {
                    if (socket != null && !socket.isClosed()) {
                        socket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}