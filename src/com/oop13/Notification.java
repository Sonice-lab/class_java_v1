package com.oop13;

/**
 * 알림 전송 클래스 Notification 만들기
 * <p>
 * 우리는 메시지를 보낼 때 단순히 내용만 보낼 때도 있고, 받는 사람을 지정할 때도 있습니다.
 * 메서드 오버로딩을 이용해 send라는 이름 하나로 다양한 알림을 보내는 코드를 완성해 보세요.
 * <p>
 * ### 요구사항
 * <p>
 * 1. send(String message) : 메시지 내용만 출력합니다. (예: "일반 알림: [내용]")
 * 2. send(String message, int count) : 메시지를 입력받은 횟수만큼 반복해서 출력합니다.
 * 3. send(String receiver, String message) : 받는 사람과 내용을 출력합니다. (예: "[받는사람]님에게 메시지: [내용]")
 */

//클래스 설계
public class Notification {

    //1. send(String message) : 메시지 내용만 출력합니다. (예: "일반 알림: [내용]")
    public void send(String message) {
        System.out.println("일반 알림: [" + message + "]");
    }

    //2.  메시지를 여러번 반복해거 보내는 메서드(for) - 오버로딩
    public void send(String message, int count) {
        System.out.println("반복 알림 전송...");
        for (int i = 0; i < count; i++) {
            send(message);
        }
    }

    //3. 받는 사람을 지정해서 보내는 메서드 - 오버로딩
    public void send(String receiver, String message) {
        System.out.println("[" + receiver + "]님에서 보내는 메세지: [" + message + "]");
    }


    //메인 함수(테스트 코드로 작성해보기)
    public static void main(String[] args) {

        Notification notification = new Notification();
        System.out.println("---------1번 호출----------");
        notification.send("내용");
        System.out.println("---------2번 호출----------");
        notification.send("졸면 안돼요!", 3);
        System.out.println("---------3번 호출----------");
        notification.send("홍길동", "내용");


    }// end of main
}//end of class
