package swing.ch02;

import javax.swing.*;
import java.awt.*;

public class Mycomponent extends JFrame {

    private JButton button;
    private JLabel label;//글자를 화면에 표현하고 싶을 때, 이미지로 꾸미기 가능
    private JTextField textField;
    private JPasswordField passwordField;
    private JCheckBox checkBox;

    //get/set
    public JTextField getTextField(){
        return textField;
    }

    public Mycomponent() {
        setTitle("컴포넌트 확인");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //static 상수
    }


    private void initData() {
        //속성 초기화 목적으로 사용
        button = new JButton("버튼1");
        label = new JLabel("글자나 이미지 아이콘 등을 사용");
        textField = new JTextField("아이디를 입력하세요.", 10);
        passwordField = new JPasswordField("비밀번호를 입력하세요.", 10);
        checkBox = new JCheckBox("동의");
    }


    private void setInitLayout() {
        //수평으로 배치
        //객체 간의 간격 띄우기 > FlowLayout.LEFT, 50, 5) > 왼쪽 정렬(orLEADING)
        //객체 간의 간격 띄우기 > FlowLayout.TRAILING, 50, 100 > 오른쪽 정렬(수직으로 간격 100으로 조정)
        //1.공식 문서를 보기
        //2.원시 코드 탐색(해당 메서드에 커서 > Ctrl + 좌클릭)
        setLayout(new FlowLayout(FlowLayout.TRAILING, 50, 100));//super. 생략 가능 --> FlowLayout은 배치 관리자
        add(button);
        add(label);
        add(textField);
        add(passwordField);
        add(checkBox);

        //화면에 보일 수 있도록 설정
        setVisible(true);
    }

    //템플릿 메서드 설계
    public final void run() {
        initData();
        setInitLayout();
    }
}
