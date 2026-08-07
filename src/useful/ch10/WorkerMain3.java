package useful.ch10;

public class WorkerMain3 {

    //main Thread가 동작을 지시한다!
    public static void main(String[] args) {
        System.out.println("---main Thread 시작!---");
        Worker3 worker3 = new Worker3();
        //tip) Thread을 동작시킬려면 무조건 Thread의 start();를 호출해야함
        //worker.start(); <---오류! start()가 없는 상태!

        //이를 위해 thread 생성!
        new Thread(worker3).start(); //메서드 체인 방식! 일회성

        System.out.println("main thread 종료!---");
    }//end of main
}//end of class
