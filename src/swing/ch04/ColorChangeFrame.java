package swing.ch04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChangeFrame extends JFrame implements ActionListener {

    //ActionListener의 추상 메서드를 구현 메서드로 재정의
    //미리 약속되어있는 메서드
    //즉, 어떤 이벤트가 발생하면
    //이 해당하는 메서드가 동작되도록 설계되어있음(= 콜백 메서드)
    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("actionPerformed() 메서드 호출 (콜백)");
        //System.out.println(e.getSource());//다양한 정보 표시(=주소값)
        //JButton selectedButton = (JButton) e.getSource();--> 간단하게 아래와 같이 표현할 수 있음
        //selectedButton.setText("이벤트 발생");//해당 버튼을 눌렀을 때 "이벤트 발생" 표시
        //해결하기! 버튼을 눌러서 배경색을 검정색으로 바꾸기
        Object source = e.getSource();
        if(source == button1){
            panel1.setBackground(Color.BLACK);
        } else if (source ==button2) {
            panel1.setBackground(Color.YELLOW);
        }
    }

    private JButton button1;
    private JButton button2;

    private JPanel panel1;

    public ColorChangeFrame() {
        initData();
        setInitLayout();
        addEventListener();
    }

    private void initData() {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button1 = new JButton("button1");
        button2 = new JButton("button2");
        panel1 = new JPanel();
    }

    private void setInitLayout() {
        setLayout(new BorderLayout());
        panel1.setBackground(Color.yellow);
        panel1.add(button1);
        panel1.add(button2);

        add(panel1);
        setVisible(true);
    }

    private void addEventListener() {
        //button1 객체에 이벤트 리스너 등록 --> 약속 --> actionPerformed() 메서드가 콜백함
        button1.addActionListener(this);
        button2.addActionListener(this);
    }

    //메인 함수(메인 메서드)
    public static void main(String[] args) {
        new ColorChangeFrame();

        //일반적으로 메서드를 호출하는 방법 a.abc(); <--
        //이벤트 리스너를 등록할 경우, 어떤 이벤트가 발생하면 콜백이 불러져서 동작함 <--- 콜백 메서드
        //비유예시) 그네를 타고 있는데 16시까지 집에 가야하는 상황, 일반 메서드 - 계속해서 시간 확인, 콜백 메서드 - 알람을 맞춰둠
    }//end of main

}
