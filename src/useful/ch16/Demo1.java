package useful.ch16;

public class Demo1 {

    public static void main(String[] args) {
        //1. 람다 표현식에 대해 알아보자. -> 줄여쓰기, 코드의 간소화
        //자바는 타입 언어이다. 컴파일은 타입 추론이 가능하기때문에 코드를 간략하게 작성할 수 있다.

        new Thread(new Runnable() {// Thread  안에는 Run이 있다는 것을 컴파일은 추론할 수 있다.
            @Override
            public void run() {
                System.out.println("작업자가 해야할 일을 정의합니다.");
            }
        }).start();

        //2. 위 코드를 람다식으로 바꿔보자.
        new Thread(() -> System.out.println("여기도 작업자가 해야할 일을 정의합니다.")).start();

        //3. 자바 컴파일러는 타입 추론이 가능하다.
        new Thread(() -> System.out.println("작업자가 해야할 일을 정의합니다.")).start();//여기서 ->는 구분자를 의미한다.

        int x = 10;
        var y = 100; //var <-- 요즘 허용 가능한 문법
    }
}
