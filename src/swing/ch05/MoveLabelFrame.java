package swing.ch05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//해결사항 1. 키보드에 따라서 움직이게 설정 - 완
//해결사항 2. 누르면 검은색, 떼면 하얀색 - 완
//해결사항 3. 키보드 리스너 등록해야함 - 완
//해결사항 4. 별이 이동할 때마다 이동 횟수를 프레임 타이틀에 표시해보세요. - 완
//해결사항 5. ESC 키를 누르면 별이 처음 위치(200, 200)로 돌아오게 해보세요. - 완

public class MoveLabelFrame extends JFrame {

    private JLabel label;
    private final int MOVE_STEP = 10;

    // sum과 count를 따로 쓸 필요 없이 하나의 변수로 관리하기
    private int moveCount = 0;

    public MoveLabelFrame() {
        initData();
        setInitLayout();
        addEventListener();
    }

    private void initData() {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("방향키로 별 움직이기 연습: 0");

        label = new JLabel("☆");
        label.setFont(new Font("맑은 고딕", Font.BOLD, 30));
        // 좌표기반 - 크기, 위치(직접 설정해야 함)
        label.setSize(50, 50); // 사이즈
        label.setLocation(200, 200); // 시작 위치
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("현재 횟수: " + moveCount + " 번", 50, 100);
    }

    private void setInitLayout() {
        setLayout(null); // null -> 좌표 기반
        add(label);
        setVisible(true);
    }

    private void addEventListener() {
        // 익명 내부 클래스로 구현하는 방식으로 오버라이딩 --> 호출과 동시에 이벤트 리스터 등록 처리가 됨
        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                int x = label.getX();
                int y = label.getY();

                // 해결사항 2. 누르면 검은색
                label.setText("★");

                // 상태 변화를 체크할 변수 선언 (누락되었던 부분)
                boolean isMoved = false;

                // 해결사항 1. 키보드에 따라서 움직이게 설정
                if (keyCode == KeyEvent.VK_UP) {
                    label.setLocation(x, y - MOVE_STEP);
                    moveCount++;
                    isMoved = true;
                } else if (keyCode == KeyEvent.VK_LEFT) {
                    label.setLocation(x - MOVE_STEP, y);
                    moveCount++;
                    isMoved = true;
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    label.setLocation(x + MOVE_STEP, y);
                    moveCount++;
                    isMoved = true;
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    label.setLocation(x, y + MOVE_STEP);
                    moveCount++;
                    isMoved = true;
                }
                // 해결사항 5. ESC 키를 누르면 별이 처음 위치(200, 200)로 돌아오게 해보세요.
                else if (keyCode == KeyEvent.VK_ESCAPE) {
                    label.setLocation(200, 200); // 처음 좌표로 이동
                    moveCount = 0; // 횟수도 다시 0으로 초기화
                    isMoved = true;
                }

                // 방향키나 ESC가 눌려 상태가 변했을 때만 화면 갱신
                if (isMoved) {
                    // 프레임 타이틀 업데이트
                    setTitle("방향키로 별 움직이기 연습: " + moveCount);

                    // [핵심] 변경된 횟수를 화면에 다시 그리도록 강제 요청
                    repaint();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // 해결사항 2. 떼면 하얀색
                label.setText("☆");
            }
        });
    }

    public static void main(String[] args) {
        new MoveLabelFrame();
    } // end of main
}