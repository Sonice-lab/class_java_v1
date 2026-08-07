package useful.ch09;

public class OuterClass2 {
    private static int num = 10;

    //Inner Class 종류 2. 정적 내부 클래스 - 활용도 높음!
    static class InnerClass {
        public void display() {
            System.out.println("num: " + num); //인스턴스 변수 출력 불가, static이 붙어야 출력 가능!

        }
    }

    public static void main(String[] args) {
        //1. 멤버 내부 클래스
        // - 외부 클래스와 강하게 연결된 상태
        // - 외부 클래스가 생성되어야 내부 클래스를 호출할 수 있다.

        //2. 정적 내부 클래스 - 웹 개발 프로그래밍시 자주 활용!
        // - 외부 클래스와 이름만 묶인 상태
        // - 외부 객체 생성없이도 생성이 가능하다.🌟🌟🌟
        OuterClass2.InnerClass innerClass = new OuterClass2.InnerClass(); //정석
        innerClass.display();
    }
}
