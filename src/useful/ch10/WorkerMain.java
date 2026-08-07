package useful.ch10;

public class WorkerMain {
    //메인 Thread
    public static void main(String[] args) {
        // 2. 사용하는 방법
        System.out.println("----실제로 동작하는 main Thread가 일을 합니다. main Thread 시작!");
        System.out.println(Thread.currentThread());

        //필요하다면 작업자(Thread)를 만들어서 작업을 시킬 수 있음!
        Worker worker1 = new Worker("작업자1"); //main thread가 객체를 생성!

        //약속. Thread에게 위임한 일을 시작시킬려면 Thread 안에 있는 start() 메서드를
        //반드시 호출해야 run() 메서드 안에 정의된 로직이 시작된다.
        worker1.start();//main thread가 동작을 시킴
                        // 너가 받은 일을 시작하도록 해! --> main thread가 아닌 worker thread가 일을 시작!

        System.out.println("-----------------main Thread 종료-----------------"); //main thread는 worker thread에게 일을 시키고 바로 종료!

        //다중 Thread는 왜 필요한가?
        //예시) 인터넷에서 다운로드를 받아도 파일을 다운 받는 동안 다른 동작을 수행할 수 있다.
    }
}
