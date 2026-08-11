package useful.ch16;

public class Demo4 {

//    @FunctionalInterface
//    interface MathOperation {
//        int operate(int x, int y);//추상 메서드 설계 완료!
//        //void run(); //추상 메서드 선언 -> 2가지 이상은 불가
//    }

    public static void main(String[] args) {
        //단계적으로 줄여쓰기(람다표현식)

        //1단계: 매개변수 타입 생략 가능 -> 컴파일러가 타입 추론이 가능하기 때문, MathOperation에 메서드가 하나이기 때문
        MathOperation add = (x, y) -> {
            return x + y;
        };

        //2단계: 중괄호와 리턴 타입 생략
        MathOperation substract = (x, y) -> x - y;

        //주의! 만약 여러줄이 필요하다면 중괄호와 return 그대로 써야한다.
        MathOperation divide = (x, y) -> {
            if (y == 0) {
                System.out.println("0으로 나눌 수 없습니다.");
                return 0;
            }
            return x / y;
        };
        System.out.println(add.operate(10,10));
        System.out.println(substract.operate(10,10));
        System.out.println(divide.operate(10,10));

    }//end of main
}//end of class
