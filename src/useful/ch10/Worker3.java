package useful.ch10;
//연습!
public class Worker3 implements Runnable {

    //run() - 미리 약속되어 있는 부분, 위임시키고자하는 일을 명시하는 곳

    @Override
    public void run() {
        int i;
        for(i=0;i<50;i++){
            System.out.println(i + "\t");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
