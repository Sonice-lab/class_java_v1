package io.Socket.ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;

//[서버측] 코드의 가독성을 높이기 위한 추상 클래스 설계
public abstract class AbstractServer {

    //공통적으로 사용할 상수 및 변수 선언
    private static final int PORT = 5002;


    //자식클래스에서 접근할 수 있도록 protected 접근제어자 사용
    //멀티스레드 환경에서 안전한 Vector 자료 구조
    protected static Vector<PrintWriter> clientWriterList = new Vector<>();

    //생성자를 통해 포트 번호를 초기화


    //서버 실행 템플릿메서드(공통 로직)

    //자식 클래스가 반드시 구현해야하는 추상 메서드

}
