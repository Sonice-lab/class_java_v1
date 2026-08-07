package swing.ch01;

import javax.swing.*;
import java.awt.*;

public class MyBoarderFrame extends JFrame {
    //배열로 변경
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private BorderLayout borderLayout;

    public MyBoarderFrame() {

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
        button1 = new JButton("버튼1");
        button2 = new JButton("버튼2");
        button3 = new JButton("버튼3");
        button4 = new JButton("버튼4");
        button5 = new JButton("버튼5");

        borderLayout = new BorderLayout(); //객체 생성
    }

    public void setInitLayout() {
        //배치 관리자 선정을 하고 Frame 설정해보자.
        setLayout(borderLayout);//Frame 에 배치관리자 설정
        //이제 배치만 하면됨
        //border레이아웃은 add할 때 동 서 남 북 가운데를 명시해주어야 함
        //배열과 for문 활용 - String
        add(button1, BorderLayout.NORTH);
        add(button2, BorderLayout.SOUTH);
        add(button3, BorderLayout.CENTER);
        add(button4, BorderLayout.WEST);
        add(button5, BorderLayout.EAST);
    }
}
