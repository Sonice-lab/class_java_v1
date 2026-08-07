package useful.ch09;
//클래스 안에 클래스를 선언할 수 있음! - Inner Class(중첩 클래스)

/**
 * 내부 클래스란?
 * 한 클래스 내부에 선언된 클래스를 말함
 * 내부 클래스를 선언하면 보통 외부 클래스와 연관이 있는 경우,
 * 클래스가 많고 다른 곳에서 거의 사용할 일이 없을 경우
 * 내부에 클래스를 선언하기도 한다.
 *내부 클래스의 종류에는 4가지가 있다.
 */
public class OuterClass1 {
    private int num = 10;

    //장점 - 외부에 있는 속성이 상위에 있기 때문에 바로 사용할 수 있음
    //종류 1. 멤버 내부 클래스 - 활용도 낮음
    class InnerClass{
        public void display(){
            System.out.println("num: " + num);
        }
    }//end of inner class

    public static void main(String[] args) {
        //내부 클래스가 일반 멤버 클래스로 설계된 경우
        //외부 클래스가 먼저 객체로 생성이 되고 내부 클래스를 생성할 수 있다.
        OuterClass1 outerClass1 = new OuterClass1();
        OuterClass1.InnerClass innerClass = outerClass1.new InnerClass(); //데이터 타입이 됨
        innerClass.display();
    }//end of main
}//end of outer class
