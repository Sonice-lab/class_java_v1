package useful.ch09;

//InnerClass 종류 4. 익명 내부 클래스 사용해보기
public class OuterClass4 {

    Runnable runnable;

    //생성자
    public OuterClass4() {
        // 익명 내부 클래스를 사용해서 인터페이스나 추상 클래스를 마치 구현 실제 객체처럼 생성할 수 있다.
        // 익명 구현 (내부) 클래스 !!! --> 수업에서의 약속, 공식 명사 x
        //runnable = new Runnable(); --> 안됨!
//        runnable = new Runnable(){ //이름이 생긴 버전
//            @Override
//            public void run() {//추상 메서드를 일반 메서드로 구현하면서 마치 객체처럼 설계함, 부를 수 있는 이름 없음 > 익명 내부클래스
//                System.out.println("동작을 정의할 수 있다.");
//            }
//        };
        new Runnable(){//이름이 없는 버전
            @Override
            public void run() {//추상 메서드를 일반 메서드로 구현하면서 마치 객체처럼 설계함, 부를 수 있는 이름 없음 > 익명 내부클래스
                System.out.println("동작을 정의할 수 있다.");
            }
        };

    }

    //메인 함수
    public static void main(String[] args) {
        new OuterClass4();//이름이 없는 상태이기에, 이름을 부를 수 없음.(익명 클래스로 생성)

    }//end of main
}//end of class
