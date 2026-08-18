package io.Socket.ch06;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//파일 서버 직접 구축하기 - AWS의 개념도 들어있음

public class FileServer {

    private static final int PORT = 5000;
    private static final String UPLOAD_DIR = "C:\\kdh\\work_space\\java_class_1\\java_v1\\uploads"; //절대 경로를 작성해도 실행됨

    //정상적으로 프로그램을 이해하기 위해서는 서버와 클라이언트의 약속이 필요하다. --> 프로토콜의 개념
    // 파일의 이름, 데이터, 실제내용 필요
    //프로토콜의 3단계
    //[1바이트]를 먼저 지정하여 파일 이름의 길이를 약속한다.(0~255까지 셋팅) -> [1][1][1][1][1][1][1][1]
    //[N바이트] 파일 이름
    //[나머지] 파일 내용(클라이언트가 출력방향을 닫으면 -1, 즉, 끝이 난다.(eof = end of file))

    public static void main(String[] args) {

        //File 객체 작성하기 - 실제 파일이나 폴더가 아닌 경로가 적힌 쪽지를 작성한다.
        //아래 한 줄로는 uploads 폴더가 만들어지지 않는다.
        //그냥, uploads라는 경로를 가리키는 객체가 메모리에 하나 생긴 상황인 것이다.
        //UPLOAD_DIR: 다양한 편의 기능과 필수적인 기능을 제공함
        File dir = new File(UPLOAD_DIR);

        if (!dir.exists()) {
            //파일에서 제공하는 mkdirs()를 호출하는 순간 비로소 실제 폴더를 만들 수 있음
            //mldir()과 다르게 중간 경로까지 한 번에 만들어준다.
            boolean created = dir.mkdirs();
            System.out.println("업로드 폴더 생성: " + created);
        }

        System.out.println("파일 서버 시작 - 포트: " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            Socket socket = serverSocket.accept();//연결될 때까지 여기서 블로킹 상태
            System.out.println("클라이언트 연결됨: " + socket.getInetAddress().getHostAddress());
            //소켓에 연결된 입출력 스트림 준비
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            //----------------------------------------------
            //1단계: 파일 이름의 길이 읽기 (약속! - 1바이트)
            //----------------------------------------------

            //byte가 아니라 int로 돌려주는 이유
            //byte -128~127 "끝(-1)"을 표현할 자리가 없음
            //따라서, 0~255는 데이터를 구분해서 -1이 들어오면 끝신호로 구분해서 씀(read())
            int nameLength = in.read();//1바이트만 받기

            //방어적 코드
            //이 검사를 빼면 아래에서는 new byte[-1]이 되어 오류가 발생한다.
            //상황1) 클라이언트가 파일을 보내지 않고 통신을 끊었을 경우
            if(nameLength == -1){
                System.out.println("클라이언트가 아무것도 보내지 않고 종료했습니다.:)");
                return;

            }
            System.out.println("파일의 이름 길이: " + nameLength + "바이트로 들어올 것으로 확인됨");

            //----------------------------------------------
            //2단계: 파일 이름을 정확하게 nameLength 만큼 읽기
            //----------------------------------------------

            byte[] nameBuffer = new byte[nameLength];
            //정확한 파일 길이를 모르기 때문에 읽는 부분에 대한 변수를 할당해야함
            // 읽어서 채운 바이트 수를 나타낸다.
            int nameRead = 0;

            //이해하는 데 어려움이 있을 수 있음
            //이 while 문의 문법이 이번 예제의 가장 중요한 부분이라 할 수 있다.
            //read(값을 담을 배열, 시작 위치, 최대객수(최대 몇개까지 될지))는 요청한 만큼 반드시 읽어준다는 "보장이 없다."
            //이유: 네트워크의 사정(크래픽이 몰린다던지, 다른 네트워크에서 파일이 들어온다던지...)에 따라 총 30 byte의 파일을 받는다고 했을 때, 첫번째 3바이트만 올 수도 있음!
            // 길이만큼 다 찰 때까지 계속 도는 while문 코드
            while(nameRead < nameLength){
                int count = in.read(nameBuffer, nameRead, nameLength - nameRead);
                if(count == -1){
                    throw new IOException("파일 이름을 받는 도중에 연결이 끊겼습니다.ㅠㅠ");
                }
                //예외가 아니라면 받은만큼 커서를 앞으로 민다. 이 줄이 없으면 무한 루프로 빠져버림
                nameRead += count;
            }
            //예시) 클라이언트가 a.zip을 보내온다고 가정했을 때 ---> [5][a][.][z][i][p][....파일내용]

            String fileName = new String(nameBuffer); //byte 단위로 들어온 데이터를 문자열로 생성시킬 수 있음

            //방어적 코드: 파일을 보낼 때 악의를 가진 클라이언트가 "../../비밀.txt"와 같은 이름을 보낼 경우
            //../ -> 나가라는 의미이기 때문에 읽는 순간 root 프로젝트로 나가거나 아예 밖에서 파일이 생성될 수 있음
            //이를 방지하기 위한 방어적 코드가 필요함
            if(fileName.contains("..") || fileName.contains("/") || fileName.contains("\\")){
                System.out.println("허용되지 않는 파일 이름입니다.: " + fileName);
                return;
            }
            System.out.println("수신할 파일 이름: " + fileName);

            //----------------------------------------------
            //3단계: 파일 내용을 받아서 서버츳 컴퓨터 디스크에 저장
            //----------------------------------------------

            //여기서까지 과정에서도 아직 파일은 만들어지지 않았음! -> 다만, 경로를 가리키는 객체일 뿐이다.
            File target = new File(dir, fileName);//uploads를 감싸는 객체만 만든 상황

            //FileOutputStream 생성자가 실행되는 순간 비로소 디스크에 실제 파일이 생긴다.
            //있을경우, 내용이 지워지고 새로 시작됨

            FileOutputStream fos = new FileOutputStream(target);// 드디어 파일 생성 완료!><

            byte[] buffer = new byte[4096]; //4KB 운영체제가 디스크를 다루는 단위와 맞춤 크기
            int bytesRead;
            long total = 0;

            //클라이언트가 shutdownOutput()을 호출하면 (즉, 클라이언트가 소켓 종료(close) 전에 -1을 보낼 수 있다.)
            //신호가 도착하면 read() 가 -1을 반환한다.
            while((bytesRead = in.read(buffer)) != -1){
                fos.write(buffer, 0, bytesRead);
                total += bytesRead;
            }
            System.out.println("저장 완료: " + target.getPath() + " 총 " + total + " 바이트 " );

            //----------------------------------------------
            //4단계: 완료 응답 전송
            //----------------------------------------------

            //클라이언트는 출력 방향만 닫은 상태가 되며, 입력 방향은 살아있으므로 서버가 보낸 응답을 정상적으로 받을 수 있다.
            out.write(("업로드 성공!" + fileName).getBytes());
            out.flush(); //통로에 남은 데이터를 다 밀어낸다.

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }//end of main
}
