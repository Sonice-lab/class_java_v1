package practice;

import javax.swing.*;
import java.awt.*;

public class MyBoarderFrameVer_2 extends JFrame {

    //배열로 변경
    //1. 문자열로 배열을 사용하기
    //배열과 동시에 초기화(필요하다면 변수 및 배열을 선언해서 활용할 수 있다.)
    private JButton[] buttons;
    //String 배열
    private String[] directions = {BorderLayout.NORTH, BorderLayout.SOUTH, BorderLayout.CENTER, BorderLayout.WEST, BorderLayout.EAST};
    private BorderLayout borderLayout;


    public MyBoarderFrameVer_2() {
        //팝업 박스 크기 설정
        setTitle("borderLayout 연습");
        setSize(600, 400);
        setVisible(true);//기본값
        //화면의 x를 누르면 동시에 프로그램도 종료 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//클래스 이름으로 접근하는 변수 - static 상수 변수 Ctrl + 좌클릭

        initData();
        setInitLayout();
    }

    public void initData() {
        //JButton 초기화 완료
        //배열과 for문 활용
        borderLayout = new BorderLayout(); //객체 생성
        buttons = new JButton[5];

//        buttons[0] = new JButton("버튼1");
//        buttons[1] = new JButton("버튼2");
//        buttons[2] = new JButton("버튼3");
//        buttons[3] = new JButton("버튼4");
//        buttons[4] = new JButton("버튼5");

        //위의 주석에 대한 부분을 아래와 같이 수정할 수 있음
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("버튼" + (i + 1));
        }
    }

    public void setInitLayout() {
        //배치 관리자 선정을 하고 Frame 설정해보자.
        setLayout(borderLayout);//Frame 에 배치관리자 설정
        //이제 배치만 하면됨
        //border레이아웃은 add할 때 동 서 남 북 가운데를 명시해주어야 함
        //배열과 for문 활용 - String
//        add(button1, BorderLayout.NORTH);
//        add(button2, BorderLayout.SOUTH);
//        add(button3, BorderLayout.CENTER);
//        add(button4, BorderLayout.WEST);
//        add(button5, BorderLayout.EAST);

//        super.setLayout(borderLayout);
//        super.add(buttons[0]); //여기서 add는 JButton이다.
//        super.add(buttons[1]);
//        super.add(buttons[2]);
//        super.add(buttons[3]);
//        super.add(buttons[4]);

        //위의 주석에 대한 부분을 아래와 같이 수정할 수 있음
        for (int i = 0; i < buttons.length; i++) {
            add(buttons[i], directions[i]);
        }
    }
}
