package swing.ch06;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


//1. 화면 밖을 나가지 않도록 설정 > 이미지가 특정 좌표 이상으로 나가지 않도록 설정 - 완
//2. 왼쪽 방향키를 누르면 이미지의 고개가 왼쪽을 보도록 - 완
//3. 오른쪽 방향키를 누르면 이미지의 고개가 오른쪽을 보도록 - 완
//4. Thread와 Enemy 이미지를 활용하여 Enemy가 자율적으로 돌아다니도록 만들기

public class MyFrame2 extends JFrame {
    private JLabel backgroundMap;
    private JLabel player;
    private JLabel enemy;

    //player 이미지 L, R
    ImageIcon playerIconL = new ImageIcon("images/playerL.png");
    ImageIcon playerIconR = new ImageIcon("images/playerR.png");
    ImageIcon enemyIconL = new ImageIcon("images/enemyL.png");
    ImageIcon enemyIconR = new ImageIcon("images/enemyR.png");

    //이동 설정 값
    private final int MOVE_STEP = 10; //플레이어 이동 픽셀

    public MyFrame2() {
        initData();
        setInitLayout();
        addEventListener();
        //스레드 실행 메서드 호출
        initThread();
    }

    private void initData() {
        setTitle("이미지 겹치기 연습");
        setSize(1000, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 배경 이미지 설정해보기
        ImageIcon backgroundIcon = new ImageIcon("images/backgroundMap.png");
        backgroundMap = new JLabel(backgroundIcon);
        // 배치 관리자 좌표 ==> 컴포넌트 사이즈와 위치를 직접 지정해야 한다.
        backgroundMap.setSize(1000, 600);
        backgroundMap.setLocation(0, 0);

        // 플레이어 이미지 초기화
        playerIconL = new ImageIcon("images/playerL.png");
        player = new JLabel(playerIconL);
        player.setSize(100, 100);
        player.setLocation(200, 510);

        //에너미 이미지 초기화
        //enemyIconR = new ImageIcon("images/enemyR.png");
        enemy = new JLabel(enemyIconR);
        enemy.setSize(100, 150);
        enemy.setLocation(300, 250);

    }

    private void setInitLayout() {
        // 루트 패널에 설정
        setLayout(null);
        add(backgroundMap);

        backgroundMap.add(player);
        backgroundMap.add(enemy);
        setVisible(true);
    }

    private void addEventListener() {
        this.addKeyListener(new KeyListener() {


            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int x = player.getLocation().x;
                int y = player.getLocation().y;

                // 제어문 - switch
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        if (y > 0) {
                            y -= MOVE_STEP;
                        }break;
                    case KeyEvent.VK_LEFT:
                        player.setIcon(playerIconL);
                        if (x > 0) {
                            x -= MOVE_STEP;
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        player.setIcon(playerIconR);
                        if (x < 900) {
                            x += MOVE_STEP;
                        }break;
                    case KeyEvent.VK_DOWN:
                        if(y < 500){
                            y += MOVE_STEP;
                            break;
                        }
                    default:
                        return;
                }
                //화살표 이벤트를 받아서 다시 플레이어의 좌표값 지정
                player.setLocation(x, y);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    // --- 추가된 부분: Enemy 자율 주행 스레드 메서드 ---
    private void initThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Enemy의 이동 속도와 방향 (양수면 오른쪽, 음수면 왼쪽)
                int xspeed = 5;
                int ySpeed = 3; // 양수면 아래, 음수면 위 (속도를 다르게 설정하면 대각선 운동)

                while (true) {
                    // 1. 현재 좌표 가져오기
                    int x = enemy.getLocation().x;
                    int y = enemy.getLocation().y;

                    // 2. 좌표 변경 (이동)
                    x += xspeed;
                    y += ySpeed;

                    // 3. 벽에 부딪혔을 때 방향 전환
                    // (프레임 가로 1000 - 적 크기 100 = 최대 x좌표 900)
                    if (x > 900) {
                        xspeed = -5; // 왼쪽으로 이동 방향 변경
                    } else if (x < 0) {
                        xspeed = 5;  // 오른쪽으로 이동 방향 변경
                    }

                    // --- 수정된 부분: [세로 벽 튕기기] 로직 추가 ---
                    // 플레이어의 이동 제한 좌표인 y=500을 동일하게 적용
                    if (y > 500) {
                        ySpeed = -3; // 위로 이동 방향 변경
                    } else if (y < 0) {
                        ySpeed = 3;  // 아래로 이동 방향 변경
                    }

                    // 4. 새로운 좌표 적용
                    enemy.setLocation(x, y);

                    // 5. 스레드 대기 (속도 조절)
                    try {
                        Thread.sleep(20); // 0.02초 대기
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    // 테스트 코드
    public static void main(String[] args) {
        new MyFrame2();
    }
}

