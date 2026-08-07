package swing.ch01;

import javax.swing.*;
import java.awt.*;

//연관 관계 중 합성관계에 속한다.
//문제) 배열을 활용해서 코드를 수정하세요.(배열로 풀어내기)
public class MyFrame extends JFrame {

    //1. 문자열로 배열을 사용한다. --> 배열 선언
    private JButton[] buttons = new JButton[3];


    public MyFrame() {

        super.setTitle("배치 관리자 연습");
        super.setSize(600, 300);
        super.setVisible(true);
        initData(); //main 메서드 실행하면 무조건 initdata도 호출하게 됨
        //initData();을 주석처리를 하게 될 경우 NullPointerException 발생 --> 객체를 생성하지 않았거나 가리키는 객체가 없을 때 발생
        setInitLayout();
    }

    //메서드 작성
    public void initData() {
        //2. 인덱스 연산자를 활용하여 값을 초기화
//        buttons[0] = new JButton("버튼1");
//        buttons[1] = new JButton("버튼2");
//        buttons[2] = new JButton("버튼3");

        //위의 주석에 대한 부분을 아래와 같이 수정할 수 있음
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("버튼" + (i + 1));
        }
    }

    public void setInitLayout() {
        //배치 관리자 선언
        FlowLayout flowLayout = new FlowLayout();
        //컴포넌트들을 수평, 수직으로 프레임을 배치해 주는 녀석이다.
        super.setLayout(flowLayout);
        super.add(buttons[0]); //여기서 add는 JButton의 기능이다.
        super.add(buttons[1]);
        super.add(buttons[2]);

        for (int i = 0; i < buttons.length; i++) {
            add(buttons[i]);
        }
    }

    //테스트 코드 작성
    public static void main(String[] args) {
        new MyFrame(); //생성자 호출 -> 생성자에 있는 로직이 동작 한다.

    }//end of main

}//end of class
