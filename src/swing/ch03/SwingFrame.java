package swing.ch03;

import swing.MyImageFrame;

import javax.swing.*;
import java.awt.*;

//중첩 클래스 활용
public class SwingFrame extends JFrame {

    SwingFramePanel swingFramePanel;

    //규격 설정
    public SwingFrame(){
        setTitle("중첩클래스 활용");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        swingFramePanel = new SwingFramePanel();
        add(swingFramePanel);
        setVisible(true);
    }

    //패널의 기능을 확장해보자.
    //1. 정적 내부 클래스 선언
    static class SwingFramePanel extends JPanel{

        private Image image2;

        //생성자 만들기
        public SwingFramePanel(){
            //객체를 생성하여 이미지로 돌려받기, 바이트 단위로 이미지를 읽어들이기
            image2 = new ImageIcon("image2.png").getImage();
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);

            g.drawImage(image2,200,200,300,300,null);
            g.drawString("이미지게임", 30,30);
            //g.drawLine(100,100,300,100);
            //g.drawLine(150,150,300,100);

            // 1. 지붕 (Roof)
            g.drawLine(100, 150, 300, 150); // 지붕 밑변
            g.drawLine(100, 150, 200, 50);  // 지붕 왼쪽 대각선
            g.drawLine(300, 150, 200, 50);  // 지붕 오른쪽 대각선

            // 2. 집 몸통 (House Body)
            g.drawLine(120, 150, 120, 300); // 왼쪽 벽
            g.drawLine(280, 150, 280, 300); // 오른쪽 벽
            g.drawLine(120, 300, 280, 300); // 바닥

// 3. 창문 (Window) - 왼쪽
            g.drawLine(140, 180, 190, 180); // 창문 윗변
            g.drawLine(140, 230, 190, 230); // 창문 아랫변
            g.drawLine(140, 180, 140, 230); // 창문 왼쪽 벽
            g.drawLine(190, 180, 190, 230); // 창문 오른쪽 벽
            g.drawLine(165, 180, 165, 230); // 창문 세로 프레임
            g.drawLine(140, 205, 190, 205); // 창문 가로 프레임

// 4. 문 (Door) - 오른쪽
            g.drawLine(220, 230, 260, 230); // 문 윗변
            g.drawLine(220, 230, 220, 300); // 문 왼쪽 벽
            g.drawLine(260, 230, 260, 300); // 문 오른쪽 벽

        }
    }//end of inner class

    //테스트 코드 작성
    public static void main(String[] args) {
        new SwingFrame();
    }
}
