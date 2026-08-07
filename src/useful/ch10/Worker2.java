package useful.ch10;

//2. Thread를 사용하는 방법 2번째! - Runnable 인터페이스를 구현해서 만들 수 있다.
//다중 상속의 효과를 보기 위해서는 인터페이스를 활용할 수 있다.
public class Worker2 implements Runnable {

    //run() - 미리 약속되어있는 부분, 위임시키고자하는 일을 명시하는 곳
    @Override
    public void run() {
        int i;
        for (i = 0; i < 200; i++) {
            System.out.println(i + "\t");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
