package swing.ch05;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventListenerFrame extends JFrame {

    private final int FRAME_SIZE = 500;
    private JTextArea textArea;

    public KeyEventListenerFrame() {
        initData();
        setInitLayout();
        addEventListener();
    }

    private void initData() {
        setSize(FRAME_SIZE, FRAME_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);//사용자가 마우스로 크기를 임의로 조정할 수 없도록 함

        textArea = new JTextArea();
    }

    private void setInitLayout() {
        add(textArea);
        setVisible(true);
    }

    private void addEventListener() {
        //익명 내부 클래스로 구현하는 방식으로 오버라이딩 ---> 호출과 동시에 이벤트 리스너 등록 처리 완료!
        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("키 누름: " + e.getKeyCode());

                //도전 과제 - 키보드 입력 이벤트를 받아서 위 쪽 화살표면 위쪽 화살표 출력
                //위쪽 화살표면 - 위쪽 화살표 출력
                //아래쪽 화살표면 - 아래쪽 화살표 출력
                //오른쪽 화살표면 - 오른쪽 화살표 출력
                //왼쪽 화살표면 - 왼쪽 화살표 출력
                //textArea <--글자와 이모지 출력(단, 이전 내용이 사라지면 안됨)

                System.out.println(e.getKeyCode());
                if (e.getKeyCode() == KeyEvent.VK_UP) {//상수로 처리
                    System.out.println("위쪽으로 눌러짐");
                    textArea.append("위쪽⬆️\n");//기존에 작성했던 부분이 덮여쓰여지지 않고 살려야함
                } else if (e.getKeyCode() ==KeyEvent.VK_LEFT) {
                    System.out.println("왼쪽으로 눌러짐");
                    textArea.append("왼쪽⬅️\n");
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    System.out.println("오른쪽으로 눌러짐");
                    textArea.append("오른쪽➡️\n");
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    System.out.println("아래쪽으로 눌러짐");
                    textArea.append("아래쪽⬇️\n");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyReleased 발생: " + e.getKeyCode());
            }
        });
    }

    public static void main(String[] args) {
        new KeyEventListenerFrame();
    }

}
