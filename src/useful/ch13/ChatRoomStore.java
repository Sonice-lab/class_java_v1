package useful.ch13;

import java.util.ArrayList;
import java.util.Vector;

public class ChatRoomStore {
    //인터페이스 설계이기에 사용하는 방법은 같다.
    //단일 스레드 프로그램 - ArrayList
    //멀티 스레드 프로그램 - vector 사용
    private static Vector<String> users = new Vector<>();//list 계열 - ArrayList, Vector 모두 아래의 코드를 수정하지 않아도 똑같이 동작함

    public synchronized static void main(String[] args) throws InterruptedException {

        // 사전 기반 지식 - stack (고유 자기 메모리이기 때문에 다른 스레그사 접근 못함)
        System.out.println("=== 채팅방 접속자 시뮬레이션 ===");

        Thread t1 = new Thread(new Runnable() {//익명 구현 클래스
            @Override
            public void run() {
                users.add("철수");
                System.out.println("[접속] 철수 | 현재: " + users.size() + "명");
            }
        });//여기까지가 객체 생성!

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                users.add("영희");
                System.out.println("[접속] 영희 | 현재: " + users.size() + "명");
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                users.add("민준");
                System.out.println("[접속] 민준 | 현재: " + users.size() + "명");
            }
        });

        t1.start();
        t2.start();
        t3.start();
        //내 스레드가 동작이 끝날 때까지 메인 스레드에게 대기해!(동기화 처리)
        t1.join(); //예외 처리
        t2.join();
        t3.join();

        //퇴장
        users.remove("영희");//영희 퇴장

        //브로드 캐스트(방송한다.) 현재 접속한 사용자들에게 메세지를 보내
        for (String u : users) {//초기화 for 문 -> 일반 for문과 반복한다는 개념은 같음
            System.out.println("->" + u + "에게 전송 : 안녕하세요.");
        }
        System.out.println("최종 접속자: " + users);
        //스레드는 메인 스레드까지 총 4개가 작성되어짐
        //우선순위를 정할 순 있지만 완벽하게 처리되지는 못함

    }//end of main
}//end of class
