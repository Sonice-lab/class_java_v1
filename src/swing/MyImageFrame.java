package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class MyImageFrame extends JFrame {

    //JPanel jPanel;는 아래와 같이 속성을 선언할 것과 같음 -> JPanel을 상속한 클래스라 기능을 다 물려받았기 때문
    MyImagePanel myImagePanel;


    public MyImageFrame() {
        setTitle("중첩클래스 활용");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myImagePanel = new MyImagePanel();
        add(myImagePanel);
        setVisible(true);

    }

    //패널의 기능을 확장하고 싶음
    //1. 정적 내부 클래스 선언
    static class MyImagePanel extends JPanel {

        private Image image1;

        //생성자 만들기
        public MyImagePanel() {
            //객체를 생성하여 이미지로 돌려받기, 바이트 단위로 이미지를 읽어들이기
            image1 = new ImageIcon("image2.png").getImage();
        }

        @Override //의존 관계
        public void paint(Graphics g) {
            super.paint(g);


            g.drawImage(image1, 200, 200, 200, 200, null);
            g.drawString("이미지 게임", 200, 200);
            g.drawLine(100, 100, 300, 100);


        }
    }//end of inner class

    //테스트 코드 작성
    public static void main(String[] args) {
        new MyImageFrame();
    }

}//end of outer class
