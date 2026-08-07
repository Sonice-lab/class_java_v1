package useful.ch10;

public class WorkerMain2 {

    //메인 Thread가 동작을 지시한다!
    public static void main(String[] args) {
        System.out.println("---main thread 시작!---");

        Worker2 worker2 = new Worker2();
        //tip) Thread를 동작 시킬려면 무조건 Thread의 start();를 호출해야 함
        //worker2.start(); <--- 오류! start()가 없는 상태!

        //이를 위해 thread 생성
        new Thread(worker2).start();//메서드 체인 방식 -->방법 1) start를 바로 호출시킨다!
        //방법 2)
        //Thread t = new Thread(worker2);
        //t.start();

        System.out.println("---main thread 종료!---");
    }//end of main
}//end of class
