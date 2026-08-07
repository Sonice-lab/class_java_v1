package useful.ch10;

//1. 쓰레드를 추가로 만들어서 사용하는 방법 - 상속 활용

public class Worker extends Thread {
    //샘플코드 작성
    String name;

    public Worker(String name) {
        this.name = name;
    }

    //약속(interface)되어 있는 부분 run() 추상메서드 안에서 작업자(쓰레드)에게
    //어떤 일을 시킬지 정의해주어야 한다.
    @Override //재정의 - 이거 하기로 약속한거야!
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("worker: " + name + " : " + i);

            try {//오류없이 작동할 수 있도록 예외 처리!
                Thread.sleep(1000);//1초간 딜레이 - 1초간 잠시 자고 알아서 일어날게!
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
