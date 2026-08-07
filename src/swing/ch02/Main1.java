package swing.ch02;

import javax.swing.*;

public class Main1 {
    public static void main(String[] args) {
        //new Mycomponent(); //캡슐화가 있어서 생성자로 불러올 수 없음
        Mycomponent myComponent = new Mycomponent();
        myComponent.run();
        //문제 1. 애초에 '홍길동'이라고 넣어두고 싶어요!
        //힌트 - 메인 함수에서 텍스트 필드에 접근해서 객체 안에 문자열 값을 코드로 주입해보기!
        JTextField field1 = myComponent.getTextField();//field1에는 주소값이 담겨있음
        field1.setText("홍길동");
    }//end of main
}//end of class
