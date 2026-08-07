package swing.ch01;

import javax.swing.*;
import java.awt.*;

//연관 관계 중 합성관계에 속한다.
public class MyFrameVer_2 extends JFrame {

    private JButton button1;
    private JButton button2;
    private JButton button3;

    //문제 1. JButton 객체를 JFrame 객체에 하나 더 올려보자.
    //문제 2. 배열을 활용해서 코드를 수정하세요.

    public MyFrameVer_2() {

        super.setTitle("배치 관리자 연습");
        super.setSize(600, 300);
        super.setVisible(true);

        initData(); //main 메서드 실행하면 무조건 initdata도 호출하게 됨
        setInitLayout();
    }

    //메서드 작성
    public void initData(){
        button1 = new JButton("button1");
        button2 = new JButton("button2");
        button3 = new JButton("버튼3");


    }

    public void setInitLayout(){
        //배치 관리자 선언
        FlowLayout flowLayout = new FlowLayout();
        //컴포넌트들을 수평, 수직으로 프레임을 배치해 주는 녀석이다.
        super.setLayout(flowLayout);
        super.add(button1);
        super.add(button2);
        add(button3);
    }

    //테스트 코드 작성
    public static void main(String[] args) {
        MyFrameVer_2 frame1 = new MyFrameVer_2(); //객체 생성

    }//end of main

}//end of class
