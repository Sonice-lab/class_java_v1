package useful.ch16;

//자바 API에서 제공해주는 함수형 인터페이스가 아닌
// 본인이 직접 설계하고 싶다면 함수형 인터페이스를 만들어야 한다.
//함수형 인터페이스는 단 하나의 추상메서드만 가진다. -> 약속

//@FunctionalInterface은 인터페이스 안에 오진 단 하나의 추상메서드만 가질 수 있도록 강제한다.
// 사유: 컴파일러는 타입을 추론해야하는데 여러개의 메서드가 있을 경우 추론할 수 없기 때문!

//@FunctionalInterface
//interface MathOperation {
//    int operate(int x, int y);//추상 메서드 설계 완료!
//    //void run(); //추상 메서드 선언 -> 2가지 이상은 불가
//}


public class Demo3 {
    public static void main(String[] args) {

        //함수형 인터페이스 타입에 람다식을 만들 수 있다.
        MathOperation add = (int x, int y) -> {return x + y; };//return 키워드에는 항상 세미콜론이 붙는다.
        MathOperation substract = (int x, int y) -> {return x - y; };//return 키워드에는 항상 세미콜론이 붙는다.
        MathOperation multiple = (int x, int y) -> {return x * y; };//return 키워드에는 항상 세미콜론이 붙는다.
        MathOperation divide = (int x, int y) -> {return x / y; };//return 키워드에는 항상 세미콜론이 붙는다.

        //주의: 호출할 때는 참조 변수의 이름이 아닌 인터페이스에 정의된 메서드 이름을 호출해야 동작함
        //사전에 만들어져 있어야 함
        System.out.println("10 + 10: " + add.operate(10,10));
        System.out.println("10 - 10: " + substract.operate(10,10));
        System.out.println("10 * 10: " + multiple.operate(10,10));
        System.out.println("10 / 10: " + divide.operate(10,10));

    }//end of main
}//end of class
